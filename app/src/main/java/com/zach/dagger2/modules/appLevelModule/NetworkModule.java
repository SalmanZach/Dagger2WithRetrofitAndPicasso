package com.zach.dagger2.modules.appLevelModule;

import android.content.Context;

import com.zach.dagger2.Qualifes.appLevelQualifers.ApplicationContextQualifer;
import com.zach.dagger2.scope.appLevelScopes.WeatherAppScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Zach on 1/1/2018.
 */
@Module(includes = ApplicationContextModule.class)
public class NetworkModule {


    @Provides
    @WeatherAppScope
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor =  new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }


    @Provides
    @WeatherAppScope
    public File file(@ApplicationContextQualifer  Context context){
        File file = new File(context.getCacheDir(),"okhttp_cache");
        file.mkdirs();
        return file;
    }



    @Provides
    public Cache cache(File file){
        return new Cache(file, 10*104*1024);
    }


    @Provides
    @WeatherAppScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache){
       return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .cache(cache).build();
    }


}
