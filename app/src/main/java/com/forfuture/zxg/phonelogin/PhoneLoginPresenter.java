package com.forfuture.zxg.phonelogin;

public class PhoneLoginPresenter {

    private PhoneLoginProtocol protocol;

    public void login(){
        protocol = new PhoneLoginProtocol();
        protocol.sendRequest();
    }

}
