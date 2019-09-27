package com.meteorplan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    /**
     * 计算两个日期之间的天数
     * @param d1 起始日期
     * @param d2 结束日期
     * @return 日期之间的天数
     */
    public static int getBetweenDay(Date d1, Date d2){
        return  (int) ((d2.getTime() - d1.getTime()) / (24*3600*1000));
    }

    /**
     * 计算两个日期之间的所有月份
     * @param minDate 起始月
     * @param maxDate 结束月
     * @param contains 是否包含起始月 1 包含 0 不包含
     * @return 日期之间的所有月份
     */
    private static List<String> getDateBetween(String minDate, String maxDate,int contains) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        //格式化为日期
        SimpleDateFormat sdf;

        if(minDate.length()==7 && maxDate.length()==7){
            sdf = new SimpleDateFormat("yyyy-MM");
        }else if(minDate.length()==10 && maxDate.length()==10){
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        if(contains==1){
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        }else{
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH)+1, 1);
        }

        max.setTime(sdf.parse(maxDate));
        if(contains==1){
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        }else{
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 1);
        }


        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }


//    public static void main(String[] args) {
//        System.out.println(getBetweenDay(new Date(), DateUtils.addDays(new Date(),2))
//        );
//
//        try {
//            System.out.println(getDateBetween("2019-05-01","2020-08-03",0));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//    }
}
