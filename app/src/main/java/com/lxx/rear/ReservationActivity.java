package com.lxx.rear;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxx.rear.frame.base.BaseActivity;

/**
 * ReservationActivity
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class ReservationActivity extends BaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_reservation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("预约下单");
    }
}
