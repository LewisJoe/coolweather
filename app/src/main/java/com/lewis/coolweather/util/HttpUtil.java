package com.lewis.coolweather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 15-9-17.
 * 网络交互工具
 */
public class HttpUtil {
    /**
     * 发起网络请求
     * @param address 网址
     * @param listener 主线程监听接口
     */
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    try {
                        //建立连接
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(8000);
                        connection.setReadTimeout(8000);
                        //得到数据
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        //处理成功
                        if (listener != null){
                            //回调onFinish()方法
                            listener.onFinish(response.toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (listener != null){
                            //回调onError()方法
                            listener.onError(e);
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    if (listener != null){
                        listener.onError(e);
                    }
                }finally {
                    if (connection != null){
                        //断开连接
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}
