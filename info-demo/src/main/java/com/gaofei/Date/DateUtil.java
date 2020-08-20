package com.gaofei.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Months;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author yichang
 * @date 2020/08/19
 */
public class DateUtil {
    public static final String DATE_PATTERN_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYY_MM = "yyyy-MM";
    public static final String DATE_PATTERN_YYYY_MM_V2 = "yyyy_MM";
    public static final String DATE_PATTERN_YYYY_MM_DD= "yyyy-MM-dd";
    public static final String DATE_PATTERN_YYYY_MM_DD_CHINESE= "yyyy年MM月dd日";
    private static final long MILLSECONDS_ONE_MINUTE = 60 * 1000;

    private DateUtil () {
        throw new IllegalStateException("untility  class");
    }
    public static final String DATE_PATTERN_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN_YYYYMMDD_2 = "yyyyMMdd";
    public static final String DATE_PATTERN_YYYYMMDD_3 = "MM月dd日";

    public static Date toDate(Date date, String formatPattern) {
        String dateStr = formatDate(date, formatPattern);
        return parseDate(dateStr, formatPattern);
    }

    public static String formatDate(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfWeek().getDateTime().toString(DATE_PATTERN_YYYYMMDDHHMMSS);
    }

    public static String formatDate(Date date, String formatPattern) {
        if (date == null) {
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfWeek().getDateTime().toString(formatPattern);
    }

    public static Date parseDateCatchException(String dateStr, String formatPattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(formatPattern);
            return DateTime.parse(dateStr, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }


    public static Date addMinutes(Date date, int addMinutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(addMinutes).toDate();
    }

    public static Date addHours(Date date, int addHours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(addHours).toDate();
    }

    public static Date addDays(Date date, int addDays) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(addDays).toDate();
    }

    public static Date addMonths(Date date, int addMonths) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(addMonths).toDate();
    }

    public static Date addYears(Date date, int addYears) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(addYears).toDate();
    }

    public static int getInternalMonths(Date start, Date end) {
        LocalDate startLocalDate = toLocalDate(start);
        LocalDate endLocalDate = toLocalDate(end);

        int days = Days.daysBetween(startLocalDate, endLocalDate).getDays();
        int months = 0;
        if (days < 0) {
            if (days == -31) {
                months = 0 - Months.monthsBetween(endLocalDate, startLocalDate).getMonths();
            } else {
                months = -1 - Months.monthsBetween(endLocalDate, startLocalDate).getMonths();
            }
        } else {
            months = Months.monthsBetween(startLocalDate, endLocalDate).getMonths();
        }
        return months;
    }

    public static int getInternalDays(Date start, Date end) {
        LocalDate startLocalDate = toLocalDate(start);
        LocalDate endLocalDate = toLocalDate(end);
        return Days.daysBetween(startLocalDate, endLocalDate).getDays();
    }

    public static int getInternalHours(Date start, Date end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        long between_hours=(time2-time1)/(1000*3600);
        return Integer.parseInt(String.valueOf(between_hours));
    }

    public static int getInternalMinutes(Date start, Date end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        long between_minutes=(time2-time1)/(1000*60);
        return Integer.parseInt(String.valueOf(between_minutes));
    }

    public static int getInternalYears(Date start, Date end) {
        LocalDate startLocalDate = toLocalDate(start);
        LocalDate endLocalDate = toLocalDate(end);
        return Years.yearsBetween(startLocalDate, endLocalDate).getYears();
    }

    public static int getInternalSeconds(Date start, Date end) {
        LocalDate startLocalDate = toLocalDate(start);
        LocalDate endLocalDate = toLocalDate(end);
        return Days.daysBetween(startLocalDate, endLocalDate).toStandardSeconds().getSeconds();
    }

    public static LocalDate toLocalDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return new LocalDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static int getYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getYear();
    }

    public static int getMonthOfYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getMonthOfYear();
    }

    public static int getMinuteOfHour(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getMinuteOfHour();
    }

    public static Date getLastDayPreMonth(Date date) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }

    public static Integer getDateVersion(Date date) {
        DateTimeFormatter formatterNum = DateTimeFormat.forPattern("yyyyMMdd");
        DateTime dateTime = new DateTime(date);
        return Integer.parseInt(dateTime.dayOfYear().getDateTime().toString(formatterNum));
    }

    /**
     * 取当天零点零分零秒
     */
    public static Date getTodayStart() {
        return getDayStart(new Date());
    }

    /**
     * @param date
     * @return
     */
    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //如果没有这种设定的话回去系统的当期的时间
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getTodayEnd() {
        return getDayEnd(new Date());
    }

    public static Date getDayBeforeEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public static Date getDayEnd(Date date) {
        LocalDateTime localDateTime = LocalDateTime.fromDateFields(date);
        return localDateTime.withHourOfDay(23)
            .withMinuteOfHour(59)
            .withSecondOfMinute(59)
            .toDate();
    }

    public static long getSecondsSpan(Date date1, Date date2) {
        long a = date1.getTime();
        long b = date2.getTime();
        long c = (long) ((a - b) / 1000);
        return Math.abs(c);
    }


    /**
     * 获取第一天第一小时第一份第一秒
     *
     * @return
     */
    public static Date getMonthBegin(Date date) {
        return parseDate(formatDate(date, "yyyy-MM-01"), "yyyy-MM-dd");
    }

    public static Date getDayBegin(Date date) {

        return parseDate(formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd");
    }


    /**
     * 计算两个日期相差天数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static List<Date> dateSplit(Date startDate, Date endDate) throws Exception {
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        if (startTime > endTime) {
            throw new Exception("开始时间应该在结束时间之后");
        }
        Long spi = endDate.getTime() - startDate.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

        List<Date> dateList = new ArrayList<Date>();
        dateList.add(startDate);
        for (int i = 1; i <= step; i++) {
            dateList.add(new Date(dateList.get(i - 1).getTime()
                + (24 * 60 * 60 * 1000)));// 比上一天加一
        }
        return dateList;
    }


    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 获取前一天的时间
     *
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取下一天的时间
     *
     * @param date
     * @return
     */
    public static Date getTheNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 抽取日期字符串如2020-12-31
     * @param dateTimeString
     * @return
     */
    public static String parseDateStringFromDateTime(String dateTimeString) {
        if (org.apache.commons.lang3.StringUtils.isBlank(dateTimeString)) {
            return dateTimeString;
        }
        if (dateTimeString.length() < 10) {
            return dateTimeString;
        }
        return dateTimeString.substring(0, 10);
    }

    /**
     * 毫秒数转中文时间
     * chengbeng.cb
     *
     * @param ms
     * @return
     */
    public static String ms2DateString(long ms){
        long days = ms / (1000 * 60 * 60 * 24);
        long hours = (ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (ms % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (ms % (1000 * 60)) / 1000;
        String dayStr = days < 1 ? "" : (days + "天");
        String hourStr = hours < 1 ? "" : (hours + "小时");
        String minuteStr = minutes < 1 ? "" : (minutes + "分");
        String secondStr = seconds < 1 ? "0秒" : (seconds + "秒");
        return dayStr + hourStr + minuteStr + secondStr;
    }

    /**
     * 获取ADS，分区
     * @return
     */
    public static String parseDs(){
        return formatDate(addDays(new Date(),-1),DATE_PATTERN_YYYYMMDD_2);
    }




    public static boolean beforeOrEqual(Date self, Date target) {
        if (self == null || target == null ) {
            throw new NullPointerException("日期比较不能存在null");
        }
        if (self.getTime() == target.getTime()) {
            return true;
        }
        return self.before(target);
    }

    public static boolean afterOrEqual(Date self, Date target) {
        if (self == null || target == null ) {
            throw new NullPointerException("日期比较不能存在null");
        }
        if (self.getTime() == target.getTime()) {
            return true;
        }
        return self.after(target);
    }

    public static Date getDateMinuteBefore(int minuteBefore) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(-minuteBefore, Calendar.MINUTE);
        return calendar.getTime();
    }

    public static Date parseDate(String dateStr, String formatPattern) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(formatPattern);
            return DateTime.parse(dateStr, formatter).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DATE_PATTERN_YYYYMMDDHHMMSS);
    }

    public static String format(Date date) {
        return format(date, DATE_PATTERN_YYYYMMDDHHMMSS);
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(pattern);
    }

    public static int monthsInterval(Date start, Date end) {
        DateTime dateTimeStart = new DateTime(start);
        DateTime dateTimeEnd = new DateTime(end);
        return Math.abs(Months.monthsBetween(dateTimeStart, dateTimeEnd).getMonths());
    }

    /**
     * 返回连续的月份值  2019-01  2019-02  2019-03
     * @param startDate 开始时间  2019-01
     * @param endDate 结束时间  2019-03
     * @return
     */
    public static List<String> getSpecialMonth(Date startDate, Date endDate) {
        List<String> rangeSet = new ArrayList<>();
        if (startDate == null || endDate == null) {
            return rangeSet;
        }
        Calendar dd = Calendar.getInstance();//定义日期实例
        dd.setTime(startDate);
        for (; ; ) {
            if (dd.getTime().compareTo(endDate) <= 0) {
                rangeSet.add(format(dd.getTime(), DATE_PATTERN_YYYY_MM));
                dd.add(Calendar.MONTH, 1);
            } else {
                break;
            }
        }
        return rangeSet;
    }
    /**
     * 返回连续的月份值  2019_01  2019_02  2019_03
     * @param startDate 开始时间  2019_01
     * @param endDate 结束时间  2019_03
     * @return
     */
    public static List<String> getBetweenMonth(Date startDate, Date endDate,String format) {
        List<String> rangeSet = new ArrayList<>();
        if (startDate == null || endDate == null) {
            return rangeSet;
        }
        Calendar dd = Calendar.getInstance();//定义日期实例
        dd.setTime(startDate);
        for (; ; ) {
            if (dd.getTime().compareTo(endDate) <= 0) {
                rangeSet.add(format(dd.getTime(), format));
                dd.add(Calendar.MONTH, 1);
            } else {
                break;
            }
        }
        return rangeSet;
    }

    public static void main(String[] args) {
        Date start = new Date();

        Date parseDate = truncate2DayAndAdd(start, 1);
        System.out.println(format(parseDate, DATE_PATTERN_YYYY_MM_DD_CHINESE));
        Date parsedDate2 = truncate2DayAndAdd(parseDate, -1);
        System.out.println(format(parsedDate2));
    }

    public static Date truncate2DayAndAdd(Date date, int dayAdd) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 00);
        calendar.add(Calendar.DAY_OF_YEAR, dayAdd);
        return calendar.getTime();
    }

    /**
     * 解析月份区间
     * @param monthStart
     * @param monthEnd
     * @return
     */
    public static List<String> parseMonthPeriod(String monthStart, String monthEnd) {
        try {
            List<String> result = Lists.newArrayList();
            Date startDate = new SimpleDateFormat("yyyy-MM").parse(monthStart);//定义起始日期
            Date endDate = new SimpleDateFormat("yyyy-MM").parse(monthEnd);//定义结束日期

            Calendar calendar = Calendar.getInstance();//定义日期实例

            calendar.setTime(startDate);//设置日期起始时间

            while (calendar.getTime().before(endDate)) {//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                String str = sdf.format(calendar.getTime());
                result.add(str);
                calendar.add(Calendar.MONTH, 1);//进行当前日期月份加1
            }
            result.add(monthEnd);
            return result;
        }catch (Exception e){
            //log.error("解析月份区间异常！",e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static String getYesterdayDs() {
        Date yesterday = truncate2DayAndAdd(new Date(), -1);
        return format(yesterday, DateUtil.DATE_PATTERN_YYYYMMDD);
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    public static int getHourOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static Long calculateDiffMinutes(Date start, Date end){
        if(start == null || end == null) {
            return null;
        }
        long minutes = (end.getTime() - start.getTime()) / MILLSECONDS_ONE_MINUTE;
        return minutes;
    }
}
