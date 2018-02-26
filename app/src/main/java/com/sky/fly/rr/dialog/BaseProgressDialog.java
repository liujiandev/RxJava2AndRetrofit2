package com.sky.fly.rr.dialog;


import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.sky.fly.rr.R;


/**
 * 自定义加载进度框
 *
 */
public class BaseProgressDialog extends Dialog
{
	private TextView mLoadText;

	public BaseProgressDialog(Context context)
	{
		 super(context, R.style.MyBaseDialog);
	     initView();
	}
	
	public BaseProgressDialog(Context context, int theme)
	{
		super(context, theme);
		initView();
	}

	/**
	 * 初始化组件
	 */
	private void initView() 
	{
		setContentView(R.layout.base_progress_dialog_view);
		mLoadText = (TextView) findViewById(R.id.loadText);
	}

	public void setLoadText(String loadText)
	{
		mLoadText.setText(loadText);
	}
}
