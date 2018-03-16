package com.single.flowlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

/**
 * Created by xiangcheng on 18/3/16.
 */

public class DeleteDrawable extends GradientDrawable {
    private Bitmap bitmap;
    private static final int BITMAP_XY = 20;
    //图片边长
    private int bitmapXY;

    public DeleteDrawable(Context context) {
        setCornerRadius(8);
        setColor(Color.parseColor("#ff0000"));
        bitmap = getBitmapFromDrawable(context, R.drawable.ic_delete);
        bitmapXY = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BITMAP_XY, context.getResources().getDisplayMetrics());
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(bitmap, getBounds().centerX() - bitmap.getWidth() / 2, getBounds().centerY() - bitmap.getHeight() / 2, null);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float scale = (float) (bitmapXY * 1.0 / size);
        Matrix matrix = new Matrix();
        //需要对图片进行缩放
        matrix.setScale(scale, scale);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public Bitmap getBitmapFromDrawable(Context context, @DrawableRes int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof VectorDrawable || drawable instanceof VectorDrawableCompat) {
            Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);

            return bitmap;
        } else {
            throw new IllegalArgumentException("unsupported drawable type");
        }
    }
}
