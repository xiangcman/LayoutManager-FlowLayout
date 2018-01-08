package com.single.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

/**
 * Created by xiangcheng on 17/11/30.
 */
public class ShowItem {
    public Drawable color;
    public String des;
    public boolean isSelect;

    public ShowItem(String des) {
        this.des = des;
        color = getBack();
    }

    private Drawable getBack() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(8);
        drawable.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
        return drawable;
    }
}