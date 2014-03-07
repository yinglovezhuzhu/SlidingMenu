/*
 * 文件名：FragmentManagerUtil.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-6-28
 * 修改人：xiaoying
 * 修改时间：2013-6-28
 * 版本：v1.0
 */

package com.opensource.slidingmenu.utils;

import java.util.HashSet;
import java.util.Set;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * 功能：Fragment管理和跳转的工具类
 * 注意：这个类的缺点就是，同一个FragmentManger内部不能有相同类实体，例如：AFragment的对象，只能有一个。
 * @author xiaoying
 *
 */
public class FragmentManagerUtils {

	private final Set<String> mFragmentTags = new HashSet<String>();
	
	private FragmentManager mFm = null;
	
	private int mBody = 0;
	
	public FragmentManagerUtils(FragmentManager fm) {
		this.mFm = fm;
		init();
	}
	
	/**
	 * 获取一个实例（不是单实例，每个实例对应一个FragmentManager）
	 * @return
	 */
	public static FragmentManagerUtils getInstance(FragmentManager fm) {
		return new FragmentManagerUtils(fm);
	}
	
	/**
	 * 跳至相应的Fragment,调用这个方法前必须先调用setContentBody(int id)设置容器
	 * @param cls 所要跳至的Fragment的Class
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void changeToFragment(Class <? extends Fragment> cls) throws InstantiationException, IllegalAccessException {
		if(mBody == 0) {
			throw new IllegalStateException("You must use method setContentBody(int id) first");
		}
		clearOthers(cls);
		Fragment fragment = mFm.findFragmentByTag(cls.getName());
		FragmentTransaction ft = mFm.beginTransaction();
		if(fragment == null) {
			fragment = cls.newInstance();
//			ft.add(mBody, fragment, cls.getName());
			ft.replace(mBody, fragment, cls.getName());
		} else {
			ft.attach(fragment);
		}
		ft.commit();
		mFragmentTags.add(cls.getName());
	}
	
	/**
	 * 设置Fragment的容器id
	 * @param id
	 */
	public void setContentBody(int id) {
		mBody = id;
	}

	/**
	 * 清除其他的Fragment，让他们处于detach状态
	 * @param cls 将要跳转的Fragment
	 */
	private void clearOthers(Class <? extends Fragment> cls) {
		FragmentTransaction ft = mFm.beginTransaction();
		for (String tag : mFragmentTags) {
			if(tag.equals(cls.getName())) {
				continue;
			}
			Fragment fragment = mFm.findFragmentByTag(tag);
			if(fragment != null && !fragment.isDetached()) {
				ft.detach(fragment);
			}
		}
		ft.commit();
	}
	
	/**
	 * 初始化
	 * @param fm
	 */
	private void init() {
		FragmentTransaction ft = mFm.beginTransaction();
		for (String tag : mFragmentTags) {
			Fragment fragment = mFm.findFragmentByTag(tag);
			if(fragment != null && !fragment.isDetached()) {
				ft.detach(fragment);
			}
		}
		ft.commit();
	}
}
