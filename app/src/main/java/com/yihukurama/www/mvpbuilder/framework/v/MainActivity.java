package com.yihukurama.www.mvpbuilder.framework.v;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yihukurama.www.mvpbuilder.R;
import com.yihukurama.www.mvpbuilder.framework.v.activity.BaseActivity;
import com.yihukurama.www.mvpbuilder.framework.v.activity.DBExampleActivity;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IMainActivity;

public class MainActivity extends BaseActivity implements IMainActivity,View.OnClickListener{

    Button btnDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }


    @Override
    public void initView() {
        btnDB = (Button)findViewById(R.id.dbBtn);
        btnDB.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.dbBtn:
                Intent intent = new Intent(this, DBExampleActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }
}
