package com.lxx.rear.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lxx.rear.R;

/**
 * BaseActivity
 * <p>
 * author:  luoyingxing
 * date: 2019/1/11.
 */
public class BaseActivity extends AppCompatActivity {

    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
    }
}