package com.gaofei.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;

/**
 * java -Dorg.xml.sax.driver=com.example.xml.SAXDriver MySAXApp sample.xml
 * Created by GaoQingming on 2018/12/6 0006.
 */
public class MySAXApp extends DefaultHandler {

    public static void main(String args[])
            throws Exception {
        XMLReader xr = XMLReaderFactory.createXMLReader();
        MySAXApp handler = new MySAXApp();
        xr.setContentHandler(handler);
        xr.setErrorHandler(handler);

        // Parse each file provided on the
        // command line.
        FileReader r = new FileReader("E:\\workspace\\demo\\info-demo\\src\\main\\java\\com\\gaofei\\xml\\sax\\server.xml");
        xr.parse(new InputSource(r));
    }

    /**
     *
     * @param uri xsd 的xmlns
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("".equals (uri))
            System.out.println("Start element: " + qName);
        else
            System.out.println("Start element: {" + uri + "}" + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("".equals (uri))
            System.out.println("End element: " + qName);
        else
            System.out.println("End element:   {" + uri + "}" + localName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end document");
    }

    public MySAXApp() {
        super();
    }
}
