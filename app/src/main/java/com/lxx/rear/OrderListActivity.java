package com.lxx.rear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.lxx.rear.entity.Order;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;
import com.lxx.rear.frame.base.BaseActivity;

import java.util.ArrayList;

/**
 * OrderListActivity
 * <p/>
 * Created by luoyingxing on 2019/1/12.
 */
public class OrderListActivity extends BaseActivity {
    private CommonAdapter<Order> adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("我的预约");

        ((RadioGroup) findViewById(R.id.rg_order_list)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_order_list_left:
                        loadData(false);
                        break;
                    case R.id.rb_order_list_right:
                        loadData(true);
                        break;
                }
            }
        });


        ListView listView = findViewById(R.id.lv_order_list);
        adapter = new CommonAdapter<Order>(this, new ArrayList<Order>(), R.layout.item_order_list) {
            @Override
            protected void convert(ViewHolder holder, Order item, int position) {
                holder.setText(R.id.tv_item_order_list_title, item.getTitle());
                holder.setText(R.id.tv_item_order_list_status, item.getStatus());
                holder.setText(R.id.tv_item_order_list_room, item.getRoom());
                holder.setText(R.id.tv_item_order_list_doctor, item.getDoctor());
                holder.setText(R.id.tv_item_order_list_number, item.getNumber());
                holder.setText(R.id.tv_item_order_list_time, item.getTime());

            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData(false);
    }

    private void loadData(boolean already) {
        adapter.clear();
        if (!already) {
            adapter.addAll(Order.getOrders());
        }
    }
}