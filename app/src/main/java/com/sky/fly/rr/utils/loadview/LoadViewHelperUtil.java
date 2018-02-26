package com.sky.fly.rr.utils.loadview;

import android.view.View;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午3:42
 */

public class LoadViewHelperUtil
{
    private LoadViewHelper loadViewHelper;
    public LoadViewHelperUtil(View containerView)
    {
        loadViewHelper = new LoadViewHelper(containerView);
    }

    public void showView(View contentView)
    {
        loadViewHelper.showView(contentView);
    }

    public void showView(int layoutId)
    {
        loadViewHelper.showLayout(layoutId);
    }
}
