package com.example.root.weathercheck.HTTPData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class HTTPData {
    static String stream = null;

    public HTTPData(){

    }

    public String getHttpData(String urlstring){

        try{
            URL url = new URL(urlstring);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            if(httpURLConnection.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while((line = br.readLine())!=null){
                    sb.append(line);
                    stream = sb.toString();
                    httpURLConnection.disconnect();
                }
            }
        }
        catch(MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return stream;

    }
}
