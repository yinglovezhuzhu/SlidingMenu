/*
 * Copyright (C) 14-6-9 下午4:16 Guangzhou Visions Tech Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.opensource.slidingmenu.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Use:
 * Created by yinglovezhuzhu@gmail.com on 2014-06-09.
 */
public class FragmentUtil{

    private FragmentManager mFragmentManager;

    private FragmentActivity mActivity;

    private int mBody;

    private FragmentUtil(FragmentActivity activity, int body) {
        this.mActivity = activity;
        this.mBody = body;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }


    /**
     * Create new FragmentUtil instance.
     * @param activity
     * @param body
     * @return
     */
    public static FragmentUtil newInstance(FragmentActivity activity, int body) {
        return new FragmentUtil(activity, body);
    }


    /**
     * Open a fragment
     * @param cls
     * @param args
     */
    public void openFragment(Class<? extends Fragment> cls, Bundle args) {
        Fragment fragment = mFragmentManager.findFragmentByTag(cls.getName());
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if(fragment == null) {
            fragment = Fragment.instantiate(mActivity, cls.getName(), args);
            ft.add(mBody, fragment, cls.getName());
        } else {
            if(!fragment.isDetached()) {
                ft.detach(fragment);
            }
            ft.attach(fragment);
        }
        ft.commit();
    }

}
