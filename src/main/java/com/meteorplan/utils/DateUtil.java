package com.meteorplan.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateUtil {

    /**
     * 计算两个日期之间的天数
     * @param d1 起始日期
     * @param d2 结束日期
     * @return 日期之间的天数
     */
    public static int dateBetweenDay(Date d1, Date d2){
        return  (int) ((d2.getTime() - d1.getTime()) / (24*3600*1000));
    }


//    public static void main(String[] args) {
//        System.out.println(        dateBetweenDay(new Date(), DateUtils.addDays(new Date(),2))
//        );
//    }
}
