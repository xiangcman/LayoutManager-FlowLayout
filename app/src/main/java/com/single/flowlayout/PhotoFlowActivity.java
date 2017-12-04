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
import com.library.flowlayout.SpaceItemDecoration;

/**
 * Created by xiangcheng on 17/3/19.
 */

public class PhotoFlowActivity extends Activity {
    private static final String arrays[] = new String[]{
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_e_t_o_n_se_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_e_th_t_th_o_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_e_th_th_f_o_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_fi_z_se_o_se_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_t_fi_t_n_f_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_n_e_se_t_n_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/anyixuan/www.n63.com_dr_e_n_fi_e_e_se_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/ASOSxxy/n63.com_bx_e_z_f_th_se_se_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/ASOSxxy/n63.com_bx_f_se_fi_e_se_f_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/ASOSxxy/n63.com_bx_n_f_e_t_th_fi_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/ASOSxxy/n63.com_bx_n_n_z_f_e_th_ll.jpg",
            "http://www.n63.com/photodir/img.php/thumbnail//china/ASOSxxy/n63.com_bx_o_z_e_t_t_f_ll.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1976293921,1270633268&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=779788657,4292815127&fm=11&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2290067343,2226788365&fm=11&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4060653417,3747803775&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1992761446,3362001450&fm=27&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2633672070,3783912955&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=362114848,334146577&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=88285253,4228312326&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=767238045,2403790718&fm=27&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=689631514,1944017813&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3987323356,2095973354&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1684173933,1618093809&fm=27&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=945145300,1358809878&fm=27&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3467999029,290220372&fm=27&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1227784623,1033224162&fm=27&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4196341137,3654139365&fm=27&gp=0.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_flow);
        RecyclerView viewById = (RecyclerView) findViewById(R.id.photo_layout);
        FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
        viewById.addItemDecoration(new SpaceItemDecoration(dp2px(5)));
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
