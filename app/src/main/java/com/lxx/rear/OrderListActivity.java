package com.lxx.rear;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxx.rear.frame.base.BaseActivity;

/**OrderListActivity
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class OrderListActivity extends BaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("我的预约");
    }
}