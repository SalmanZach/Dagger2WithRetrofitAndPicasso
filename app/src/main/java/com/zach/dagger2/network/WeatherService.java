package com.zach.dagger2.network;


import com.zach.dagger2.network.response.CurrentWeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zach on 7/26/2017.
 */

public interface WeatherService {


    // Current Weather
    @GET("/data/2.5/weather")
    Call<CurrentWeatherModel> getCurrentWeather(@Query("units") String tempUnit, @Query("type")
            String accurate, @Query("lat") double lat
            , @Query("lon") double lon, @Query("appid") String appId);

    // Current Weather by city name
    @GET("/data/2.5/weather")
    Call<CurrentWeatherModel> getCurrentWeatherByCity(@Query("q") String cityName, @Query("units")
            String tempUnit, @Query("type") String accurate, @Query("appid") String appId);





}
