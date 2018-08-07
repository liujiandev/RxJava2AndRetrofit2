package com.sky.fly.rr.listener;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/26
 * Time: 上午9:46
 */

public interface ReqHttpCallBack<T>
{
    /**
     * 请求成功
     * @param result
     * @param reqTag
     */
    public void reqSuccess(T result,String reqTag);

    /**
     * 请求失败
     * @param code
     * @param msg
     * @param reqTag
     */
    public void reqOnError(String code,String msg,String reqTag);
}
