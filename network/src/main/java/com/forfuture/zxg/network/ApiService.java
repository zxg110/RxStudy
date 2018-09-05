package com.forfuture.zxg.network;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("{url}")
    Observable<BaseResponse<Object>> executeGet(
            @Path("url") String url,
            @QueryMap Map<String, String> maps);


    @POST("{url}")
    Observable<BaseResponse<Object>> executePost(
            @Path("url") String url,
            @QueryMap Map<String, String> maps);

    @POST("{url}")
    Observable<ResponseBody> json(
            @Path("url") String url,
            @Body RequestBody jsonStr);

}
