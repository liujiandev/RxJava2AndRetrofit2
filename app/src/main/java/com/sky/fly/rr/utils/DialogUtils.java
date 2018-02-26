package com.sky.fly.rr.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;

import com.sky.fly.rr.dialog.BaseProgressDialog;

import java.util.List;

/**
 * Created by sky on 2016/11/21.
 */

public class DialogUtils
{
    private static BaseProgressDialog progDialog = null;// 加载时进度条

    /**
     * 显示进度框
     */
    public static void showProgressDialog(Activity context, String title)
    {
        try
        {
            if(isRunning(context))
            {
                if (progDialog != null)
                {
                    progDialog.dismiss();
                    progDialog = null;
                }
                progDialog = new  BaseProgressDialog(context);
                progDialog.setLoadText(title);
                progDialog.setCanceledOnTouchOutside(false);
                progDialog.show();
            }
        }
        catch (Exception e)
        {

        }
    }

    /**
     * 显示进度框
     * @param context
     * @param title
     * @param listener
     */
    public static void showProgressDialog(Activity context, String title, DialogInterface.OnDismissListener listener)
    {
        try
        {
            if(isRunning(context))
            {
                if (progDialog == null)
                {
                    progDialog = new  BaseProgressDialog(context);
                }
                progDialog.setLoadText(title);
                progDialog.setCanceledOnTouchOutside(false);
                progDialog.setOnDismissListener(listener);
                progDialog.show();
            }
        }
        catch (Exception e)
        {

        }
    }

    /**
     * 隐藏进度框
     */
    public static void dissmissProgressDialog()
    {
        try
        {
            if (progDialog != null)
            {
                progDialog.dismiss();
            }
            progDialog = null;
        }
        catch (Exception e)
        {

        }
    }



    /**
     * 确认是否存在上下文context
     * @param ctx
     * @return
     */
    public static boolean isRunning(Activity ctx)
    {
        try
        {
            ActivityManager activityManager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(Integer.MAX_VALUE);

            for (ActivityManager.RunningTaskInfo task : tasks)
            {
                if (ctx.getPackageName().equalsIgnoreCase(task.baseActivity.getPackageName()))
                    return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
