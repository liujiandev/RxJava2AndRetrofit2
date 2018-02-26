package com.sky.fly.rr.utils.loadview;

import android.content.Context;
import android.view.View;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午3:32
 */

public interface ILoadViewHelper
{
    /**
     * 显示填充的view
     * @param contentView view
     */
    public abstract void showView(View contentView);

    /**
     * 显示填充的布局view
     * @param layoutId 布局资源ID
     */
    public abstract void showLayout(int layoutId);

    /**
     * 加载布局
     * @param layoutId 布局资源ID
     * @return
     */
    public abstract View inflate(int layoutId);

    /**
     * 获取上下文
     * @return
     */
    public abstract Context getContext();

    /**
     * 获取当前view
     * @return
     */
    public abstract View getView();
}
