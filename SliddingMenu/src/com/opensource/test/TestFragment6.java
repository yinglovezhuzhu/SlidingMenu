/*
 * Copyright (C) 2014年3月10日 上午10:16:24 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Auther：yinglovezhuzhu@gmail.com
 * FileName:ReadVideoResp.java
 * Date：2014年3月10日
 * Version：v1.0
 */	
package com.opensource.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opensource.R;
import com.opensource.slidingmenu.utils.LogUtils;

/**
 * Use：
 * 
 * @author yinglovezhuzhu@gmail.com
 */
public class TestFragment6 extends Fragment {
	
	private static final String TAG = TestFragment6.class.getSimpleName();
	
	private static final String ARGS_TITLE = "title";
	
	public static TestFragment6 newInstance(String title) {
		final TestFragment6 f = new TestFragment6();
		Bundle args = new Bundle();
		args.putString(ARGS_TITLE, title);
		f.setArguments(args);
		return f;
	}
	
	public TestFragment6() {}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogUtils.d(TAG, "onCreate()+++++>>");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LogUtils.d(TAG, "onCreateView()+++++>>");
		View contentView = inflater.inflate(R.layout.fragment_test, null);
		return contentView;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		LogUtils.d(TAG, "onViewCreated()+++++>>");
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onActivityCreated()+++++>>");
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onDestroyView()+++++>>");
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onDestroyView()+++++>>");
		super.onDestroy();
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onAttach()+++++>>");
		super.onAttach(activity);
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		LogUtils.d(TAG, "onDetach()+++++>>");
		super.onDetach();
	}
	
}
