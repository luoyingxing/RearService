package com.lxx.rear.frame.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.lxx.rear.R;
import com.lxx.rear.frame.adapter.CommonAdapter;
import com.lxx.rear.frame.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * OrderPanel
 * <p>
 * Created by luoyingxing on 2017/7/19.
 */

public class OrderPanel extends PopupWindow {
    private Context mContext;
    private View mRootView;
    private int mDefStyleAttr;

    private int getLayoutResource() {
        return R.layout.panel_order;
    }

    public OrderPanel() {
    }

    public OrderPanel(Context context) {
        this(context, null, 0);
    }

    public OrderPanel(Context context, int defStyleAttr) {
        this(context, null, defStyleAttr);
    }

    private OrderPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mDefStyleAttr = defStyleAttr;
        mRootView = LayoutInflater.from(context).inflate(getLayoutResource(), null);
        setContentView(mRootView);

        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        setWidth(width);
        setHeight(height);

        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable());
        setAnimationStyle(getDefStyleAttr());

        init();
    }

    private CommonAdapter<String> adapter;

    private void init() {
        findViewById(R.id.tv_order_panel_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        findViewById(R.id.space_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        adapter = new CommonAdapter<String>(getContext(), new ArrayList<String>(), R.layout.item_order_time) {
            @Override
            protected void convert(ViewHolder holder, String item, int position) {
                holder.setText(R.id.tv_item_order_time, item);
            }
        };

        ListView listView = findViewById(R.id.lv_order_panel);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (null != selectListener) {
                    selectListener.onResult(adapter.getItem(position));
                }
            }
        });
    }

    public OrderPanel refresh(List<String> list) {
        adapter.addAll(list);
        return this;
    }

    public View getParent() {
        return mRootView;
    }

    private int getDefStyleAttr() {
        return mDefStyleAttr;
    }

    private Context getContext() {
        return mContext;
    }

    private <T extends View> T findViewById(int viewId) {
        return (T) mRootView.findViewById(viewId);
    }

    public void show(View parent) {
        showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

    public interface SelectListener {
        void onResult(String time);
    }

    private SelectListener selectListener;

    public OrderPanel setSelectListener(SelectListener listener) {
        selectListener = listener;
        return this;
    }
}