package com.altest.app;

import android.app.Application;

import com.altest.api.ApiClient;
import com.altest.app.helper.PicassoHelper;
import com.squareup.okhttp.Cache;

import java.io.File;

import static com.altest.app.Constants.Cache.CACHE_SIZE;

/**
 * Created by Miguel Bronzovic.
 */
public class AngiesListApplication extends Application {

    private static AngiesListApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        final Cache httpCache = new Cache(new File(this.getCacheDir(), "http"), CACHE_SIZE);
        ApiClient.init(httpCache);

        PicassoHelper.init();
    }

    public static AngiesListApplication getInstance() {
        return INSTANCE;
    }
}
