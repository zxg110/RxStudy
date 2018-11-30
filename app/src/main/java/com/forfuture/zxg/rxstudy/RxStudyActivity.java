package com.forfuture.zxg.rxstudy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxStudyActivity extends Activity {

    private Button btnSimpleRx;

    public static final String TAG = "RX_STUDY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxstudy);
        initView();
    }

    private void initView() {
        btnSimpleRx = findViewById(R.id.btn_simplerx);
        btnSimpleRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleRx();
            }
        });
    }

    private void simpleRx() {
        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "onSubscribe:" + d.toString());
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext:" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError:" + e.toString());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete");
            }
        };
        //主题
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("Hello");
                emitter.onNext("Hi");
                emitter.onNext("Aloht");
            }
        });
        //关注
        observable.subscribe(observer);
    }

    private void getImgWithRx() {
        Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(ObservableEmitter<Bitmap> emitter) {
                Bitmap bitmap = getImgFromNet("url");
                if (bitmap != null) {
                    emitter.onNext(bitmap);
                } else {
                    emitter.onError(new Exception("下载图片出错"));
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bitmap bitmap) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //耗时操作
    private Bitmap getImgFromNet(String url) {
        return null;

    }
}
