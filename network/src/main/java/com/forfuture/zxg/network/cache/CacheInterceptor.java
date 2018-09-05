package com.forfuture.zxg.network.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor{

    CacheConfig config = null;

    public void setConfig(CacheConfig config){
        this.config = config;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        cacheBuilder.maxAge(config == null ? CacheConfig.DEFAULT_MAX_AGE : config.maxAge, TimeUnit.SECONDS);
        cacheBuilder.maxStale(config == null ? CacheConfig.DEFAULT_MAX_STALE : config.maxStale, TimeUnit.DAYS);
        CacheControl cacheControl = cacheBuilder.build();
        request.newBuilder().cacheControl(cacheControl);
        request = request.newBuilder()
                .cacheControl(cacheControl)
                .build();
        return chain.proceed(request);
    }

    public class CacheConfig{
        public static final int DEFAULT_MAX_AGE = 0;
        public static final int DEFAULT_MAX_STALE = 365;
        int maxAge;
        int maxStale;
    }
}
