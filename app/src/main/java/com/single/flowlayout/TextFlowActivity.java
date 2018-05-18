package com.single.flowlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.single.flowlayout.R.id.flow;

public class TextFlowActivity extends AppCompatActivity {
    private static final String TAG = TextFlowActivity.class.getSimpleName();

    private List<ShowItem> list = new ArrayList<>();

    private Handler handler = new Handler();

    private FlowAdapter flowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        final RecyclerView recyclerView = (RecyclerView) findViewById(flow);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        recyclerView.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        recyclerView.setLayoutManager(flowLayoutManager);
        list = DataConfig.getItems();
        recyclerView.setAdapter(flowAdapter = new FlowAdapter(list));
        //模拟网络的代码
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                list.clear();
                flowAdapter.notifyDataSetChanged();
//                int position = list.size() - 4;
//                list.remove(position);
//
//                flowAdapter.notifyItemRemoved(position);
//                flowAdapter.notifyItemRangeChanged(position, list.size() - position);
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        int start = list.size();
//                        list.add(new ShowItem("新增的1"));
//                        list.add(new ShowItem("新增的2"));
//                        list.add(new ShowItem("新增的3"));
//                        flowAdapter.notifyItemInserted(start);
//                        flowAdapter.notifyItemRangeChanged(start, list.size() - start);
//
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                int start = list.size() / 2;
//                                list.add(start, new ShowItem("中间添加的数据"));
//                                flowAdapter.notifyItemInserted(start);
//                                flowAdapter.notifyItemRangeChanged(start, list.size() - start);
//                            }
//                        }, 2000);
//                    }
//                }, 2000);
            }
        }, 2000);
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<ShowItem> list;

        public FlowAdapter(List<ShowItem> list) {
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(TextFlowActivity.this, R.layout.flow_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            TextView textView = ((MyHolder) holder).text;
            textView.setBackgroundDrawable(list.get(position).color);
            textView.setText(list.get(position).des);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(TextFlowActivity.this, list.get(position).des, Toast.LENGTH_SHORT).show();
                }
            });
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
