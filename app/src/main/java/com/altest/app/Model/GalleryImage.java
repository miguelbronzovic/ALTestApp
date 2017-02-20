package com.altest.app.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Gallery Image representation in the app. </br>
 *
 * Created by Miguel Bronzovic.
 */
public final class GalleryImage implements Parcelable {

    public String title;

    public String description;

    public boolean nsfw;

    public String linkUrl;

    public int ups;

    public int views;

    public static final Parcelable.Creator<GalleryImage> CREATOR
            = new Parcelable.Creator<GalleryImage>() {

        @Override
        public GalleryImage createFromParcel(Parcel in) {
            return new GalleryImage(in);
        }

        @Override
        public GalleryImage[] newArray(int size) {
            return new GalleryImage[size];
        }
    };

    public GalleryImage() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeByte((byte) (nsfw ? 1 : 0));
        parcel.writeString(linkUrl);
        parcel.writeInt(ups);
        parcel.writeInt(views);
    }

    private GalleryImage (Parcel in) {
        title = in.readString();
        description = in.readString();
        nsfw = in.readByte() != 0;
        linkUrl = in.readString();
        ups = in.readInt();
        views = in.readInt();
    }
}
