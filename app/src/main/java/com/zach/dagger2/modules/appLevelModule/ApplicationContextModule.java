package com.zach.dagger2.modules.appLevelModule;

import android.content.Context;

import com.zach.dagger2.app.DaggerApplication;
import com.zach.dagger2.Qualifes.appLevelQualifers.ApplicationContextQualifer;
import com.zach.dagger2.scope.appLevelScopes.WeatherAppScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zach on 1/1/2018.
 */
@Module
public class ApplicationContextModule {

    private final Context context;
   @Inject
    public ApplicationContextModule(DaggerApplication context){
        this.context = context;
    }

    @Provides
    @WeatherAppScope
    @ApplicationContextQualifer
    public Context context(){
        return context;
    }
}
