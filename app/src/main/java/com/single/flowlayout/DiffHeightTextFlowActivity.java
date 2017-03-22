package com.single.flowlayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.library.flowlayout.FlowLayoutManager;

import java.util.Random;

public class DiffHeightTextFlowActivity extends AppCompatActivity {
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
            "20.MATLAB", "20.MATLAB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout);
        RecyclerView viewById = (RecyclerView) findViewById(R.id.flow);
        viewById.setLayoutManager(new FlowLayoutManager());
        viewById.setAdapter(new FlowAdapter());
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_HEIGER = 1;
        private static final int TYPE_NORMAL = 2;
        SparseArray<Drawable> allDrawAble = new SparseArray<>();

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
}
