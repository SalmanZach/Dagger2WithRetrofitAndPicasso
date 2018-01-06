package com.zach.dagger2.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zach on 8/2/2017.
 */

public class Snow {

    @SerializedName("3h")
    @Expose
    private float _3h;

    public float get3h() {
        return _3h;
    }

    public void set3h(float _3h) {
        this._3h = _3h;
    }

}