package com.sky.fly.rr.activity.user;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import com.sky.fly.rr.R;
import com.sky.fly.rr.base.MVPBaseActivity;
import com.sky.fly.rr.bean.UserInfoBean;
import com.sky.fly.rr.databinding.ActivityLoginBinding;
import com.sky.fly.rr.presenter.LoginPrensenter;
import com.sky.fly.rr.utils.StringUtils;
import com.sky.fly.rr.utils.ToastUtils;
import com.sky.fly.rr.view.ILoginView;

/**
 * login page
 */
public class LoginActivity extends MVPBaseActivity<LoginPrensenter> implements View.OnClickListener, ILoginView<UserInfoBean> {
    ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected LoginPrensenter getPrensenter()
    {
        return new LoginPrensenter(this);
    }


    @Override
    public void initView()
    {
        initActionView();
        headerView.backImg(R.mipmap.back_arrow_icon).midTextValue("登录").rightTextValue("注册");
        showActionView(headerView);
        loginBinding.loginResult.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public void initListener()
    {
        headerView.setRightViewClick(this);
        loginBinding.loginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ll_hv_right_view:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.loginBtn:
                login();
                break;
        }
    }

    /**
     * 登录
     */
    public void login()
    {
        String userName = loginBinding.userName.getText().toString();
        String userPassword = loginBinding.userPassword.getText().toString();
        if(StringUtils.isEmpty(userName))
        {
            ToastUtils.showPrompt(this,"用户名称不能为空");
            return;
        }
        if(StringUtils.isEmpty(userPassword))
        {
            ToastUtils.showPrompt(this,"用户密码不能为空");
            return;
        }
        prensenter.login(userName,userPassword);
    }

    @Override
    public void loginResult(UserInfoBean result)
    {
        if(result != null)
        {
            loginBinding.loginResult.setText(result.toString());
        }
    }
}
