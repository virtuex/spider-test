package org.virtue.load;

import org.junit.Test;

import java.beans.Transient;
import java.text.SimpleDateFormat;

public class DateUtil {
    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @return
     */
    public static String dateToStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static String computeEndDate(String date,int months){
        String[] split = date.split("-");
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int addYear = months/12;
        int addMonth = months%12;
        year = year+addYear;
        month = month+addMonth;
        if(month>12){
            month = month - 12;
            year++;
        }
        return year+"-"+month+"-"+day;
    }

    @Test
    public void test(){
        System.out.println(computeEndDate("2018-4-2",13));
    }
}
