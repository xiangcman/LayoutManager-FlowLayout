package com.single.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.single.flowlayout.R.id.flow;

public class TextFlowActivity extends AppCompatActivity {
    private static final String arrays[] = new String[]{"1.C",
            "2.Java",
            "3.Objective-C",
            "4.C++",
            "5.PHP",
            "6.C#",
            "7.(Visual) Basic",
            "8.Python",
            "9.Perl",
            "10.JavaScript"

    };
    //            "17.PL/SQL",
//            "18.Delphi/Object Pascal",
//            "19.Ada",
//            "20.MATLAB", "1.C",
//            "2.Java",
//            "3.Objective-C",
//            "4.C++",
//            "5.PHP",
//            "6.C#",
//            "7.(Visual) Basic",
//            "8.Python",
//            "9.Perl",
//            "10.JavaScript",
//            "11.Ruby",
//            "12.Visual Basic .NET",
//            "13.Transact-SQL",
//            "14.Lisp",
//            "15.Pascal",
//            "16.Bash",
//            "17.PL/SQL",
//            "18.Delphi/Object Pascal",
//            "19.Ada",
//            "20.MATLAB", "1.C",
//            "2.Java",
//            "3.Objective-C",
//            "4.C++",
//            "5.PHP",
//            "6.C#",
//            "7.(Visual) Basic",
//            "8.Python",
//            "9.Perl",
//            "10.JavaScript",
//            "11.Ruby",
//            "12.Visual Basic .NET",
//            "13.Transact-SQL",
//            "14.Lisp",
//            "15.Pascal",
//            "16.Bash",
//            "17.PL/SQL",
//            "18.Delphi/Object Pascal",
//            "19.Ada",
//            "20.MATLAB"
    private static final String TAG = TextFlowActivity.class.getSimpleName();

    private List<String> list = new ArrayList<>();

    private Handler handler = new Handler();

    private FlowAdapter flowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        final RecyclerView recyclerView = (RecyclerView) findViewById(flow);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
//        LinearLayoutManager flowLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        recyclerView.setLayoutManager(flowLayoutManager);
        list.addAll(Arrays.asList(arrays));
        recyclerView.setAdapter(flowAdapter = new FlowAdapter(list));
        //模拟网络的代码
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int start = list.size();
                //处理新增的实例
//                list.add("11.新增的");
//                list.add("12.新增的");
//                list.add("12.新增的");
//                flowAdapter.notifyDataSetChanged();
                //处理清空的实例
//                int size = list.size();
//                list.add(list.size() - 2, "新增的数据啊");
//                list.clear();
                list.remove(list.size() - 4);
                flowAdapter.notifyItemRemoved(list.size() - 4);
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        //处理清空的实例
//                        list.add("11.新增的");
//                        list.add("12.新增的");
//                        list.add("12.新增的");
//                        flowAdapter.notifyDataSetChanged();
//                    }
//                }, 2000);
            }
        }, 2000);
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<String> list;

        public FlowAdapter(List<String> list) {
            this.list = list;
        }

        SparseArray<Drawable> allDrawAble = new SparseArray<>();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(TextFlowActivity.this, R.layout.flow_item, null));
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
                    Toast.makeText(TextFlowActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
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
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
