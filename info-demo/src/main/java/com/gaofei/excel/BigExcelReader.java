package com.gaofei.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.gaofei.Date.DateUtil;
import com.gaofei.number.NumberUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author yichang
 * @date 2020/08/19
 */
public class BigExcelReader {
    private XSSFReader xssfReader;
    //获取一行时最小数组长度
    private final int minColumnCount;
    private int currentRow = -1;
    private int sheetIndex = -1;
    private String[] record;
    private int thisColumnIndex = -1;
    // 日期标志
    private boolean dateFlag;
    private boolean isTElement;
    private RowReader rowReader;
    /**
     * 单元格格式
     */
    private StylesTable stylesTable;

    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    /**
     * 科学计数法的正则
     */
    private static String SCIENTIFIC_FORMAT_PATTERN = "^\\d+.?\\d*[Ee][+-]?\\d+$";

    public void setRowReader(RowReader rowReader) {
        this.rowReader = rowReader;
    }

    /**
     * 构造方法
     */
    public BigExcelReader(String filename, int minCols) throws Exception {
        if (StringUtils.isEmpty(filename)) {
            throw new Exception("文件名不能空");
        }
        this.minColumnCount = minCols;
        record = new String[this.minColumnCount];
        OPCPackage pkg = OPCPackage.open(filename);
        init(pkg);

    }

    public BigExcelReader(InputStream is, int minCols) throws Exception {
        if (null == is) {
            throw new Exception("文件不能空");
        }
        this.minColumnCount = minCols;
        record = new String[this.minColumnCount];
        OPCPackage pkg = OPCPackage.open(is);
        init(pkg);
    }

    private void init(OPCPackage pkg) throws IOException, OpenXML4JException {
        xssfReader = new XSSFReader(pkg);
    }

    /**
     * 获取sheet
     *
     * @throws Exception
     */
    public void process() throws Exception {
        SharedStringsTable sst = xssfReader.getSharedStringsTable();
        this.stylesTable = xssfReader.getStylesTable();
        XMLReader xmlReader = fetchSheetParser(sst);
        Iterator<InputStream> it = xssfReader.getSheetsData();
        while (it.hasNext()) {
            sheetIndex++;
            InputStream sheet = it.next();
            if (sheetIndex <= 0) {
                InputSource sheetSource = new InputSource(sheet);
                xmlReader.parse(sheetSource);
            }
            sheet.close();
        }
    }

    /**
     * 加载sax 解析器
     *
     * @param sst
     * @return
     * @throws SAXException
     */
    private XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
        ContentHandler handler = new PagingHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }

    /**
     * @see org.xml.sax.helpers.DefaultHandler javadocs
     */
    private class PagingHandler extends DefaultHandler {
        private SharedStringsTable sst;
        private String lastContents;
        private boolean nextIsString;
        private String index = null;

        private PagingHandler(SharedStringsTable sst) {
            this.sst = sst;
        }

        /**
         * 开始元素
         */
        @Override
        public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
            System.out.print("<" + name + ">");
            if (name.equals("row")) {
                currentRow++;
            }
            if (name.equals("c")) {
                nextIsString = false;
                dateFlag = false;

                index = attributes.getValue("r");
                int firstDigit = -1;
                for (int c = 0; c < index.length(); ++c) {
                    if (Character.isDigit(index.charAt(c))) {
                        firstDigit = c;
                        break;
                    }
                }
                thisColumnIndex = nameToColumn(index.substring(0, firstDigit));

                String cellType = attributes.getValue("t");
                if (cellType != null && cellType.equals("s")) {
                    nextIsString = true;
                } else {
                    nextIsString = false;
                }
                // 日期格式
                String cellNumberType = attributes.getValue("s");
                dateFlag = isDateFlag(cellNumberType);
            }
            lastContents = "";
        }

        /**
         * 获取value
         */
        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {
            if (nextIsString) {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
                nextIsString = false;
            }
            if ("v".equals(name)) {
                String value = lastContents.trim();
                value = value.equals("") ? "" : value;
                if(dateFlag){
                    value = getDateValue(value);
                }

                try {
                    value = adjustValue(value);
                } catch (Exception e) {
                }

                //防止下标越界
                if (thisColumnIndex < record.length) {
                    record[thisColumnIndex] = value;
                }
            } else {
                if (name.equals("row")) {
                    if (minColumnCount > 0) {
                        rowReader.getRows(sheetIndex, currentRow, record.clone());
                        for (int i = 0; i < record.length; i++) {
                            record[i] = null;
                        }
                    }
                }
            }
            System.out.print("</" + name + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            lastContents += new String(ch, start, length);
        }


        /**
         * 弥补精度丢失造成的问题,比如会显示69.900000000000006 或者 19.98999999999999
         * <p>
         * 处理莫名其妙的科学计数法问题,如7.0000000000000007E-2转换为 0.070
         *
         * <p>
         * 处理逻辑：首先判断是否为数字、是否包含小数点，
         * 然后看从倒数第二位开始，存在连续6个以上的0或者9，则认为存在精度丢失
         *
         * @param value
         * @return
         */
        public  String adjustValue(String value) {
            if (StringUtils.isBlank(value)) {
                return value;
            }
            value = value.trim();

            //如果是科学计数法，则转换为数字。如如7.0000000000000007E-2转换为 0.070000000000000007
            if (isScientificFormat(value)) {
                try {
                    value = new BigDecimal(value).setScale(4, BigDecimal.ROUND_HALF_UP).stripTrailingZeros()
                        .toPlainString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /**
             * 对数值精度进行修复。 如
             * 0.070000000000000007     --> 0.07
             * 69.900000000000006       --> 69.9
             * 19.98999999999999        --> 19.99
             * 14399.999999999998       --> 14400
             */
            if (value.length() > 2 && NumberUtil.isRealNumber(value) && value.contains(".")) {
                int zeroCount = 0;
                int nineCount = 0;

                for (int index = value.length() - 2; index > 0; index--) {
                    if (value.charAt(index) == '0' && nineCount == 0) {
                        zeroCount++;
                    } else if (value.charAt(index) == '9' && zeroCount == 0) {
                        nineCount++;
                    } else {
                        break;
                    }
                }
                if (zeroCount == 0 && nineCount > 6 || zeroCount > 6 && nineCount == 0) {
                    return removeNineAndZero(value);
                }
            }

            return value;
        }
    }

    /**
     * 判断是否科学计数法
     * @return
     */
    private boolean isScientificFormat(String value){
        if(StringUtils.isBlank(value)){
            return false;
        }
        Pattern pattern = Pattern.compile(SCIENTIFIC_FORMAT_PATTERN);
        return pattern.matcher(value).matches();
    }
    /**
     * 69.900000000000006       --> 69.9
     * 19.98999999999999        --> 19.99
     * 14399.999999999998       --> 14400
     *
     * @return
     */
    private static String removeNineAndZero(String str) {
        //从倒数第二位往前读，第一个非0且非9的数字下标
        int dotIndex = str.indexOf(".");
        if (dotIndex < 0) {
            return str;
        }
        int index = str.length() - 2;
        char origin = str.charAt(index);
        for (; index > dotIndex; index--) {
            char ch = str.charAt(index);
            if (ch != origin) {
                break;
            }
        }
        if (index < dotIndex) {
            return str;
        }
        int scale = index - dotIndex;
        return new BigDecimal(str).setScale(scale, RoundingMode.HALF_UP).toPlainString();
    }

    private boolean isDateFlag(String cellStyleStr) {
        if (StringUtils.isBlank(cellStyleStr) || !StringUtils.isNumeric(cellStyleStr)) {
            return false;
        }
        int styleIndex = Integer.parseInt(cellStyleStr);
        XSSFCellStyle style = this.stylesTable.getStyleAt(styleIndex);
        short format = style.getDataFormat();
        if (HSSFDateUtil.isADateFormat(format, style.getDataFormatString())) {
            return true;
        }
        return false;
    }

    private String getDateValue(String value) {
        if (StringUtils.isBlank(value)) {
            return value;
        }
        try {
            Double d = Double.parseDouble(value);
            Date date = HSSFDateUtil.getJavaDate(d);
            return DateUtil.formatDate(date);
        } catch (Exception e) {
            System.out.println(e);
            return value;
        }
    }
    private int nameToColumn(String name) {
        int column = -1;
        for (int i = 0; i < name.length(); ++i) {
            int c = name.charAt(i);
            column = (column + 1) * 26 + c - 'A';
        }
        return column;
    }

    public static void main(String[] args) throws Exception {

        DefaultRowReader rowReader = new DefaultRowReader();

        String folderStr = "/users/gaoqingming/learn";
        File folder= new File(folderStr);
        File[] files = folder.listFiles();
        for (File file:files){
            if (file.getName().endsWith(".xlsx")){
                System.out.println("处理文件:"+file.getName());
                FileInputStream fileInputStream = new FileInputStream(file);
                BigExcelReader reader = new BigExcelReader(fileInputStream, 90);
                reader.setRowReader(rowReader);
                reader.process();
            }
        }
    }


    public interface RowReader {
        void getRows(int sheetIndex, int curRow, String[] row);
    }

    public static class DefaultRowReader implements RowReader {

        private Integer curRow = -1;

        @Override
        public void getRows(int sheetIndex, int curRow, String[] row) {
            if (this.curRow != curRow) {
                System.out.print("sheet:" + sheetIndex + "-row:" + curRow + " ");
                for (String cell : row) {
                    System.out.print(cell + "  ");
                }
                System.out.println();
                this.curRow = curRow;
            }

        }
    }
}
