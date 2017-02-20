package com.altest.app.helper;

import com.altest.BuildConfig;
import com.altest.api.ApiClient;
import com.altest.app.AngiesListApplication;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import static com.altest.app.Constants.Cache.CACHE_SIZE;


/**
 * Created by Miguel Bronzovic.
 */
public final class PicassoHelper {
    private static Picasso INSTANCE;

    private PicassoHelper() {
    }

    public static void init() {
        final LruCache lruCache = new LruCache(CACHE_SIZE);
        INSTANCE = new Picasso.Builder(AngiesListApplication.getInstance())
                .downloader(ApiClient.getOkHttpDownloader())
                .indicatorsEnabled(BuildConfig.DEBUG ? true : false)
                .loggingEnabled(true)
                .memoryCache(lruCache)
                .build();
    }

    public static Picasso getInstance() {
        return INSTANCE;
    }
}
