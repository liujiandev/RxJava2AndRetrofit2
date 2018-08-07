package com.sky.fly.rr.presenter;


import com.sky.fly.rr.bean.BaseResultBean;
import com.sky.fly.rr.http.HttpApi;
import com.sky.fly.rr.http.RetrofitClient;
import com.sky.fly.rr.listener.ReqHttpCallBack;
import com.sky.fly.rr.utils.StringUtils;
import com.sky.fly.rr.utils.SystemUtils;
import com.sky.fly.rr.view.IBaseView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * Des:the description of current file
 * User: sky_fly_cloud
 * Date: 2018/2/25
 * Time: 下午5:10
 */

public abstract class BasePrensenter<V extends IBaseView,T> implements IBasePrensenter<V>
{
    protected Map<String,Disposable> disposableMap = new HashMap<>();
    protected V uiView;
    protected HttpApi httpApi = RetrofitClient.getRetrofit().create(HttpApi.class);
    @Override
    public void attachView(V view)
    {
        this.uiView = view;
    }

    @Override
    public void detachView()
    {
        this.uiView = null;
    }

    /**
     * 添加订阅
     * @param tag
     * @param observable
     * @param reqHttpCallBack
     */
    protected void addObservable(final String tag, Observable<BaseResultBean<T>> observable, final ReqHttpCallBack<T> reqHttpCallBack)
    {
        if(disposableMap == null)
        {
            disposableMap = new HashMap<>();
        }
        if(disposableMap.containsKey(tag))
        {
            disposableMap.get(tag).dispose();
            disposableMap.remove(tag);
        }
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseResultBean<T>>()
        {
            @Override
            public void onSubscribe(Disposable d)
            {
                disposableMap.put(tag,d);
            }

            @Override
            public void onNext(BaseResultBean<T> tBaseResultBean)
            {
                String resultCode = tBaseResultBean.getCode();
                if(!StringUtils.isEmpty(resultCode) && StringUtils.equals(resultCode,"1"))
                {
                    reqHttpCallBack.reqSuccess(tBaseResultBean.getResultBean(),tag);
                }
                else
                {
                    reqHttpCallBack.reqOnError(resultCode,tBaseResultBean.getMsg(),tag);
                }
            }

            @Override
            public void onError(Throwable e)
            {
                reqHttpCallBack.reqOnError("-100",e.getMessage(),tag);
                reqComplete(tag);
            }

            @Override
            public void onComplete()
            {
                reqComplete(tag);
            }
        });
    }

    /**
     * 请求完成，释放资源
     * @param tag
     */
    protected void reqComplete(String tag)
    {
        SystemUtils.println("释放资源:"+tag);
        uiView.dismissProgressView();
        if(disposableMap != null && disposableMap.containsKey(tag))
        {
            disposableMap.get(tag).dispose();
            disposableMap.remove(tag);
        }
    }
}
