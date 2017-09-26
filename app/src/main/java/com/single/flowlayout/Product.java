package com.single.flowlayout;

import java.util.List;

/**
 * Created by xiangcheng on 17/9/26.
 */

public class Product {
    public List<Classify> classify;

    static public class Classify {
        public String title;
        List<String> des;

        public Classify(String title, List<String> des) {
            this.title = title;
            this.des = des;
        }
    }
}
