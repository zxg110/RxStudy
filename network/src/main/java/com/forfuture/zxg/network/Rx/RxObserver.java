package com.forfuture.zxg.network.Rx;

import com.forfuture.zxg.network.BaseResponse;
import com.forfuture.zxg.network.exception.ApiException;
import com.forfuture.zxg.network.exception.ExceptionHandler;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public abstract class RxObserver<T> implements Observer<BaseResponse<T>> {


    @Override
    public void onError(Throwable e) {
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
//            Log.e(this, apiException.getMessage());
////            if (handleLoginOut(apiException)) {
////                return;
////            }
            onError(apiException);
        } else {
            onError(new ApiException(e, ExceptionHandler.UN_KNOWN_ERROR));
        }
    }

    @Override
    public void onComplete() {
    }


    @Override
    public void onNext(BaseResponse<T> responseData) {
        try {
            if (responseData.getErrCode() != 0) {
                ApiException e = new ApiException(responseData.getErrCode(), responseData.getErrMsg());
                if (responseData.getData() != null) {
                    onError(e, responseData.getData());
                } else {
                    onError(e);
                }
                return;
            }
            onSuccess(responseData.getData());
        } catch (Exception e) {
            e.printStackTrace();
            ApiException apiException = new ApiException(e, ExceptionHandler.UN_KNOWN_ERROR);
            apiException.setMsg("");
            onError(apiException);
        }
    }


    //处理单点登录
//    private boolean handleLoginOut(ApiException apiException) {
//        if (apiException.getCode() == ResponseData.LOGIN_OUT_CODE || apiException.getCode() == ResponseData.NO_LOGIN_CODE) {
//            ToastUtil.info(apiException.getMsg());
//            EventBus.getDefault().post(new MsgEvent(MsgEventConfig.MSG_EVENT_EXTRUDE_LOGIN_SUCCESS));
//            return true;
//        }
//        return false;
//    }

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {
        onStart(disposable);
    }

    protected abstract void onStart(Disposable disposable);

    /**
     * 成功回调
     */
    protected abstract void onSuccess(T response);

    /**
     * 错误/异常回调
     */
    protected abstract void onError(ApiException e);

    protected void onError(ApiException e, T data) {

        onError(e);
    }
}