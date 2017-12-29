package com.library.flowlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by xiangcheng on 17/12/29.
 */

public class MeasureFlowLayoutManager extends FlowLayoutManager {
    private Context context;

    public MeasureFlowLayoutManager(Context context) {
        this.context = context;
        setAutoMeasureEnabled(false);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        Log.d("TAG", "onMeasure");
        int widthMode = View.MeasureSpec.getMode(widthSpec);
        int measureWidth = View.MeasureSpec.getSize(widthSpec);
        int heightMode = View.MeasureSpec.getMode(heightSpec);
        int measureHeight = View.MeasureSpec.getSize(heightSpec);
        if (widthMode == View.MeasureSpec.EXACTLY) {
            width = measureWidth;
        } else {
            //以实际屏宽为标准
            width = context.getResources().getDisplayMetrics().widthPixels;
        }
        if (heightMode == View.MeasureSpec.EXACTLY) {
            height = measureHeight;
            Log.d("TAG", "规则的");
        } else {
            //以实际屏高为标准
            height = totalHeight + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(width, height);
    }
}