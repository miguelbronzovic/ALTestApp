package com.altest.api;

import com.altest.api.response.ResponseGalleryData;

import retrofit.http.GET;

/**
 * Created by Miguel Bronzovic.
 */
public interface ImgUrApiService {

    @GET("/gallery/r/funny")
    ResponseGalleryData getFunny();
}
