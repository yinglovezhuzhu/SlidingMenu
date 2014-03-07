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

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

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
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initSlidingMenu();
		setContentView(R.layout.activity_main);
		
		mFragmentUtil.setContentBody(R.id.fl_main_body);
		
		
		
		initAboveView();
		
		initBehindView();
		
		mLvMenu.setItemChecked(0, true);
		
		gotoNewsPage("");
	}
	

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
//		if(intent.hasExtra(Config.EXTRA_FLAG)) {
//			intent.setClass(this, MainActivity.class);
//			startActivityLeft(intent);
//			finish();
//			return;
//		}
	}
	
	// [start]初始化函数
	private void initSlidingMenu() {
		setBehindContentView(R.layout.layout_menu);
		mSlidingMenu = getSlidingMenu();
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		mSlidingMenu.setShadowDrawable(R.drawable.shape_shadow_slidingmenu);
		mSlidingMenu.setBehindScrollScale(0);
		mSlidingMenu.setMode(SlidingMenu.LEFT);
	}
	
	private void initAboveView() {
		
		
	}
	
	private void initBehindView() {
		mLvMenu = (ListView) findViewById(R.id.lv_menu);
		mLvMenu.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
		mMenuAdapter = new MenuAdapter(this);
		mLvMenu.setAdapter(mMenuAdapter);
		mLvMenu.setOnItemClickListener(mMenuItemClick);
		//TODO Add menu data
		mMenuAdapter.addAll(null);
	}
	
	
	/** 菜单功能列表监听 **/
	private AdapterView.OnItemClickListener mMenuItemClick = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if(mMenuAdapter == null) {
				return;
			}
//			ConfigResp.ConfigData menu = mMenuAdapter.getItem(position);
//			String code = menu.getCode();
//			String name = menu.getName();
//			if(Config.TYPE_NEWS.equals(code)) {
//				gotoNewsPage(name);
//			} else if(Config.TYPE_COMPETITION.equals(code)) {
//				gotoCompetitionPage(name);
//			} else if(Config.TYPE_CLUB.equals(code)) {
//				gotoClubPage(name);
//			} else if(Config.TYPE_VIP.equals(code)) {
//				gotoVipPage(name);
//			} else if(Config.TYPE_TICKET.equals(code)) {
//				gotoTicketPage(name);
//			} else if(Config.TYPE_BUSINESS.equals(code)) {
//				gotoBusinessPage(name);
//			} else if(Config.TYPE_MARKET.equals(code)) {
//				gotoMarketPage(name);
//			} else if(Config.TYPE_BLOG.equals(code)) {
//				gotoBlogPage(name);
//			} else if(Config.TYPE_APP.equals(code)) {
//				gotoAppPage(name);
//			} 
			toggle();
		}
	};
	
	/**
	 * 新闻
	 */
	private void gotoNewsPage(String title) {
//		showNewsTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(NewsFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 赛事
	 */
	private void gotoCompetitionPage(String title) {
//		showCompetitionTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(CompetitionFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 俱乐部
	 */
	private void gotoClubPage(String title) {
//		showClubTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(ClubFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 会员专区
	 */
	private void gotoVipPage(String title) {
//		showVipTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(VipFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 手机订票
	 */
	private void gotoTicketPage(String title) {
//		showTicketTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(TicketFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	
	/**
	 * 商务合作
	 */
	private void gotoBusinessPage(String title) {
//		showBusinessTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(BusinessFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * 网上商城
	 */
	private void gotoMarketPage(String title) {
//		showMarketTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(MarketFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 球迷论坛
	 */
	private void gotoBlogPage(String title) {
//		showBlogTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(BlogFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 应用下载
	 */
	private void gotoAppPage(String title) {
//		showAppTitle(title);
//		try {
//			mFragmentUtil.changeToFragment(AppFragment.class);
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
	
	private void showNewsTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButton(R.drawable.ic_top_title_history, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}
	
	private void showCompetitionTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButton(R.drawable.ic_top_title_count, this, TAG_COMPETITION);
//		mTitleBar.setRightButtonVisible(true);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}
	
	private void showClubTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}
	
	private void showVipTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}

	private void showTicketTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}

	private void showBusinessTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}

	private void showMarketTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}
	
	private void showBlogTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
	}
	
	private void showAppTitle(String title) {
//		mTitleBar.setLeftButton(R.drawable.ic_top_title_menu, this);
//		mTitleBar.setRightButtonVisible(false);
//		mTitleBar.setMode(TitleBar.TitleMode.TITLE);
//		mTitleBar.setTitle(title);
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
	
	private void rightButtonAction(View v) {
		Integer tag = (Integer) v.getTag();
//		if(tag != null) {
//			switch (tag) {
//				case TAG_COMPETITION :
//					Intent intent = new Intent(this, CompetitionCountActivity.class);
//					startActivityLeft(intent);
//					break;
//
//				default :
//					break;
//			}
//		}
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
//		switch (v.getId()) {
//			case R.id.ibtn_top_title_left :
//				showMenu();
//				break;
//			case R.id.ibtn_top_title_right :
//				rightButtonAction(v);
//				break;
//			default :
//				break;
//		}
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
