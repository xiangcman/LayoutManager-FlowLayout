package com.single.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.library.flowlayout.FlowLayoutManager;

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
            "10.JavaScript",
            "11.Ruby",
            "12.Visual Basic .NET",
            "13.Transact-SQL",
            "14.Lisp",
            "15.Pascal",
            "16.Bash",
            "17.PL/SQL",
            "18.Delphi/Object Pascal",
            "19.Ada",
            "20.MATLAB", "1.C",
            "2.Java",
            "3.Objective-C",
            "4.C++",
            "5.PHP",
            "6.C#",
            "7.(Visual) Basic",
            "8.Python",
            "9.Perl",
            "10.JavaScript",
            "11.Ruby",
            "12.Visual Basic .NET",
            "13.Transact-SQL",
            "14.Lisp",
            "15.Pascal",
            "16.Bash",
            "17.PL/SQL",
            "18.Delphi/Object Pascal",
            "19.Ada",
            "20.MATLAB", "1.C",
            "2.Java",
            "3.Objective-C",
            "4.C++",
            "5.PHP",
            "6.C#",
            "7.(Visual) Basic",
            "8.Python",
            "9.Perl",
            "10.JavaScript",
            "11.Ruby",
            "12.Visual Basic .NET",
            "13.Transact-SQL",
            "14.Lisp",
            "15.Pascal",
            "16.Bash",
            "17.PL/SQL",
            "18.Delphi/Object Pascal",
            "19.Ada",
            "20.MATLAB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(flow);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager(this);
        flowLayoutManager.setMargin(dp2px(10));
        recyclerView.setLayoutManager(flowLayoutManager);
        recyclerView.setAdapter(new FlowAdapter());
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        SparseArray<Drawable> allDrawAble = new SparseArray<>();

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(TextFlowActivity.this, R.layout.flow_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = ((MyHolder) holder).text;
            if (allDrawAble.get(position) == null) {
                allDrawAble.put(position, getBack());
            }
            textView.setBackgroundDrawable(allDrawAble.get(position));
            textView.setText(arrays[position]);
        }

        private Drawable getBack() {
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadius(8);
            drawable.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            return drawable;
        }

        @Override
        public int getItemCount() {
            return arrays.length;
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
