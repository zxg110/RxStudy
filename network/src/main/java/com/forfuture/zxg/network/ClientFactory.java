package com.forfuture.zxg.network;

public abstract class ClientFactory {
    abstract HttpClient createClient(HttpRESTfulClient.Config config);
}
