package com.lxx.rear;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.lxx.rear.entity.Project;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;
import com.lxx.rear.frame.base.BaseActivity;

import java.util.ArrayList;

/**
 * OrderActivity
 * <p>
 * <p/>
 * Created by luoyingxing on 2019/1/11.
 */
public class OrderActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_order;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("挂号预约");


        GridView gridView = findViewById(R.id.gv_order);

        CommonAdapter<Project> adapter = new CommonAdapter<Project>(this, new ArrayList<Project>(), R.layout.item_order) {
            @Override
            protected void convert(ViewHolder holder, Project item, int position) {
                holder.setText(R.id.tv_item_order_title1, item.getTitle1());
                holder.setText(R.id.tv_item_order_title2, item.getTitle2());

                TextView titleTV = holder.getView(R.id.tv_item_order_title);
                titleTV.setText(item.getTitle());

                if (item.isEnable()) {
                    holder.getConvertView().setBackgroundResource(R.color.sample_blue);
                    titleTV.setTextColor(Color.WHITE);
                } else {
                    holder.getConvertView().setBackgroundResource(R.color.gray_f9);
                    titleTV.setTextColor(getResources().getColor(R.color.gray_21));
                }
            }
        };

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

        adapter.addAll(Project.getOrderProjects());

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(OrderActivity.this, ReservationActivity.class);
        startActivity(intent);

    }
}