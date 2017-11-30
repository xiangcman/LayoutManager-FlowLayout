package com.single.flowlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class DiffHeightTextFlowActivity extends AppCompatActivity {

    private List<ShowItem> list = new ArrayList<>();
    private FlowAdapter flowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        RecyclerView viewById = (RecyclerView) findViewById(R.id.flow);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        viewById.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        viewById.setLayoutManager(flowLayoutManager);
        list.addAll(DataConfig.getDiffItem());
        viewById.setAdapter(flowAdapter = new FlowAdapter(list));
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_HEIGER = 1;
        private static final int TYPE_NORMAL = 2;

        private List<ShowItem> list;

        public FlowAdapter(List<ShowItem> list) {
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_HEIGER) {
                return new MyHolder(View.inflate(DiffHeightTextFlowActivity.this, R.layout.flow_item_heigher, null));
            } else {
                return new MyHolder(View.inflate(DiffHeightTextFlowActivity.this, R.layout.flow_item, null));
            }

        }

        @Override
        public int getItemViewType(int position) {
            if (position % 3 == 0) {
                return TYPE_HEIGER;
            } else {
                return TYPE_NORMAL;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = ((MyHolder) holder).text;
            textView.setBackgroundDrawable(list.get(position).color);
            textView.setText(list.get(position).des);
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
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
