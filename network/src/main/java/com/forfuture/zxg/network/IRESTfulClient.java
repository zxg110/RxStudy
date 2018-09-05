package com.forfuture.zxg.network;

public interface IRESTfulClient {
    void postProtocol(BaseProtocol protocol);

    void getProtocol(BaseProtocol protocol);

    void putProtocol(BaseProtocol protocol);

    void sendProtocol(BaseProtocol protocol);

}
