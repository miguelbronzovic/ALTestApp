package com.altest.app.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.altest.R;
import com.altest.app.Model.GalleryImage;
import com.altest.app.helper.PicassoHelper;

import static com.altest.app.Constants.IntentKeys.GALLERY_IMAGE_ITEM;

/**
 * Shows detail information from Gallery Image objects. <br/>
 *
 * Created by Miguel Bronzovic.
 */
public final class DetailActivity extends AbstractRightToLeftSubActivity {
    private ImageView image;
    private TextView imageTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        image = (ImageView) findViewById(R.id.image);
        imageTitle = (TextView) findViewById(R.id.title);

        final GalleryImage galleryImageItem = getIntent().getParcelableExtra(GALLERY_IMAGE_ITEM);

        PicassoHelper.getInstance()
                .load(galleryImageItem.linkUrl)
                .fit()
                .centerInside()
                .noFade()
                .into(image);

        imageTitle.setText(galleryImageItem.title);
    }
}
