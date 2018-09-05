package com.forfuture.zxg.network;

public class HttpRESTfulClient implements IRESTfulClient {

    private IHttpExecutor executor;

    private Config config = null;

    private HttpRESTfulClient() {
        initClient();
    }

    private void initClient() {
        if (executor == null) {
            executor = HttpInstaller.getInstance().install(config == null ?Config.DEFAULT_CONFIG:config);
        }
    }


    public static HttpRESTfulClient instance;

    public static HttpRESTfulClient getInstance() {
        if (instance == null) {
            instance = new HttpRESTfulClient();
        }
        return instance;
    }


    public void postProtocol(BaseProtocol protocol) {
        executor.executePost(protocol);

    }

    @Override
    public void getProtocol(BaseProtocol protocol) {
        executor.executeGet(protocol);
    }

    @Override
    public void putProtocol(BaseProtocol protocol) {
        executor.executePut(protocol);
    }

    @Override
    public void sendProtocol(BaseProtocol protocol) {
        if(protocol.getMethod() == BaseProtocol.METHOD_GET){
            executor.executeGet(protocol);
        }
    }



    //配置
    public static final class Config {
        boolean isMock = true;
        boolean islog = true;
        boolean isCookie = true;
        boolean isCache = true;
        int maxAge = 0;
        int maxStale = 10;
        String baseUrl = "";
        public static final Config DEFAULT_CONFIG = new Config();


    }


}
