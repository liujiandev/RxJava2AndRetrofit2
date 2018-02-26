package com.sky.fly.rr.http;

import com.sky.fly.rr.bean.BaseResultBean;
import com.sky.fly.rr.bean.UserInfoBean;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午2:42
 */

public interface HttpApi
{
    String BaseUrl = "http://192.168.9.137:8080/productManager/";

    /**
     * 登录接口
     * @param userName 用户名
     * @param userPassword 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login.do")
    Observable<BaseResultBean<UserInfoBean>> login(@Field("userName") String userName,
                                                   @Field("userPassword") String userPassword);

}
