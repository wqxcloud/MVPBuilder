package com.yihukurama.www.mvpbuilder.framework.v.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yihukurama.www.mvpbuilder.R;
import com.yihukurama.www.mvpbuilder.framework.m.dao.bean.User;
import com.yihukurama.www.mvpbuilder.framework.p.DBP;
import com.yihukurama.www.mvpbuilder.framework.p.interfacePresenter.IDB;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IDBExampleActivity;

import java.util.List;

public class DBExampleActivity extends AppCompatActivity implements IDBExampleActivity, View.OnClickListener{

    IDB p;
    Button iBtn;
    Button dBtn;
    Button uBtn;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        initView();
        initData();
    }

    @Override
    public void initView() {
        iBtn = (Button)findViewById(R.id.insertBtn);
        dBtn = (Button)findViewById(R.id.delBtn);
        uBtn = (Button)findViewById(R.id.updateBtn);
        tx = (TextView)findViewById(R.id.dbresult); 
        iBtn.setOnClickListener(this);
        dBtn.setOnClickListener(this);
        uBtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        p = new DBP(this);
    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public void showDBResult() {
        List<User> users = p.query();
        String result ="数据库数据\n";
        for (User user:users
             ) {
            result=result+" "+user.getName()+"\n";
        }
        tx.setText(result);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertBtn:
                p.insert();
                break;
            case R.id.delBtn:
                p.del();
                break;
            case R.id.updateBtn:
                p.update();
                break;
            default:
                break;
        }
    }
}
