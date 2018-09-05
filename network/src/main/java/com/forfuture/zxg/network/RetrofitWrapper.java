package com.forfuture.zxg.network;

public class RetrofitWrapper implements IHttpExecutor {

    private ApiService realRetrofit;
    private HttpClient client;


    private RetrofitWrapper(HttpClient client){
        this.client = client;
    }

    @Override
    public void executePost(BaseProtocol protocol){
        realRetrofit.executePost(protocol.getUrl(),
                protocol.getArgs()).subscribe(protocol.getRxObserver());
    }

    @Override
    public void executeGet(BaseProtocol protocol){
        realRetrofit.executeGet(protocol.getUrl(),protocol.getArgs());
    }

    @Override
    public void executePut(BaseProtocol protocol) {

    }




}
