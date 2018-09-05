package com.forfuture.zxg.network;

import com.forfuture.zxg.network.cache.CacheInterceptor;
import com.forfuture.zxg.network.cookie.CookieManager;
import com.forfuture.zxg.network.log.LoggerInterceptor;
import com.forfuture.zxg.network.mock.MockRequestInterceptor;

import java.util.Map;

import okhttp3.OkHttpClient;

public class OkhttpClientWrapper extends HttpClient {
    OkHttpClient orignalClient = null;
    OkHttpClient.Builder orignalBuilder = null;


    private OkhttpClientWrapper(Builder builder){
        orignalBuilder = new OkHttpClient.Builder();
        //初始化cookie
        if(builder.hasCookie){
            orignalBuilder.cookieJar(new CookieManager());
        }
        //初始化mock
        if(builder.isMock){
            orignalBuilder.addInterceptor(new MockRequestInterceptor());
        }
        //初始化log
        if(builder.isLog){
            orignalBuilder.addInterceptor(new LoggerInterceptor());
        }
        //初始化cache
        if(builder.isCache){
            orignalBuilder.addInterceptor(new CacheInterceptor());
        }
        orignalClient = orignalBuilder.build();
    }

    @Override
    Object getOrignalClient() {
        return orignalClient;
    }

    public static final class Builder {

        public Builder(){

        }
        OkhttpClientWrapper client = null;

        boolean isMock = false;
        boolean isLog = false;
        boolean hasCookie = true;
        boolean isCache = true;
        int maxAge;
        int maxStale;
        Map<String,String> header = null;

        public Builder openMock(boolean isMock){
            this.isMock = isMock;
            return this;
        }

        public Builder openLog(boolean isLog){
            this.isLog = isLog;
            return this;
        }

        public Builder setCahce(boolean isCache,int maxAge,int maxStale){
            this.isCache = isCache;
            this.maxAge = maxAge;
            this.maxStale = maxStale;
            return this;
        }



        public Builder openCookie(boolean hasCookie){
            this.hasCookie = hasCookie;
            return this;
        }

        public OkhttpClientWrapper build(){
            return new OkhttpClientWrapper(this);
        }

    }



}
