/*
 * 文件名：MenuAdapter.java
 * 版权：<版权>
 * 描述：<描述>
 * 创建人：xiaoying
 * 创建时间：2013-5-31
 * 修改人：xiaoying
 * 修改时间：2013-5-31
 * 版本：v1.0
 */

package com.opensource.slidingmenu.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.opensource.R;

/**
 * 功能：菜单列表适配器
 * @author xiaoying
 *
 */
public class MenuAdapter extends BaseAdapter {
	
	private Context mContext = null;
	
	private List<String> mMenuDatas = new ArrayList<String>();
	
	public MenuAdapter(Context context) {
		this.mContext = context;
	}
	
	
	public void addAll(Collection<String> menus) {
		mMenuDatas.addAll(menus);
		notifyDataSetChanged();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return mMenuDatas.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public String getItem(int position) {
		return mMenuDatas.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RadioButton itemView = null;
		if(convertView == null) {
			convertView = View.inflate(mContext, R.layout.item_slidingmenu, null);
			itemView = (RadioButton) convertView;
			convertView.setTag(itemView);
		} else {
			itemView = (RadioButton) convertView.getTag();
		}
		itemView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_default, 0, 0, 0);
		itemView.setText(mMenuDatas.get(position));
		return convertView;
	}
	
//	private class MenuComparator implements Comparator<ConfigResp.ConfigData> {
//
//		@Override
//		public int compare(ConfigData lhs, ConfigData rhs) {
//			return rhs.getOrder() - rhs.getOrder();
//		}
//		
//	}
}
