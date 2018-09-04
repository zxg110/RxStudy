package com.forfuture.zxg.network;

public class HttpClient {


    private ApiService apiService;
    private String baseUrl = getBaseUrlFromConfig();

    private HttpClient(){


    };



    public static HttpClient instance;

    public static HttpClient getInstance() {
        if (instance == null) {
            instance = new HttpClient();
        }
        return instance;
    }

    private String getBaseUrlFromConfig(){
        return "";
    }


}
