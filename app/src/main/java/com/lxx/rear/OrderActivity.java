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
import com.lxx.rear.frame.view.OrderPanel;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderActivity
 * <p>
 * <p/>
 * Created by luoyingxing on 2019/1/11.
 */
public class OrderActivity extends BaseActivity {
    private TextView nameTV;
    private TextView infoTV;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_order;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("挂号预约");

        nameTV = findViewById(R.id.tv_order_name);
        infoTV = findViewById(R.id.tv_order_info);
        GridView gridView = findViewById(R.id.gv_order);

        final CommonAdapter<Project> adapter = new CommonAdapter<Project>(this, new ArrayList<Project>(), R.layout.item_order) {
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Project project = adapter.getItem(position);
                if (project.isEnable()) {
                    showSelectWindow(project);
                }
            }
        });

        adapter.addAll(Project.getOrderProjects());
    }

    private OrderPanel orderPanel;

    private void showSelectWindow(final Project project) {
        nameTV.setText(project.getName());
        infoTV.setText(project.getIntroduce());

        List<String> items = new ArrayList<>();
        if (project.getTitle().equals("上午")) {
            items.add("8：40 - 10：00");
            items.add("10：00 - 11：00");
            items.add("11：00 - 12：00");
        } else {
            items.add("14：15 - 15：30");
            items.add("15：30 - 16：30");
            items.add("16：30 - 17：20");
        }

        orderPanel = new OrderPanel(this)
                .refresh(items)
                .setSelectListener(new OrderPanel.SelectListener() {
                    @Override
                    public void onResult(String time) {
                        jump(project, time);
                    }
                });
        orderPanel.show(getCurrentFocus());
    }

    private void jump(Project project, String time) {
        orderPanel.dismiss();

        Intent intent = new Intent(OrderActivity.this, ReservationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("time", time);
        bundle.putSerializable("project", project);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}