package com.forfuture.zxg.network.cookie;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class CookieManager implements CookieJar{
    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return null;
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        
    }
}
