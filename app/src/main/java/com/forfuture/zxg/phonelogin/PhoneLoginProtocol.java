package com.forfuture.zxg.phonelogin;

import com.forfuture.zxg.network.BaseProtocol;
import com.forfuture.zxg.network.DisposableWrapper;
import com.forfuture.zxg.network.Rx.RxObserver;
import com.forfuture.zxg.network.exception.ApiException;
import io.reactivex.disposables.Disposable;

import java.util.Map;

public class PhoneLoginProtocol extends BaseProtocol {


    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected RxObserver getRxObserver() {
        return new RxObserver<PhoneLoginBean>() {
            @Override
            protected void onStart(DisposableWrapper disposable) {

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
        return null;
    }

    @Override
    protected Class getResponseClass(Class clazz) {
        return null;
    }
}
