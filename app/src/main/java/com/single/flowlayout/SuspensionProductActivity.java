package com.single.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class SuspensionProductActivity extends ProductActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productView.addItemDecoration(new SuspensionDecoration(this, classifies));
    }

}
