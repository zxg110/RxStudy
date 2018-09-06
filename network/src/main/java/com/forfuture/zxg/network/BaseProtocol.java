package com.forfuture.zxg.network;

import com.forfuture.zxg.network.Rx.RxObserver;

import java.util.Map;

public abstract class BaseProtocol<T> {
    public static final String METHOD_POST = "post";
    public static final String METHOD_GET = "get";
    public static final String METHOD_PUT = "put";




    protected abstract String getUrl();

    protected abstract RxObserver<T> getRxObserver();

    protected abstract Map<String, String> getArgs();

    protected abstract String getMethod();

    protected abstract Class getResponseClass(final Class clazz);

    public void sendRequest() {
        HttpRESTfulClient.getInstance().sendProtocol(this);
    }


}
