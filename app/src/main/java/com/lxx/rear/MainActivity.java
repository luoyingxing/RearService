package com.lxx.rear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lxx.rear.entity.Project;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;
import com.lxx.rear.frame.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridView gridView = findViewById(R.id.gv_main);

        hideBack();
        setSubTitle("智慧后勤");

        CommonAdapter<Project> adapter = new CommonAdapter<Project>(this, new ArrayList<Project>(), R.layout.item_main) {
            @Override
            protected void convert(ViewHolder holder, Project item, int position) {
                holder.setImageDrawable(R.id.iv_item_main, getResources().getDrawable(item.getIcon()));
                holder.setText(R.id.tv_item_main, item.getTitle());
            }
        };

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, MedicalActivity.class);
                    startActivity(intent);
                }
            }
        });

        adapter.addAll(Project.getMainProjects());
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

}