package com.yihukurama.www.mvpbuilder.framework.v.interfaceView;

import android.content.Context;

/**
 * Created by dengshuai on 16/8/1.
 */
public interface IActivity {

    void initView();//对界面元素的初始化，findviewbyid
    void initData();//对界面数据的初始化
    Context getContext();
}
