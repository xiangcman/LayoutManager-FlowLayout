package com.single.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.single.flowlayout.R.id.flow;

public class LongClickDeleteTextFlowActivity extends AppCompatActivity {
    private static final String TAG = TextFlowActivity.class.getSimpleName();

    private List<ShowItem> list = new ArrayList<>();

    private FlowAdapter flowAdapter;
    private boolean touchRv;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        recyclerView = (RecyclerView) findViewById(flow);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        recyclerView.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        recyclerView.setLayoutManager(flowLayoutManager);
        list = DataConfig.getItems();
        recyclerView.setAdapter(flowAdapter = new FlowAdapter(list));
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    touchRv = true;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (touchRv) {
                            flowAdapter.refreshSelect();
                        }
                    }
                }
                return true;
            }
        });
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<ShowItem> list;

        private int selectPosition = -1;

        public FlowAdapter(List<ShowItem> list) {
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(LongClickDeleteTextFlowActivity.this, R.layout.flow_item, null));
        }

        @Override
        public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
            final TextView textView = ((MyHolder) holder).text;
            textView.setBackgroundDrawable(list.get(position).color);
            textView.setText(list.get(position).des);
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    final ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    final int width = textView.getMeasuredWidth();
                    final int height = textView.getMeasuredHeight();

                    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            if (!list.get(position).isSelect) {
                                textView.setBackgroundDrawable(getBack());
                                textView.setText("删除");
                                layoutParams.width = width;
                                layoutParams.height = height;
                                textView.setLayoutParams(layoutParams);
                                list.get(position).isSelect = true;
                                selectPosition = position;
                            }
                            touchRv = false;
                            return true;
                        }
                    });
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d(TAG, "position:" + position);
                            Log.d(TAG, "selectPosition:" + selectPosition);
                            if (position == selectPosition) {
                                list.remove(position);
                                notifyItemRemoved(position);
                                flowAdapter.notifyItemRangeChanged(position, list.size() - position);
                                selectPosition = -1;
                            } else {
                                if (selectPosition != -1) {
                                    RecyclerView.ViewHolder viewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(selectPosition);
                                    TextView selectTv = ((MyHolder) viewHolderForAdapterPosition).text;
                                    selectTv.setBackgroundDrawable(list.get(selectPosition).color);
                                    selectTv.setText(list.get(selectPosition).des);
                                    list.get(selectPosition).isSelect = false;
                                    selectPosition = -1;
                                } else {
                                    //做你的跳转
                                    Toast.makeText(LongClickDeleteTextFlowActivity.this, list.get(position).des, Toast.LENGTH_SHORT).show();
                                }
                            }
                            touchRv = false;
                        }
                    });
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public void refreshSelect() {
            if (selectPosition != -1) {
                RecyclerView.ViewHolder viewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(selectPosition);
                TextView selectTv = ((MyHolder) viewHolderForAdapterPosition).text;
                selectTv.setBackgroundDrawable(list.get(selectPosition).color);
                selectTv.setText(list.get(selectPosition).des);
                list.get(selectPosition).isSelect = false;
            }
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private TextView text;

            public MyHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.flow_text);
            }
        }
    }

    private Drawable getBack() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(8);
        drawable.setColor(Color.parseColor("#ff0000"));
        return drawable;
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
