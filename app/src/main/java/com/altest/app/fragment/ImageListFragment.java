package com.altest.app.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.altest.R;
import com.altest.api.ApiClient;
import com.altest.api.response.ResponseGalleryData;
import com.altest.api.response.ResponseGalleryImage;
import com.altest.app.Model.GalleryImage;
import com.altest.app.activity.DetailActivity;
import com.altest.app.adapter.GalleryImageAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.altest.app.Constants.IntentKeys.GALLERY_IMAGE_ITEM;

/**
 * Created by Miguel Bronzovic.
 */
public final class ImageListFragment extends Fragment implements GalleryImageAdapter.OnItemClickListener {
    private Context contextActivity;
    private ListView imagesListView;
    private GalleryImageAdapter galleryImageAdapter;

    public static ImageListFragment newInstance() {
        return new ImageListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        galleryImageAdapter = new GalleryImageAdapter(contextActivity);
        galleryImageAdapter.setOnItemClickListener(this);

        new GetFunnyImagesAsyncTask().execute();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        contextActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.image_list_fragment, container, false);
        imagesListView = (ListView) root.findViewById(R.id.imagesList);
        imagesListView.setAdapter(galleryImageAdapter);

        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        final Intent intentDetail = new Intent(contextActivity, DetailActivity.class);
        intentDetail.putExtra(GALLERY_IMAGE_ITEM, galleryImageAdapter.getItem(position));
        contextActivity.startActivity(intentDetail);
    }

    /**
     * AsyncTask to get images from Rest Api client
     */
    private class GetFunnyImagesAsyncTask extends AsyncTask<Void, Void, List<GalleryImage>> {
        @Override
        protected List<GalleryImage> doInBackground(Void... voids) {
            final ResponseGalleryData wrapper = ApiClient.getFunnyImages();
            final List<GalleryImage> images = new ArrayList<>();

            if (wrapper != null) {
                for(ResponseGalleryImage image : wrapper.data) {
                    if (!image.nsfw && image.imageType != null) {
                        if (image.imageType.equalsIgnoreCase("image/jpeg")) {
                            final GalleryImage img = new GalleryImage();
                            img.title = image.title;
                            img.linkUrl = image.linkUrl;
                            img.ups = image.ups;
                            img.views = image.views;

                            images.add(img);
                        }
                    }
                }
            }
            return images;
        }

        @Override
        protected void onPostExecute(List<GalleryImage> images) {
            super.onPostExecute(images);
            galleryImageAdapter.addItems(images);
        }
    }
}
