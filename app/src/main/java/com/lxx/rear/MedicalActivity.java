package com.lxx.rear;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lxx.rear.entity.Project;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;
import com.lxx.rear.frame.base.BaseActivity;

import java.util.ArrayList;

/**
 * MedicalActivity
 * <p/>
 * Created by luoyingxing on 2019/1/11.
 */
public class MedicalActivity extends BaseActivity {

    @Override
    protected int getLayoutID() {
        return R.layout.activity_medical;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("医疗服务");

        GridView gridView = findViewById(R.id.gv_medical);

        CommonAdapter<Project> adapter = new CommonAdapter<Project>(this, new ArrayList<Project>(), R.layout.item_medical) {
            @Override
            protected void convert(ViewHolder holder, Project item, int position) {
                holder.setImageDrawable(R.id.iv_item_medical, getResources().getDrawable(item.getIcon()));
                holder.setText(R.id.tv_item_medical, item.getTitle());
            }
        };

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(MedicalActivity.this, OrderActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MedicalActivity.this, OrderListActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MedicalActivity.this, InsuranceActivity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

        adapter.addAll(Project.getMedicalProjects());
    }

}