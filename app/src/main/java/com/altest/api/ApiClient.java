package com.altest.api;

import com.altest.api.interceptor.AngiesListRequestInterceptor;
import com.altest.api.response.ResponseGalleryData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.OkHttpDownloader;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import static com.altest.app.Constants.Servers;
import static com.altest.app.Constants.Timing.OKHTTP_CONNECTION_TIMEOUT;
import static com.altest.app.Constants.Timing.OKHTTP_READ_TIMEOUT;
import static retrofit.RestAdapter.LogLevel.FULL;

/**
 * Client to handle the access on the Rest API. </br>
 *
 * Created by Miguel Bronzovic.
 */
public final class ApiClient {

    private static ImgUrApiService imgUrApiService;

    private static OkHttpDownloader okHttpDownloader;

    private ApiClient() {}

    /**
     * Initialize the ImgUr API RestAdapter. </br>
     */
    public static void init(Cache cache) {
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(OKHTTP_CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(OKHTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);
        if (cache != null) {
            okHttpClient.setCache(cache);
        }

        okHttpDownloader = new OkHttpDownloader(okHttpClient);

        final OkClient okClient = new OkClient(okHttpClient);

        final Gson gson = new GsonBuilder()
                .create();

        imgUrApiService = new RestAdapter.Builder()
                .setEndpoint(Servers.SERVER_HOST_PRODUCTION)
                .setLogLevel(FULL)
                .setClient(okClient)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(new AngiesListRequestInterceptor())
                .build()
                .create(ImgUrApiService.class);
    }

    /**
     * Retrieves the images from the API. </br>
     *
     * @return {@link ResponseGalleryData} data
     */
    public static ResponseGalleryData getFunnyImages() {
        return imgUrApiService.getFunny();
    }

    /**
     * Gets the OkHttpDownloader for the Picasso Instance. </br>
     *
     * @return okHttpDownloader
     */
    public static Downloader getOkHttpDownloader() {
        return okHttpDownloader;
    }

}
