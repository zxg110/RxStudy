package com.forfuture.zxg.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpInstaller {
    private  HttpClient client;
    private ClientFactory clientFactory;

    private static HttpInstaller instance;

    private HttpInstaller(){}

    public static HttpInstaller getInstance() {
        if(instance == null){
            instance = new HttpInstaller();
        }
        return instance;
    }

    public IHttpExecutor install(HttpRESTfulClient.Config httpConfig){
        if(clientFactory == null){
            initFactory();
        }
        client = clientFactory.createClient(httpConfig);
        return null;

    }

    private void initFactory(){
        clientFactory = new OkhttpClientFactory();
    }

}
