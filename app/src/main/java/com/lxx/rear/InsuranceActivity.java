package com.lxx.rear;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lxx.rear.frame.base.BaseActivity;

/**InsuranceActivity
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class InsuranceActivity extends BaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_insurance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("医疗保险");
    }
}