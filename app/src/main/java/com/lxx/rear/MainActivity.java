package com.lxx.rear;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
        mExitTime = System.currentTimeMillis();

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
                } else {
                    showToast("该功能未推出，敬请期待！");
                }
            }
        });

        adapter.addAll(Project.getMainProjects());
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    private long mExitTime;

    private void goBack() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            showToast("再点一次退出APP");
            mExitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}