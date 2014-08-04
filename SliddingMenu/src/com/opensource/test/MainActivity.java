/*
 * 文件名：MainActivity.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-5-30
 * 修改人：xiaoying
 * 修改时间：2013-5-30
 * 版本：v1.0
 */
package com.opensource.test;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MotionEventCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.opensource.R;
import com.opensource.slidingmenu.SlidingMenu;
import com.opensource.slidingmenu.adapter.MenuAdapter;
import com.opensource.slidingmenu.base.BaseSlidingActivity;
import com.opensource.slidingmenu.utils.LogUtils;

/**
 * 功能：首页
 * @author xiaoying
 *
 */
public class MainActivity extends BaseSlidingActivity implements OnClickListener {
	
	private SlidingMenu mSlidingMenu = null;
	
	private MenuAdapter mMenuAdapter = null;
	
	/**** Above page end ****/
	
	/**** Behind page start ****/
	private ListView mLvMenu = null;
	/**** Behind page end ****/
	
	private TextView mTvTitle;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initSlidingMenu();
		setContentView(R.layout.activity_main);
		
		mFragmentUtil.setContentBody(R.id.fl_main_body);
		
		
		
		initAboveView();
		
		initBehindView();
		
		mLvMenu.setItemChecked(0, true);
		
		gotoPage(mMenuAdapter.getItem(0), TestFragment1.class);
	}
	

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
	}
	
	// [start]初始化函数
	private void initSlidingMenu() {
		setBehindContentView(R.layout.layout_menu);
//		mSlidingMenu = getSlidingMenu();
//		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
//		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//		mSlidingMenu.setShadowDrawable(R.drawable.shape_shadow_slidingmenu);
//		mSlidingMenu.setBehindScrollScale(0);
//		mSlidingMenu.setMode(SlidingMenu.LEFT);

		
		mSlidingMenu = getSlidingMenu();
		mSlidingMenu.setSecondaryMenu(R.layout.layout_menu);
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		mSlidingMenu.setShadowDrawable(R.drawable.shape_shadow_slidingmenu);
		mSlidingMenu.setBehindScrollScale(0.0f);
		mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
	}
	
	private void initAboveView() {
		findViewById(R.id.ibtn_title_left).setOnClickListener(this);
		mTvTitle = (TextView) findViewById(R.id.tv_title);
	}
	
	private void initBehindView() {
		mLvMenu = (ListView) findViewById(R.id.lv_menu);
		mLvMenu.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
		mMenuAdapter = new MenuAdapter(this);
		mLvMenu.setAdapter(mMenuAdapter);
		mLvMenu.setOnItemClickListener(mMenuItemClick);
		//TODO Add menu data
		List<String> menus = new ArrayList<String>();
		for(int i = 0; i < 8; i++) {
			menus.add("Menu " + i);
		}
		mMenuAdapter.addAll(menus);
	}
	
	
	/** 菜单功能列表监听 **/
	private AdapterView.OnItemClickListener mMenuItemClick = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if(mMenuAdapter == null) {
				return;
			}
			if(position > mMenuAdapter.getCount()) {
				return;
			}
			String title = mMenuAdapter.getItem(position);
			switch (position) {
			case 0:
				gotoPage(title, TestFragment1.class);
				break;
			case 1:
				gotoPage(title, TestFragment2.class);
				break;
			case 2:
				gotoPage(title, TestFragment3.class);
				break;
			case 3:
				gotoPage(title, TestFragment4.class);
				break;
			case 4:
				gotoPage(title, TestFragment5.class);
				break;
			case 5:
				gotoPage(title, TestFragment6.class);
				break;
			case 6:
				gotoPage(title, TestFragment7.class);
				break;
			case 7:
				gotoPage(title, TestFragment8.class);
				break;

			default:
				break;
			}
			toggle();
		}
	};
	
	private void gotoPage(String title, Class<? extends Fragment> cls) {
		mTvTitle.setText(title);
		try {
			mFragmentUtil.changeToFragment(cls);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_MENU :
				if(mSlidingMenu.isMenuShowing()) {
					toggle();
				} else {
					showMenu();
				}
				return true;
			case KeyEvent.KEYCODE_BACK:
				if(mSlidingMenu.isMenuShowing()) {
					onExit();
				} else {
					showMenu();
				}
				return true;
			default :
				return super.onKeyUp(keyCode, event);
		}
	}


	private void onExit() {
		showAlertDialog(0, R.string.exit, 
				R.string.exit_confirm_msg, R.string.ok, R.string.cancel, 
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				}, 
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				}, null);
	}
	
	public static int getHeight(Context context, int width, int height) {
		int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
		return screenWidth * height / width;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.ibtn_title_left :
				showMenu();
				break;
			default :
				break;
		}
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction() & MotionEventCompat.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN :
				LogUtils.w("MainActivity", "dispatchTouchEvent+++++++++++++ACTION_DOWN");
				break;
				
			default :
				break;
		}
		return super.dispatchTouchEvent(ev);
	}
	
}
