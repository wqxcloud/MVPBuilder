package com.yihukurama.www.mvpbuilder.framework.v;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yihukurama.www.mvpbuilder.R;
import com.yihukurama.www.mvpbuilder.framework.p.MainP;
import com.yihukurama.www.mvpbuilder.framework.v.activity.BaseActivity;
import com.yihukurama.www.mvpbuilder.framework.v.activity.LoginActivity;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IMainActivity;

public class MainActivity extends BaseActivity implements IMainActivity{

    Button btnLogin;
    MainP mainP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void gotoLoginExample() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void initView() {
        btnLogin = (Button)findViewById(R.id.loginBtn);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.loginBtn:
                mainP.gotoLogin();
                break;
            default:
                break;
        }
    }
}
