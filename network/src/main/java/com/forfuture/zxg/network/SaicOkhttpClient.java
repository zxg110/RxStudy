package com.forfuture.zxg.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class SaicOkhttpClient {
    OkHttpClient orignalClient = null;


    private SaicOkhttpClient(OkHttpClient.Builder builder){
        orignalClient = builder.build();
    }

    public OkHttpClient getOrignalClient() {
        return orignalClient;
    }

    public static final class Builder {

        public Builder(){
            orignalBuilder = new OkHttpClient.Builder();
        }
        SaicOkhttpClient client = null;
        OkHttpClient.Builder orignalBuilder = null;
        boolean isMock = false;
        boolean isLog = false;
        boolean hasCookie = true;
        boolean isCache = true;
        int maxAge;
        int maxStale;

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
            if(hasCookie){
            }
            return this;
        }

        public SaicOkhttpClient build(){
            return new SaicOkhttpClient(orignalBuilder);
        }

    }



}
