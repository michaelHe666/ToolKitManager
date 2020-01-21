package cn.edu.zust.dmt.common.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.common.tools
 * @description $
 * @time 1/8/2020 9:02
 * copyright(c) all rights reserved by MR.M
 **/
public class DateUtil {

    public static final SimpleDateFormat myyyyMMddhhmmssSlashFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
    public static final SimpleDateFormat mMdSlashFormat = new SimpleDateFormat("M/d", Locale.getDefault());
    public static final SimpleDateFormat myyyyMMddEEEEFormat = new SimpleDateFormat("yyyy年M月d日    EEEE", Locale.getDefault());
    public static final SimpleDateFormat myyyyMMddhhmmssSlash2Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    public static final SimpleDateFormat myyyyMMddSlash2Format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static final SimpleDateFormat myyyyMMddFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());


    public static String convertTimeStampToString(long timeStamp, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(new Date(timeStamp * 1000L));
    }

    public static Date convertTimeStampToDate(long timeStamp) {
        return new Date(timeStamp * 1000L);
    }

    public static Date convertStringToDate(String dateStr, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.parse(dateStr, new ParsePosition(0));
    }

    public static String convertDateToString(Date date, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(date);
    }


    public static String getCurrentTimeStr(SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getCurrentYearStartStr(SimpleDateFormat simpleDateFormat) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Calendar yearStartDate = Calendar.getInstance();
        yearStartDate.set(year, 0, 1, 0, 0, 0);
        return convertDateToString(yearStartDate.getTime(), simpleDateFormat);
    }

    public static String getCurrentYearEndStr(SimpleDateFormat simpleDateFormat) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Calendar yearEndDate = Calendar.getInstance();
        yearEndDate.set(year, 11, 31, 23, 59, 59);
        return convertDateToString(yearEndDate.getTime(), simpleDateFormat);
    }

    /**
     * @param startTime yyyy-MM-dd HH:mm:ss
     * @param years
     * @return yyyy-MM-dd~yyyy-MM-dd
     */
    public static String formatContractEndTime(String startTime, SimpleDateFormat simpleDateFormat, int years) {
        Date date = convertStringToDate(startTime, simpleDateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return convertDateToString(calendar.getTime(), simpleDateFormat);
    }

    /**
     * @param startTime yyyy-MM-dd HH:mm:ss
     * @param years
     * @return yyyy-MM-dd~yyyy-MM-dd
     */
    public static String formatYearContractEndTime(String startTime, SimpleDateFormat simpleDateFormat, int years) {
        Date date = convertStringToDate(startTime, simpleDateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return convertDateToString(calendar.getTime(), simpleDateFormat);
    }

    /**
     * @param startTime yyyy-MM-dd HH:mm:ss
     * @param years
     * @return yyyy-MM-dd~yyyy-MM-dd
     */
    public static String formatContractEndTime(String startTime, SimpleDateFormat simpleDateFormat, int years, int month) {
        Date date = convertStringToDate(startTime, simpleDateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.MONTH, month);
        return convertDateToString(calendar.getTime(), simpleDateFormat);
    }

    /**
     * @param lastEndTime yyyy-MM-dd
     * @param day
     * @return yyyy-MM-dd~yyyy-MM-dd
     */
    public static String formatContractNewStartTime(String lastEndTime, SimpleDateFormat simpleDateFormat, int day) {
        Date date = convertStringToDate(lastEndTime, simpleDateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return convertDateToString(calendar.getTime(), simpleDateFormat);
    }

    /**
     * @return get Later loopName string
     *         return null for exception
     */
    public static String getLaterDateString(String string1, String string2) {
        Date date1;
        Date date2;
        try {
            date1 = myyyyMMddSlash2Format.parse(string1);
            date2 = myyyyMMddSlash2Format.parse(string2);
            if (date1.getTime() > date2.getTime()) {
                return string1;
            } else {
                return string2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return get earlier loopName string
     *         return null for exception
     */
    public static String getEarlierDateString(String string1, String string2) {
        Date date1;
        Date date2;
        try {
            date1 = myyyyMMddSlash2Format.parse(string1);
            date2 = myyyyMMddSlash2Format.parse(string2);
            if (date1.getTime() < date2.getTime()) {
                return string1;
            } else {
                return string2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
