package com.lxx.rear;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lxx.rear.entity.Order;
import com.lxx.rear.entity.Project;
import com.lxx.rear.frame.base.BaseActivity;

/**
 * ReservationActivity
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class ReservationActivity extends BaseActivity {
    private TextView nameTV;
    private TextView dataTV;
    private TextView timeTV;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_reservation;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("预约下单");

        nameTV = findViewById(R.id.tv_reservation_name);
        dataTV = findViewById(R.id.tv_reservation_date);
        timeTV = findViewById(R.id.tv_reservation_time);
        findViewById(R.id.btn_reservation_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = Order.cloneOrder();
                order.setDoctor(nameTV.getText().toString().trim());
                order.setTime(dataTV.getText().toString().trim() + " " + timeTV.getText().toString().trim());

                //String title, String room, String status, String doctor, String number, String time
                StringBuilder json = new StringBuilder();
                json.append("{");
                json.append("\"title\":\"").append(order.getTitle()).append("\"");
                json.append(",");
                json.append("\"room\":\"").append(order.getRoom()).append("\"");
                json.append(",");
                json.append("\"status\":\"").append(order.getStatus()).append("\"");
                json.append(",");
                json.append("\"doctor\":\"").append(order.getDoctor()).append("\"");
                json.append(",");
                json.append("\"number\":\"").append(order.getNumber()).append("\"");
                json.append(",");
                json.append("\"time\":\"").append(order.getTime()).append("\"");
                json.append("}");


                String old = getOrders();
                StringBuilder newJson = new StringBuilder();
                if (TextUtils.isEmpty(old)) {
                    newJson.append(json);
                } else {
                    newJson.append(old);
                    newJson.append(",");
                    newJson.append(json);
                }

                saveOrders(newJson.toString());

                showLongToast("预约成功！");

                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();

        Project project = (Project) bundle.get("project");
        nameTV.setText(project.getName());

        dataTV.setText("2019-" + project.getTitle2());

        String time = (String) bundle.get("time");
        timeTV.setText(time);
    }

    public void saveOrders(String value) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("order", value).apply();
    }

    public String getOrders() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString("order", null);
    }
}