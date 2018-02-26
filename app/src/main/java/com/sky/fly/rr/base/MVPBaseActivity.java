package com.sky.fly.rr.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sky.fly.rr.presenter.IBasePrensenter;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午4:59
 */

public abstract class MVPBaseActivity<p extends IBasePrensenter> extends BaseActivity
{
    protected p prensenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        prensenter = getPrensenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract p getPrensenter();
}
