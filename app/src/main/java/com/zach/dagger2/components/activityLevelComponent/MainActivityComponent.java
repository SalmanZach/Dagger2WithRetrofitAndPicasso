package com.zach.dagger2.components.activityLevelComponent;

import com.zach.dagger2.MainActivity;
import com.zach.dagger2.components.appLevelComponent.ApplicationLevelComponent;
import com.zach.dagger2.modules.activityLevelModule.MainActivityModule;
import com.zach.dagger2.scope.activityLevelScopes.MainActivityScope;
import dagger.Component;

/**
 * Created by Zach on 1/6/2018.
 */
@MainActivityScope
@Component(modules = MainActivityModule.class , dependencies = ApplicationLevelComponent.class)
public interface MainActivityComponent {
 void injectMainActivity(MainActivity mainActivity);
}
