package com.zach.dagger2.modules.appLevelModule;

import android.content.Context;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.zach.dagger2.Qualifes.appLevelQualifers.ApplicationContextQualifer;
import com.zach.dagger2.scope.appLevelScopes.WeatherAppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Zach on 1/4/2018.
 */
@Module(includes = NetworkModule.class)
public class PicassoModule {

    @Provides
    @WeatherAppScope
    public Picasso picasso(@ApplicationContextQualifer Context context, OkHttp3Downloader okHttpDownloader){

        return new Picasso.Builder(context)
                .downloader(okHttpDownloader)
                .build();
    }
    @Provides
    @WeatherAppScope
    public OkHttp3Downloader okHttpDownloader(OkHttpClient  okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
