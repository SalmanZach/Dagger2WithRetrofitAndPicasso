package com.zach.dagger2.modules.activityLevelModule;

import com.zach.dagger2.MainActivity;
import com.zach.dagger2.scope.activityLevelScopes.MainActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zach on 1/6/2018.
 */
@Module
public class MainActivityModule {
    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public MainActivity  mainActivity(){
        return mainActivity;
    }
}
