package com.altest.api.interceptor;

import retrofit.RequestInterceptor;

/**
 * Interceptor to add authorization token and other stuff to every request. </br>
 *
 * Created by Miguel Bronzovic.
 */
public class AngiesListRequestInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Authorization", "Client-ID 1588a32330b9360");
    }
}
