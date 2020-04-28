package com.jrtc.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getEndTime(Date startTime,int num){
        Calendar instance = Calendar.getInstance();
        instance.setTime(startTime);
        instance.add(Calendar.DATE,num);
        return instance.getTime();
    }

    public static String simpDateStr(String text,Date time){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(text);
       return  simpleDateFormat.format(time);
    }

    public static void main(String[] args){
        Date endTime = getEndTime(new Date(), 2);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(endTime));
    }

}
