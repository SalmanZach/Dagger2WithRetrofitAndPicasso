package com.zach.dagger2.components.appLevelComponent;

import com.squareup.picasso.Picasso;
import com.zach.dagger2.modules.activityLevelModule.ActivityContextModule;
import com.zach.dagger2.modules.appLevelModule.ApplicationContextModule;
import com.zach.dagger2.modules.appLevelModule.PicassoModule;
import com.zach.dagger2.modules.appLevelModule.WeatherServiceModule;
import com.zach.dagger2.network.WeatherService;
import com.zach.dagger2.scope.appLevelScopes.WeatherAppScope;

import dagger.Component;

/**
 * Created by Zach on 1/1/2018.
 */
@WeatherAppScope
@Component(modules = {WeatherServiceModule.class, PicassoModule.class, ActivityContextModule.class, ApplicationContextModule.class})
public interface ApplicationLevelComponent {
      Picasso getPicasso();
      WeatherService getWeatherService();
}
