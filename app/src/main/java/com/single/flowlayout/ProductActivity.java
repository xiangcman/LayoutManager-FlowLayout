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
    private static final String TAG = ProductActivity.class.getSimpleName();
    //    private TextView suspension;
    protected RecyclerView productView;
    protected List<Product.Classify> classifies = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productView = (RecyclerView) findViewById(R.id.product_view);
        productView.setLayoutManager(new LinearLayoutManager(this));

        classifies.add(new Product.Classify("颜色", Arrays.asList(new Product.Classify.Des("红色"),
                new Product.Classify.Des("白色"),
                new Product.Classify.Des("蓝色"),
                new Product.Classify.Des("橘黄色"),
                new Product.Classify.Des("格调灰"),
                new Product.Classify.Des("深色"),
                new Product.Classify.Des("咖啡色"))));
        classifies.add(new Product.Classify("尺寸", Arrays.asList(new Product.Classify.Des("180"),
                new Product.Classify.Des("175"),
                new Product.Classify.Des("170"),
                new Product.Classify.Des("165"),
                new Product.Classify.Des("160"),
                new Product.Classify.Des("155"),
                new Product.Classify.Des("150"))));
        classifies.add(new Product.Classify("款式",
                Arrays.asList(new Product.Classify.Des("男款"), new Product.Classify.Des("女款"),
                        new Product.Classify.Des("中年款"),
                        new Product.Classify.Des("潮流款"),
                        new Product.Classify.Des("儿童款"))));
        classifies.add(new Product.Classify("腰围", Arrays.asList(new Product.Classify.Des("26"),
                new Product.Classify.Des("27"),
                new Product.Classify.Des("28"),
                new Product.Classify.Des("29"),
                new Product.Classify.Des("30"),
                new Product.Classify.Des("31"),
                new Product.Classify.Des("32"),
                new Product.Classify.Des("33"),
                new Product.Classify.Des("34"),
                new Product.Classify.Des("35"))));
        classifies.add(new Product.Classify("肩宽", Arrays.asList(new Product.Classify.Des("26"),
                new Product.Classify.Des("27"),
                new Product.Classify.Des("28"),
                new Product.Classify.Des("29"),
                new Product.Classify.Des("30"),
                new Product.Classify.Des("31"),
                new Product.Classify.Des("32"),
                new Product.Classify.Des("33"),
                new Product.Classify.Des("34"),
                new Product.Classify.Des("35"))));
        classifies.add(new Product.Classify("臂长", Arrays.asList(new Product.Classify.Des("26"),
                new Product.Classify.Des("27"),
                new Product.Classify.Des("28"),
                new Product.Classify.Des("29"),
                new Product.Classify.Des("30"),
                new Product.Classify.Des("31"),
                new Product.Classify.Des("32"),
                new Product.Classify.Des("33"),
                new Product.Classify.Des("34"),
                new Product.Classify.Des("35"))));
        productView.setAdapter(new ProductAdapter(this, classifies));
    }

}
