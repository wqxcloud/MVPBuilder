/*
    ShengDao Android Client, DBManager
    Copyright (c) 2014 ShengDao Tech Company Limited
 */

package com.yihukurama.www.mvpbuilder.opensource.api;

import android.content.Context;

import com.yihukurama.www.mvpbuilder.opensource.greendao.DaoMaster;
import com.yihukurama.www.mvpbuilder.opensource.greendao.DaoSession;


/**
 * [数据库管理类，数据采用GreenDao来实现，所有实现通过模板自动生成；通过获取daoSession来获取所有的dao，从而实现操作对象]
 * 
 * @author yihukurama
 * @version 1.0
 * @date 2014-11-6
 * 
 **/
public class DaoApi {
	private static String DB_NAME = "tempDB";
	private static DaoApi instance;
	private DaoMaster daoMaster;
	private DaoSession daoSession;

	public static DaoApi getInstance(Context context) {
		if (instance == null) {
			synchronized (DaoApi.class) {
				if (instance == null) {
					instance = new DaoApi(context);
				}
			}
		}
		return instance;
	}
	/**
	 * 构造方法
	 * @param context
	 */
	private DaoApi(Context context) {
		if(daoSession == null){
			if(daoMaster == null){
				DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
				daoMaster = new DaoMaster(helper.getWritableDatabase());
			}
			daoSession = daoMaster.newSession();  
		}
	}

	public DaoMaster getDaoMaster() {
		return daoMaster;
	}

	public void setDaoMaster(DaoMaster daoMaster) {
		this.daoMaster = daoMaster;
	}

	public DaoSession getDaoSession() {
		return daoSession;
	}

	public void setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
	}

	public void reset(){
		instance = null;
		daoMaster = null;
		daoSession = null;

	}
}
