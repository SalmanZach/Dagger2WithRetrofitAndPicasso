package com.zach.dagger2.modules.activityLevelModule;

import android.app.Activity;
import android.content.Context;

import com.zach.dagger2.scope.activityLevelScopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zach on 1/4/2018.
 */
@Module
public class ActivityContextModule {

    private final Context context;

    public ActivityContextModule(Activity context){
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context context(){
        return context;
    }
}
