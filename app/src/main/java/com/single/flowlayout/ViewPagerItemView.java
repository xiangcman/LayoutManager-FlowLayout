package com.single.flowlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.List;

/**
 * Created by xiangcheng on 17/12/2.
 */

public class ViewPagerItemView {
    private FlowLayoutManager fm;
    private Context context;
    private FlowAdapter flowAdapter;
    private List<ShowItem> items;
    RecyclerView rv;

    public View getView() {
        return view;
    }

    private View view;

    public ViewPagerItemView(Context context, List<ShowItem> items) {
        this.context = context;
        this.items = items;
        view = View.inflate(context, R.layout.viewpager_item, null);
        rv = (RecyclerView) view.findViewById(R.id.item);
        rv.setLayoutManager(fm = new FlowLayoutManager());
        rv.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        rv.setAdapter(flowAdapter = new FlowAdapter(context, this.items));
    }

    public void setChildLayoutListener(FlowLayoutManager.ChildLayoutListener childLayoutListener) {
        fm.setChildLayoutListener(childLayoutListener);
    }

    public void invalidate(List<ShowItem> items) {
        this.items = items;
        rv.setAdapter(flowAdapter = new FlowAdapter(context, this.items));
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
}
