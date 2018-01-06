package com.zach.dagger2.utility;

import android.content.Context;

import com.zach.dagger2.R;

import java.util.Locale;

/**
 * Created by Zach on 1/1/2018.
 */

public class Constants {
    public static final String OWM_API_KEY = "d03050e2c6242f5a13e0bdd7af00ebe9";
    public static final String DEFAULT_COUNTRY = "India";
    public static final String DEFAULT_CITY = "Jaipur";
    public static final String WEATHER_TYPE_ACCURATE = "accurate";
    public static final String DEFAULT_TEMP_UNIT = "metric";
    public static final String IMAGE_ONE = "http://s3.india.com/travel/wp-content/uploads/2014/09/jaipur-lead.jpg";
    public static final String IMAGE_TWO = "http://s3.india.com/travel/wp-content/uploads/2014/09/rambagh-palace.jpg";
    public static final String IMAGE_THREE = "http://s3.india.com/travel/wp-content/uploads/2014/09/albert-hall-museum-jaipur.jpg";


    public static String getFormattedTemp(Context context, float temp) {
        return context.getString(R.string.temperature_with_degree, String.format(Locale.getDefault(), "%.0f", temp));
    }

    public static String getValueWithPercent(Context context, int value) {
        return value + context.getString(R.string.percent_sign);

    }

    public static String getFormattedPressure(Context context, float pressure) {
        String value = Float.toString(pressure);
        if (value.contains(".")){
            value = value.substring(0, value.indexOf("."));
        }
        return value + " " + context.getString(R.string.pressure_measurement);

    }

}
