package com.altest.app.widget.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.squareup.picasso.Transformation;

/**
 * Picasso's Circular Transformation. <br/>
 *
 * Created by Miguel Bronzovic.
 */
public final class CircularTransformation implements Transformation {

    private int mXPosition;
    private int mYPosition;

    @Override
    public Bitmap transform(Bitmap source) {
        final int size = Math.min(source.getWidth(), source.getHeight());
        mXPosition = (source.getWidth() - size) / 2;
        mYPosition = (source.getHeight() - size) / 2;
        final Bitmap squaredBitmap = Bitmap.createBitmap(source, mXPosition, mYPosition, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        final Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        final BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP,
                BitmapShader.TileMode.CLAMP);

        paint.setShader(shader);
        paint.setAntiAlias(true);
        final float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);
        squaredBitmap.recycle();

        return bitmap;
    }

    @Override
    public String key() {
        return "circle(x=" + mXPosition + ",y=" + mYPosition + ")";
    }
}
