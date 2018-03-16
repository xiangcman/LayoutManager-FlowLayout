package com.library.flowlayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiangcheng on 18/1/17.
 * 邮箱:a1002326270@163.com
 * qq:1002326270
 * 主要是为了适配rv嵌套rv的案例，如果大家有什么好的方案请提出来，谢谢了!!!
 */

public class NestedRecyclerView extends RecyclerView {
    public NestedRecyclerView(Context context) {
        super(context);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        FlowLayoutManager layoutManager = (FlowLayoutManager) getLayoutManager();
        int widthMode = View.MeasureSpec.getMode(widthSpec);
        int measureWidth = View.MeasureSpec.getSize(widthSpec);
        int heightMode = View.MeasureSpec.getMode(heightSpec);
        int measureHeight = View.MeasureSpec.getSize(heightSpec);
        int width, height;
        if (widthMode == View.MeasureSpec.EXACTLY) {
            width = measureWidth;
        } else {
            //以实际屏宽为标准
            width = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (heightMode == View.MeasureSpec.EXACTLY) {
            height = measureHeight;
        } else {
            height = layoutManager.getTotalHeight() + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(width, height);

    }
}