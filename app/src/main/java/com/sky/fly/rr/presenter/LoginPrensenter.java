package com.sky.fly.rr.presenter;

import com.sky.fly.rr.bean.UserInfoBean;
import com.sky.fly.rr.listener.ReqHttpCallBack;
import com.sky.fly.rr.view.ILoginView;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:11
 */

public class LoginPrensenter extends BasePrensenter<ILoginView<UserInfoBean>,UserInfoBean>
{
    public LoginPrensenter(ILoginView<UserInfoBean> iLoginView)
    {
        attachView(iLoginView);
    }

    /**
     * 登录
     * @param userName
     * @param userPassword
     */
    public void login(String userName,String userPassword)
    {
        uiView.showProgressView("加载中...");
        addObservable("login", httpApi.login(userName, userPassword), new ReqHttpCallBack<UserInfoBean>() {
            @Override
            public void reqSuccess(UserInfoBean result, String reqTag) {
                uiView.loginResult(result);
            }

            @Override
            public void reqOnError(String code, String msg, String reqTag) {
                uiView.showPrompt(msg);
            }
        });
    }
}
