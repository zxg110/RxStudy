package com.forfuture.zxg.network;

public class SaicHttpClient {
    private ApiService apiService;
    private String baseUrl = getBaseUrlFromConfig();

    private SaicHttpClient(){


    };



    public static SaicHttpClient instance;

    public static SaicHttpClient getInstance() {
        if (instance == null) {
            instance = new SaicHttpClient();
        }
        return instance;
    }

    private String getBaseUrlFromConfig(){
        return "";
    }
}
