package com.jxx.weatherforecast.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jxx on 2016/10/9.
 */

public class HttpUtils {


    public static void HttpGetJson(final String urlvalue , final HttpCallbackListener listener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;

                try {
                    URL url = new URL(urlvalue);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(8000);
                    urlConnection.setReadTimeout(8000);

                    InputStream in = urlConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    StringBuilder sb = new StringBuilder();
                    String response;
                    while ((response = reader.readLine())!=null){
                        sb.append(response);
                    }
                    if(listener!=null){
                        listener.onFinish(sb.toString());
                    }

                } catch (MalformedURLException e) {
                    if(listener!=null){
                        listener.onError(e);
                    }
                } catch (IOException e) {
                    if(listener!=null){
                        listener.onError(e);
                    }
                }finally {
                    //释放连接
                    urlConnection.disconnect();
                }


            }
        }).start();
    }


    public static void HttpGetBitmap(String urlvalue , HttpCallbackListener listener){

    }
}
