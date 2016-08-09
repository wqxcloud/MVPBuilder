package com.yihukurama.www.mvpbuilder.framework.v.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yihukurama.www.mvpbuilder.R;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IActivity;

public class BaseActivity extends AppCompatActivity implements IActivity,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
