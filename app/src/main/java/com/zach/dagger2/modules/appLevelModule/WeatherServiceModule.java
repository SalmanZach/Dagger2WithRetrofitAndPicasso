package com.zach.dagger2.modules.appLevelModule;

import com.zach.dagger2.network.WeatherService;
import com.zach.dagger2.scope.appLevelScopes.WeatherAppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zach on 1/1/2018.
 */
@Module(includes = NetworkModule.class)
public class WeatherServiceModule {

    @Provides
    @WeatherAppScope
    public WeatherService weatherService(Retrofit  retrofit){

      return   retrofit.create(WeatherService.class);
    }


    @Provides
    @WeatherAppScope
    public Retrofit retrofit( OkHttpClient okHttpClient){
        return   new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


}
