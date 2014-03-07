
package com.opensource.slidingmenu.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.opensource.slidingmenu.SlidingActivityBase;
import com.opensource.slidingmenu.SlidingActivityHelper;
import com.opensource.slidingmenu.SlidingMenu;

public class BaseSlidingActivity extends BaseActivity implements SlidingActivityBase {

	private SlidingActivityHelper mHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper = new SlidingActivityHelper(this);
		mHelper.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mHelper.onPostCreate(savedInstanceState);
	}
	
	@Override
	public View findViewById(int id) {
		View v = super.findViewById(id);
		if (v != null)
			return v;
		return mHelper.findViewById(id);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mHelper.onSaveInstanceState(outState);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		setContentView(getLayoutInflater().inflate(layoutResID, null));
	}
	
	@Override
	public void setContentView(View view) {
		setContentView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}
	
	@Override
	public void setContentView(View view, LayoutParams params) {
		super.setContentView(view, params);
		mHelper.registerAboveContentView(view, params);
	}
	
	@Override
	public void setBehindContentView(View view, LayoutParams layoutParams) {
		mHelper.setBehindContentView(view, layoutParams);
	}

	@Override
	public void setBehindContentView(View view) {
		setBehindContentView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	@Override
	public void setBehindContentView(int layoutResID) {
		setBehindContentView(getLayoutInflater().inflate(layoutResID, null));
	}

	@Override
	public SlidingMenu getSlidingMenu() {
		return mHelper.getSlidingMenu();
	}

	@Override
	public void toggle() {
		mHelper.toggle();
	}

	@Override
	public void showContent() {
		mHelper.showContent();
	}

	@Override
	public void showMenu() {
		mHelper.showMenu();
	}

	@Override
	public void showSecondaryMenu() {
		mHelper.showSecondaryMenu();
	}

	@Override
	public void setSlidingActionBarEnabled(boolean slidingActionBarEnabled) {
		mHelper.setSlidingActionBarEnabled(slidingActionBarEnabled);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		boolean b = mHelper.onKeyUp(keyCode, event);
		if (b) return b;
		return super.onKeyUp(keyCode, event);
	}
}
