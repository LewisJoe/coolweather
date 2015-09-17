package com.lewis.coolweather.util;

import android.text.TextUtils;

import com.lewis.coolweather.db.CoolWeatherDB;
import com.lewis.coolweather.model.City;
import com.lewis.coolweather.model.County;
import com.lewis.coolweather.model.Province;

/**
 * Created by Administrator on 15-9-17.
 * 解析和处理服务器返回的个省市县的数据
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     * @param coolWeatherDB 数据库操作类
     * @param response 响应返回的数据
     * @return 是否成功
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB
            ,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for (String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     * @param coolWeatherDB 数据库操作实例
     * @param response 服务器响应返回的数据
     * @param provinceId 省ID
     * @return 是否成功
     */
    public synchronized static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB
            ,String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for (String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    //将解析出来的数据存储到City表
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     * @param coolWeatherDB 数据库操作实例
     * @param response 服务器响应返回的数据
     * @param cityId 城市ID
     * @return 是否成功
     */
    public synchronized static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB
            ,String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for (String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    //将解析出来的数据存储到County类
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
