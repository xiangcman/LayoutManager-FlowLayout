package com.single.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        RecyclerView productView = (RecyclerView) findViewById(R.id.product_view);
        productView.setLayoutManager(new LinearLayoutManager(this));
        List<Product.Classify> classifies = new ArrayList<>();
        classifies.add(new Product.Classify("颜色", Arrays.asList("红色", "白色", "蓝色")));
        classifies.add(new Product.Classify("尺寸", Arrays.asList("180", "175", "170", "165", "160", "155", "150")));
        classifies.add(new Product.Classify("款式", Arrays.asList("男款", "女款", "中年款", "潮流款", "儿童款")));
        productView.setAdapter(new ProductAdapter(this, classifies));
    }

}
