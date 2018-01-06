package com.zach.dagger2.app;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import com.zach.dagger2.components.appLevelComponent.ApplicationLevelComponent;
import com.zach.dagger2.components.appLevelComponent.DaggerApplicationLevelComponent;
import com.zach.dagger2.modules.appLevelModule.ApplicationContextModule;
import timber.log.Timber;

/**
 * Created by Zach on 1/1/2018.
 */

public class DaggerApplication extends Application {

    ApplicationLevelComponent  component;

    public static DaggerApplication get(AppCompatActivity activity){
        return (DaggerApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
       component = DaggerApplicationLevelComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
    }

    public ApplicationLevelComponent getComponent(){
        return component;
    }

}
