package com.yihukurama.www.mvpbuilder.framework.p;

import com.yihukurama.www.mvpbuilder.framework.m.dao.bean.User;
import com.yihukurama.www.mvpbuilder.framework.p.interfacePresenter.IDB;
import com.yihukurama.www.mvpbuilder.framework.v.interfaceView.IDBExampleActivity;
import com.yihukurama.www.mvpbuilder.opensource.api.DaoApi;
import com.yihukurama.www.mvpbuilder.opensource.greendao.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * Created by dengshuai on 16/7/25.
 */
public class DBP implements IDB{
    User user;
    IDBExampleActivity v;
    DaoApi daoApi;

    public DBP(IDBExampleActivity v){
        this.v = v;
        daoApi = DaoApi.getInstance(v.getContext());
    }
    @Override
    public void insert() {
        //例子，直接new一个User实例插入
        User user1 = new User();
        user1.setName("方法里定义的user");
        user1.setOid("1");
        user1.setSex("男");
        daoApi.getDaoSession().getUserDao().insert(user1);
        //再插入一个成员变量
        user = new User();
        user.setName("Persenter定义的user");
        user.setOid("2");
        user.setSex("男");
        daoApi.getDaoSession().getUserDao().insert(user);
        v.showDBResult();
    }

    @Override
    public void del() {
        daoApi.getDaoSession().getUserDao().deleteAll();
        v.showDBResult();
    }

    @Override
    public void update() {
        user.setName("Persenter定义的user更新名字了");
        daoApi.getDaoSession().getUserDao().update(user);
        v.showDBResult();
    }

    @Override
    public List query() {
        Query query = daoApi.getDaoSession().getUserDao().queryBuilder().where(
                UserDao.Properties.Sex.eq("男"))
                .build();
        List<User> users = query.list();
        return users;
    }
}
