package com.single.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.library.flowlayout.FlowLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangcheng on 17/12/2.
 */

public class ViewPagerActivity extends AppCompatActivity {
    private static final String TAG = ViewPagerActivity.class.getSimpleName();
    int maxItem;
    List<ShowItem> viewPagerItem;
    private List<View> viewPagerItemViews;
    ViewPager vp;
    ViewPagerAdapter viewPagerAdapter;
    LinearLayout indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        indicator = (LinearLayout) findViewById(R.id.indicator);
        vp = (ViewPager) findViewById(R.id.view_pager);
//        vp.setOffscreenPageLimit(10);
        viewPagerItem = DataConfig.getViewPagerItem();
        final ViewPagerItemView vpi = new ViewPagerItemView(this, viewPagerItem);
        viewPagerItemViews = new ArrayList<>();
        viewPagerItemViews.add(vpi.getView());
        vpi.setChildLayoutListener(new FlowLayoutManager.ChildLayoutListener() {
            @Override
            public void onLayout(int maxChild) {
                maxItem = maxChild;
                Log.d(TAG, "maxItem:" + maxItem);
                vpi.invalidate(viewPagerItem.subList(0, maxItem));
                getItems();
            }
        });
        vp.setAdapter(viewPagerAdapter = new ViewPagerAdapter(viewPagerItemViews));
//        ImageView img = new ImageView(this);
//        img.setImageResource(R.drawable.indicator_normal);
//        img.setPadding(5, 5, 5, 5);
//        indicator.addView(img);
    }

    List<ShowItem> showItems;

    int start;

    public void getItems() {
        start = maxItem;
        showItems = viewPagerItem.subList(maxItem, viewPagerItem.size());
        final ViewPagerItemView vpi = new ViewPagerItemView(this, showItems);
        viewPagerItemViews.add(vpi.getView());
        viewPagerAdapter.notifyDataSetChanged();
//        ImageView img = new ImageView(this);
//        img.setImageResource(R.drawable.indicator_normal);
//        img.setPadding(5, 5, 5, 5);
//        indicator.addView(img);
        vpi.setChildLayoutListener(new FlowLayoutManager.ChildLayoutListener() {
            @Override
            public void onLayout(int maxChild) {
                maxItem = maxItem + maxChild;
                vpi.invalidate(viewPagerItem.subList(start, maxItem));
                Log.d(TAG, "maxItem:" + maxItem);
                if (maxItem <= viewPagerItem.size()) {
                    getItems();
                }
            }
        });
    }
}
