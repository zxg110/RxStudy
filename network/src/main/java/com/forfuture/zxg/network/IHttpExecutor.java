package com.forfuture.zxg.network;

public interface IHttpExecutor {

    void executePost(BaseProtocol protocol);

    void executeGet(BaseProtocol protocol);

    void executePut(BaseProtocol protocol);


}
