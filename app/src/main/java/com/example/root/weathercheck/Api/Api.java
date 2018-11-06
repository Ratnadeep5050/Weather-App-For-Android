package com.example.root.weathercheck.Api;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Api {

    public static String API_KEY = "fe917c4a86320cb39de705c7ed6323c0";
    public static String API_LINK = "http://http://api.openweathermap.org/data/2.5/weather";

    @NonNull
    public static String apiReq(String latitude, String longitude){
        StringBuilder sb = new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric",latitude,longitude,API_KEY));
        return sb.toString();
    }

    public static String unixTimeStampToDateTime(double timeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)timeStamp*1000);
        return dateFormat.format(date);
    }

    public static String getIcon(String icon){
        return String.format("http://openweathermap.org/img/w/%s.png",icon);
    }

    public static String getDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }



}
