package com.forfuture.zxg.network;

public class OkhttpClientFactory extends ClientFactory {
    @Override
    HttpClient createClient(HttpRESTfulClient.Config httpConfig) {
        return new OkhttpClientWrapper.Builder()
                .openCookie(httpConfig.isCookie)
                .openMock(httpConfig.isMock)
                .openLog(httpConfig.islog)
                .setCahce(httpConfig.isCache, httpConfig.maxAge, httpConfig.maxStale)
                .build();
    }
}
