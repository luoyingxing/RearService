package com.lxx.rear.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lxx.rear.R;

/**
 * BaseActivity
 * <p>
 * author:  luoyingxing
 * date: 2019/1/11.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView backIV;
    private TextView titleTV;
    private TextView subTitleTV;
    private CharSequence mTitle;

    protected int getLayoutID() {
        return R.layout.activity_base;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.actionbar_custom_view);
            actionBar.setElevation(2);
            Toolbar parent = (Toolbar) actionBar.getCustomView().getParent();
            parent.setContentInsetsAbsolute(0, 0);
        }

        backIV = findViewById(R.id.back);
        backIV.setOnClickListener(this);

        titleTV = findViewById(R.id.title);
        titleTV.setText(mTitle);

        subTitleTV = findViewById(R.id.sub_title);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mTitle = title;
        titleTV.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackClick();
                break;
        }
    }

    protected void onBackClick() {
        finish();
    }

    protected void hideBack() {
        backIV.setVisibility(View.INVISIBLE);
    }

    protected void setSubTitle(CharSequence title) {
        subTitleTV.setText(title);
    }

    private Toast mToast;

    protected void showToast(Object msg) {
        if (null != mToast) {
            mToast.cancel();
        }

        mToast = Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    protected void showLongToast(Object msg) {
        if (null != mToast) {
            mToast.cancel();
        }

        mToast = Toast.makeText(this, "" + msg, Toast.LENGTH_LONG);
        mToast.show();
    }
}