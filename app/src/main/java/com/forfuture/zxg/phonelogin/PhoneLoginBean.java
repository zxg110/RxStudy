package com.forfuture.zxg.phonelogin;

import com.forfuture.zxg.network.BaseResponse;

public class PhoneLoginBean {

    private static final long serialVersionUID = -222561851671314535L;
    private String accessToken;
    private String uid;
    private boolean realNameCertificated;
    private boolean nameMobileBinded;
    private boolean registration;
    private String imToken = "";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isRealNameCertificated() {
        return realNameCertificated;
    }

    public void setRealNameCertificated(boolean realNameCertificated) {
        this.realNameCertificated = realNameCertificated;
    }

    public boolean isNameMobileBinded() {
        return nameMobileBinded;
    }

    public void setNameMobileBinded(boolean nameMobileBinded) {
        this.nameMobileBinded = nameMobileBinded;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }
}
