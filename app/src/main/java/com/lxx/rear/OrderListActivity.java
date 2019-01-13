package com.lxx.rear;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.lxx.rear.entity.Order;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;
import com.lxx.rear.frame.base.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


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
                holder.setText(R.id.tv_item_order_list_doctor, "医生：" + item.getDoctor());
                holder.setText(R.id.tv_item_order_list_number, item.getNumber());
                holder.setText(R.id.tv_item_order_list_time, "就诊时间：" + item.getTime());

            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDeleteDialog(position);
                return false;
            }
        });
    }

    private void showDeleteDialog(final int position) {
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确定删除该条记录吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteOrder(position);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData(false);
    }

    private void loadData(boolean already) {
        adapter.clear();
        if (!already) {
            String json = getOrders();
            List<Order> list = new ArrayList<>();

            if (TextUtils.isEmpty(json)) {
                return;
            }

            try {
                JSONArray array = new JSONArray("[" + json + "]");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = (JSONObject) array.get(i);

                    Order order = new Order();
                    order.setId(object.getString("id"));
                    order.setTitle(object.getString("title"));
                    order.setRoom(object.getString("room"));
                    order.setStatus(object.getString("status"));
                    order.setDoctor(object.getString("doctor"));
                    order.setNumber(object.getString("number"));
                    order.setTime(object.getString("time"));

                    list.add(order);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            adapter.addAll(list);
        }
    }

    private void deleteOrder(int position) {
        Order order = adapter.getItem(position);

        String json = getOrders();
        List<Order> list = new ArrayList<>();

        try {
            JSONArray array = new JSONArray("[" + json + "]");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = (JSONObject) array.get(i);
                String id = object.getString("id");

                if (id.equals(order.getId())) {
                    array.remove(i);
                    break;
                }
            }

            String newJson = array.toString();

            newJson = newJson.substring(1, newJson.length() - 1);
            saveOrders(newJson);

            loadData(false);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void saveOrders(String value) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("order", value).apply();
    }


    public String getOrders() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString("order", null);
    }
}