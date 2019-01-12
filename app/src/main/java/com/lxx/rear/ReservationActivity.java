package com.lxx.rear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lxx.rear.entity.Project;
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

        TextView nameTV = findViewById(R.id.tv_reservation_name);
        TextView dataTV = findViewById(R.id.tv_reservation_date);
        TextView timeTV = findViewById(R.id.tv_reservation_time);
        findViewById(R.id.btn_reservation_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("该功能即将推出，敬请期待！");
            }
        });

        Bundle bundle = getIntent().getExtras();

        Project project = (Project) bundle.get("project");
        nameTV.setText(project.getName());

        dataTV.setText("2019-" + project.getTitle2());

        String time = (String) bundle.get("time");
        timeTV.setText(time);
    }
}