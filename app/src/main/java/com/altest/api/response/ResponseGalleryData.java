package com.altest.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Miguel Bronzovic.
 */
public class ResponseGalleryData {

    @SerializedName("data")
    public List<ResponseGalleryImage> data;
}
