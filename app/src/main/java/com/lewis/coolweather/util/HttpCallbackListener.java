package com.lewis.coolweather.util;

/**
 * Created by Administrator on 15-9-17.
 * 回调服务返回的结果
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
