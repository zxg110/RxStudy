package com.forfuture.zxg.phonelogin;

import com.forfuture.zxg.network.BaseProtocol;
import com.forfuture.zxg.network.Rx.RxObserver;
import com.forfuture.zxg.network.exception.ApiException;
import io.reactivex.disposables.Disposable;

import java.util.Map;

public class PhoneLoginProtocol<T> extends BaseProtocol {


    @Override
    protected String getUrl() {
        return "loginurl";
    }

    @Override
    protected RxObserver<PhoneLoginBean> getRxObserver() {
        return new RxObserver<PhoneLoginBean>() {


            @Override
            protected void onStart(Disposable disposable) {

            }

            @Override
            protected void onSuccess(PhoneLoginBean response) {

            }

            @Override
            protected void onError(ApiException e) {

            }
        };
    }

    @Override
    protected Map<String, String> getArgs() {
        return null;
    }

    @Override
    protected String getMethod() {
        return BaseProtocol.METHOD_POST;
    }

    @Override
    protected Class getResponseClass(Class clazz) {
        return PhoneLoginBean.class;
    }
}
