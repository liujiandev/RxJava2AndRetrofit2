package com.sky.fly.rr.utils.loadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.fly.rr.R;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午3:31
 */

public class LoadViewHelper implements ILoadViewHelper
{
    private View currentView;
    private ViewGroup parentView;
    private int viewIndex;
    private ViewGroup.LayoutParams params;
    public LoadViewHelper(View containerView)
    {
        currentView = containerView;
    }

    private void init()
    {
        params = currentView.getLayoutParams();
        if (currentView.getParent() != null)
        {
            parentView = (ViewGroup) currentView.getParent();
        }
        else
        {
            parentView = (ViewGroup) currentView.getRootView().findViewById(android.R.id.content);
        }
        int count = parentView.getChildCount();
        for (int index = 0; index < count; index++)
        {
            if (currentView == parentView.getChildAt(index))
            {
                viewIndex = index;
                break;
            }
        }
        currentView.setBackgroundColor(getView().getResources().getColor(R.color.transparent));
    }

    @Override
    public void showView(View contentView)
    {
        if(parentView == null)
        {
            init();
        }
        // 如果已经是那个view，那就不需要再进行替换操作了
        if (parentView.getChildAt(viewIndex) != contentView)
        {
            ViewGroup parent = (ViewGroup) contentView.getParent();
            if (parent != null)
            {
                parent.removeView(contentView);
            }
            parentView.removeViewAt(viewIndex);
            parentView.addView(contentView, viewIndex, params);
        }
    }

    @Override
    public void showLayout(int layoutId)
    {
        showView(inflate(layoutId));
    }

    @Override
    public View inflate(int layoutId)
    {
        return LayoutInflater.from(currentView.getContext()).inflate(layoutId, null);
    }

    @Override
    public Context getContext()
    {
        return currentView.getContext();
    }

    @Override
    public View getView()
    {
        return currentView;
    }
}
