package com.single.flowlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by xiangcheng on 17/3/19.
 */

public class LanuchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuch);
        findViewById(R.id.text_flow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, TextFlowActivity.class));
            }
        });
        findViewById(R.id.photo_flow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, PhotoFlowActivity.class));
            }
        });
        findViewById(R.id.diff_height_text_flow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, DiffHeightTextFlowActivity.class));
            }
        });
        findViewById(R.id.product_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, ProductActivity.class));
            }
        });
        findViewById(R.id.suspension_product_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, SuspensionProductActivity.class));
            }
        });
        findViewById(R.id.viewpage_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, ViewPagerActivity.class));
            }
        });
        findViewById(R.id.longclick_delete_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LanuchActivity.this, LongClickDeleteTextFlowActivity.class));
            }
        });
    }
}
