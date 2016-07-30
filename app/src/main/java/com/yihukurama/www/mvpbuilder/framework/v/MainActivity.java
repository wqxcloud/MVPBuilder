package com.yihukurama.www.mvpbuilder.framework.v;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yihukurama.www.mvpbuilder.R;
import com.yihukurama.www.mvpbuilder.framework.v.activity.LoginActivity;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IMainActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity{

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
}
