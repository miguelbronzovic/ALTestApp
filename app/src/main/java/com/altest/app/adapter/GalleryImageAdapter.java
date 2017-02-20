package com.altest.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.altest.R;
import com.altest.app.Model.GalleryImage;
import com.altest.app.helper.PicassoHelper;
import com.altest.app.widget.picasso.CircularTransformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miguel Bronzovic.
 */
public final class GalleryImageAdapter extends BaseAdapter {

    private Context mContext;
    private List<GalleryImage> mValues = new ArrayList<>();
    private OnItemClickListener mClickListener;

    public GalleryImageAdapter(Context context) {
        mContext = context;
    }

    public void addItems(List<GalleryImage> images) {
        mValues.clear();
        mValues = images;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(final OnItemClickListener itemClickListener) {
        mClickListener = itemClickListener;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public GalleryImage getItem(int position) {
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gallery_image_list_item, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.votes = (TextView) convertView.findViewById(R.id.votes);
            holder.views = (TextView) convertView.findViewById(R.id.views);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final GalleryImage item = mValues.get(position);

        if (item != null) {
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(view, position);
                    }
                }
            });

            if (!TextUtils.isEmpty(item.linkUrl)) {
                PicassoHelper.getInstance()
                        .load(item.linkUrl)
                        .transform(new CircularTransformation())
                        .fit()
                        .centerInside()
                        .noFade()
                        .into(holder.image);
            }

            holder.title.setText(String.format("Title: %s", item.title));
            holder.votes.setText(String.format("Votes: %s", String.valueOf(item.ups)));
            holder.views.setText(String.format("Views: %s", String.valueOf(item.views)));
        }

        return convertView;
    }

    /**
     * Click listener for adapter´ items. </br>
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView votes;
        public TextView views;
    }
}
