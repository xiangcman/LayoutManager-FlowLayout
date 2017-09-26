package com.single.flowlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.List;
import java.util.Random;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = ProductAdapter.class.getSimpleName();
    private List<Product.Classify> classifies;
    private Context context;

    public ProductAdapter(Context context, List<Product.Classify> classifies) {
        this.context = context;
        this.classifies = classifies;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductHolder(View.inflate(context, R.layout.product_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ProductHolder productHolder = (ProductHolder) holder;
        Product.Classify classify = classifies.get(position);
        final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) productHolder.des.getLayoutParams();
        lp.width = context.getResources().getDisplayMetrics().widthPixels;
        final FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        productHolder.title.setText(classify.title);
        productHolder.des.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        productHolder.des.setLayoutManager(flowLayoutManager);
        productHolder.des.setAdapter(new FlowAdapter(classify.des));
        productHolder.des.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                productHolder.des.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.d(TAG, "flowLayoutManager.getTotalHeight():" + flowLayoutManager.getTotalHeight());
                lp.height = flowLayoutManager.getTotalHeight() + productHolder.des.getPaddingBottom() + productHolder.des.getPaddingTop();
                productHolder.des.setLayoutParams(lp);
            }
        });

    }

    @Override
    public int getItemCount() {
        return classifies.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RecyclerView des;

        public ProductHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            des = (RecyclerView) itemView.findViewById(R.id.des);
        }
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<String> list;

        public FlowAdapter(List<String> list) {
            this.list = list;
        }

        SparseArray<Drawable> allDrawAble = new SparseArray<>();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(context, R.layout.flow_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            TextView textView = ((MyHolder) holder).text;
            if (allDrawAble.get(position) == null) {
                allDrawAble.put(position, getBack());
            }
            textView.setBackgroundDrawable(allDrawAble.get(position));
            textView.setText(list.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, list.get(position), Toast.LENGTH_SHORT).show();
                }
            });
        }

        private Drawable getBack() {
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(8);
            drawable.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            return drawable;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private TextView text;

            public MyHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.flow_text);
            }
        }
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }
}
