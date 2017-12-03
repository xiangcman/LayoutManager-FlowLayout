package com.single.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

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
    private RecyclerView rv;
    private List<ImageView> indicatorImgs;
    FlowLayoutManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        indicator = (LinearLayout) findViewById(R.id.indicator);
        vp = (ViewPager) findViewById(R.id.view_pager);
        rv = (RecyclerView) findViewById(R.id.data_content);
        viewPagerItem = DataConfig.getViewPagerItem();
        rv.setLayoutManager(fm = new FlowLayoutManager());
        rv.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        rv.setAdapter(new FlowAdapter(this, viewPagerItem));

        fm.setChildLayoutListener(new FlowLayoutManager.ChildLayoutListener() {
            @Override
            public void onLayout(int maxChild, int lineSize) {

            }

            @Override
            public void end(final int lineCount) {
                Log.d(TAG, "totalLine:" + lineCount);
                totalLine = lineCount;
                final ViewPagerItemView vpi = new ViewPagerItemView(ViewPagerActivity.this, viewPagerItem);
                viewPagerItemViews = new ArrayList<>();
                viewPagerItemViews.add(vpi.getView());
                vpi.setChildLayoutListener(new FlowLayoutManager.ChildLayoutListener() {
                    @Override
                    public void onLayout(int maxChild, int lineSize) {
                        maxItem = maxChild;
                        Log.d(TAG, "lineSize:" + lineSize);
                        vpi.invalidate(viewPagerItem.subList(0, maxItem));
                        getItems();
                        int pageSize = 0;
                        if (totalLine % lineSize == 0) {
                            pageSize = totalLine / lineSize;
                        } else {
                            pageSize = totalLine / lineSize + 1;
                        }
                        curIndex = 0;
                        caculateIndicator(pageSize);
                        fm.removeAllViews();
                        rv.setVisibility(View.GONE);
                    }

                    @Override
                    public void end(int lineCount) {

                    }
                });
                vp.setAdapter(viewPagerAdapter = new ViewPagerAdapter(viewPagerItemViews));
                vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        curIndex = position;
                        for (int i = 0; i < indicatorImgs.size(); i++) {
                            if (curIndex == i) {
                                indicatorImgs.get(i).setImageResource(R.drawable.indicator_select);
                            } else {
                                indicatorImgs.get(i).setImageResource(R.drawable.indicator_normal);
                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        });
    }

    private int totalLine;

    List<ShowItem> showItems;

    int start;

    public void getItems() {
        start = maxItem;
        showItems = viewPagerItem.subList(maxItem, viewPagerItem.size());
        final ViewPagerItemView vpi = new ViewPagerItemView(this, showItems);
        viewPagerItemViews.add(vpi.getView());
        viewPagerAdapter.notifyDataSetChanged();

        vpi.setChildLayoutListener(new FlowLayoutManager.ChildLayoutListener() {
            @Override
            public void onLayout(int maxChild, int lineSize) {
                maxItem = maxItem + maxChild;
                vpi.invalidate(viewPagerItem.subList(start, maxItem));
                Log.d(TAG, "maxItem:" + maxItem);
                if (maxItem <= viewPagerItem.size()) {
                    getItems();
                }

            }

            @Override
            public void end(int lineCount) {

            }
        });
    }

    private int curIndex;

    private void caculateIndicator(int pageSize) {
        indicatorImgs = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            ImageView img = new ImageView(this);
            if (curIndex == i) {
                img.setImageResource(R.drawable.indicator_select);
            } else {
                img.setImageResource(R.drawable.indicator_normal);
            }
            img.setPadding(8, 8, 8, 8);
            indicator.addView(img);
            indicatorImgs.add(img);
        }
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
