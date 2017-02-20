package com.altest.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Miguel Bronzovic.
 */
public class ResponseGalleryImage {

    @SerializedName("title")
    public String title;

    @SerializedName("description")
    public String description;

    @SerializedName("nsfw")
    public boolean nsfw;

    @SerializedName("link")
    public String linkUrl;

    @SerializedName("ups")
    public int ups;

    @SerializedName("views")
    public int views;

    @SerializedName("type")
    public String imageType;
}
