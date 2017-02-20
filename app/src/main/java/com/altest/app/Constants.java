package com.altest.app;

/**
 * Application constants
 */
public final class Constants {

    /**
     * Inner class to hold the cache size value. </br>
     */
    public static final class Cache {
        public static final int CACHE_SIZE = 75 * 1024 * 1024;
    }

    /**
     * Inner class to hold the servers host names. </br>
     */
    public static final class Servers {
        /** The backend server host for PRODUCTION server */
        public static final String SERVER_HOST_PRODUCTION = "https://api.imgur.com/3";
    }

    /**
     * Inner class to hold Intent keys constants. </br>
     */
    public static final class IntentKeys {
        public static final String GALLERY_IMAGE_ITEM = "gallery_image_item";
    }

    /**
     * Inner class to hold the timing constants. </br>
     */
    public static final class Timing {
        public static final long OKHTTP_CONNECTION_TIMEOUT = 30 * 1000;
        public static final long OKHTTP_READ_TIMEOUT = 30 * 1000;
    }
}
