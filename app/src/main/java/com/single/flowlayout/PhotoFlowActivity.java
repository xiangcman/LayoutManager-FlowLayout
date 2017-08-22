package com.single.flowlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.library.flowlayout.FlowLayoutManager;

/**
 * Created by xiangcheng on 17/3/19.
 */

public class PhotoFlowActivity extends Activity {
    private static final String arrays[] = new String[]{
            "http://a4.topitme.com/l/201101/25/12959386712894.jpg",
            "http://a4.topitme.com/l/201009/29/12857488431166.jpg",
            "http://a4.topitme.com/o/201005/20/12743682354851.jpg",
            "http://a4.topitme.com/o/201002/07/12655476187814.jpg",
            "http://a4.topitme.com/l/201008/24/12826372628592.jpg",
            "http://a4.topitme.com/o/201010/25/12879776661298.jpg",
            "http://a4.topitme.com/l/201006/13/12764179535658.jpg",
            "http://a4.topitme.com/o/201010/07/12864139597040.jpg",
            "http://a4.topitme.com/l/200911/02/12571660288201.jpg",
            "http://a4.topitme.com/l/201010/25/12879982826170.jpg",
            "http://a4.topitme.com/l/201005/28/12750473483199.jpg",
            "http://a3.topitme.com/9/75/b6/11662807867c2b6759o.jpg",
            "http://a4.topitme.com/l/201012/08/12918172069789.jpg",
            "http://a4.topitme.com/l/200912/16/12609717687530.jpg",
            "http://a4.topitme.com/l154/101545352827be1f30.jpg",
            "http://a4.topitme.com/l/201007/03/12781348268956.jpg",
            "http://a4.topitme.com/l/201101/10/12946618524338.jpg",
            "http://a4.topitme.com/o/201010/07/12864139597040.jpg",
            "http://a4.topitme.com/l/201007/12/12789053047620.jpg",
            "http://a4.topitme.com/o/201002/02/12650420481465.jpg",
            "http://a4.topitme.com/l/201005/10/12735029693898.jpg",
            "http://a4.topitme.com/l085/10085746325d398b87.jpg",
            "http://a4.topitme.com/l/200911/07/12575707872040.jpg",
            "http://a4.topitme.com/o/201008/26/12827937063388.jpg",
            "http://a4.topitme.com/l/200911/07/12575708578130.jpg",
            "http://a4.topitme.com/l/201004/13/12711383653212.jpg",
            "http://a4.topitme.com/l/200912/10/12604112121802.jpg",
            "http://a4.topitme.com/l/201005/17/12740893805467.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_flow);
        RecyclerView viewById = (RecyclerView) findViewById(R.id.photo_layout);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setMargin(dp2px(10));
        viewById.setLayoutManager(flowLayoutManager);
        viewById.setAdapter(new FlowAdapter());
    }

    class FlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private static final int TYPE_WIDTHER = 1;
        private static final int TYPE_NORMAL = 2;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == TYPE_WIDTHER) {
                return new MyHolder(View.inflate(PhotoFlowActivity.this, R.layout.flow_photo_widther_item, null));
            } else {
                return new MyHolder(View.inflate(PhotoFlowActivity.this, R.layout.flow_photo_item, null));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImageView imageView = ((MyHolder) holder).img;
            Glide.with(PhotoFlowActivity.this)
                    .load(arrays[position])
                    .into(imageView);
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 3 == 0) {
                return TYPE_WIDTHER;
            } else {
                return TYPE_NORMAL;
            }
        }

        @Override
        public int getItemCount() {
            return arrays.length;
        }

        class MyHolder extends RecyclerView.ViewHolder {

            private ImageView img;

            public MyHolder(View itemView) {
                super(itemView);
                img = (ImageView) itemView.findViewById(R.id.flow_img);
            }
        }
    }

    private int dp2px(float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
