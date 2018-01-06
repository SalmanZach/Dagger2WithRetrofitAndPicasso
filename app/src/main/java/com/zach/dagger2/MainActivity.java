package com.zach.dagger2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.zach.dagger2.app.DaggerApplication;
import com.zach.dagger2.components.activityLevelComponent.DaggerMainActivityComponent;
import com.zach.dagger2.components.activityLevelComponent.MainActivityComponent;
import com.zach.dagger2.databinding.ActivityMainBinding;
import com.zach.dagger2.modules.activityLevelModule.MainActivityModule;
import com.zach.dagger2.network.WeatherService;
import com.zach.dagger2.network.response.CurrentWeatherModel;
import com.zach.dagger2.utility.Constants;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    @Inject
    WeatherService weatherService;
    @Inject
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .applicationLevelComponent(DaggerApplication.get(this).getComponent())
                .build();
        component.injectMainActivity(this);



        weatherService.getCurrentWeatherByCity(Constants.DEFAULT_CITY,Constants.DEFAULT_TEMP_UNIT
        ,Constants.WEATHER_TYPE_ACCURATE,Constants.OWM_API_KEY).enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
               if (response.body() != null){
                   CurrentWeatherModel model = response.body();
                   mainBinding.progress.setVisibility(View.INVISIBLE);
                   mainBinding.temp.setText(Constants.getFormattedTemp(MainActivity.this,model.getMain().getTemp()));
                   mainBinding.status.setText(model.getWeather().get(0).getMain());
                   mainBinding.pressure.setText(Constants.getFormattedPressure(MainActivity.this,model.getMain().getPressure()));
                   mainBinding.cloudiness.setText(Constants.getValueWithPercent(MainActivity.this,model.getClouds().getAll()));

               }
            }
            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {

            }
        });


        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        mainBinding.recycler.setHasFixedSize(true);
        mainBinding.recycler.setAdapter(imageAdapter);
    }
}
