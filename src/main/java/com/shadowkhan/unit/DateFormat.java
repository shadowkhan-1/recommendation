package com.shadowkhan.unit;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateFormat {
    public static String toDate(Long timestamp,String format){
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(new Date(timestamp));
    }
}
