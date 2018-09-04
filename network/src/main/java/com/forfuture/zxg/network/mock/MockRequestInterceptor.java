package com.forfuture.zxg.network.mock;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MockRequestInterceptor implements Interceptor {

    private String responeJsonPath;
    private String fileName = "";

    private Context mContext;

    public MockRequestInterceptor() {
    }

    public MockRequestInterceptor(String responeJsonPath) {
        this.responeJsonPath = responeJsonPath;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {

        HttpUrl uri = chain.request().url();
        if (!TextUtils.isEmpty(getFileName(uri))) {
            String responseString = createResponseBody(chain);

            Response response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
            return response;
        } else {
            return chain.proceed(chain.request());
        }


    }

    /**
     * 读文件获取json字符串，生成ResponseBody
     *
     * @param chain
     * @return
     */
    private String createResponseBody(Chain chain) {


        String responseString = null;
        HttpUrl uri = chain.request().url();
        fileName = getFileName(uri);
        if (TextUtils.isEmpty(fileName)) {
            responseString = "";
            Log.d("MockInterceptor", "no file matches");
        } else {
            responseString = getResponseStringFromAssets(fileName);
        }

        Log.d("MockInterceptor", "responseString = " + responseString);
        return responseString;
    }

    private String getResponseString(String fileName) {
        StringBuilder stringBuilder = FileUtil.readFile(responeJsonPath + fileName, "UTF-8");
        System.out.println(fileName);
        if (stringBuilder != null) {
            return stringBuilder.toString();
        }
        return "";
    }

    private String getResponseStringFromAssets(String fileName) {
        AssetManager assetManager = mContext.getResources().getAssets();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("json/" + fileName);
        } catch (IOException e) {
//            e.printStackTrace();
        }
        if (inputStream != null) {
            StringBuilder stringBuilder = FileUtil.readFile(inputStream, "UTF-8");
            System.out.println(fileName);
            if (stringBuilder != null) {
                return stringBuilder.toString();
            }
        }
        return "";
    }

    private String getFileName(HttpUrl uri) {
        String file = "";

        String path = uri.url().getPath();
        uri.url().getQuery();
        String host = uri.host();
        if (uri != null && uri.url() != null) {
            Log.d("MockInterceptor", uri.url().toString());
        }

        if (path != null) {
            String pathClear = path.substring(1);
            if (isInIgnoreList(pathClear)) {
                return "";
            }

            String temp = getSpecialApiFileName(pathClear);
            fileName = pathClear.replace("/", "_") + ".json";
            if (!TextUtils.isEmpty(temp)) {
                file = temp;
            } else if (isResponseFileExist(fileName)) {
                file = fileName;
            } else {
                file = MockResponse.responseMap.get(temp);
            }
        } else {
            file = "";
        }

        return file;
    }

    private String getSpecialApiFileName(String name) {
        ArrayList<String> tempList = MockResponse.getSpecialList();
        for (String item : tempList) {
            if (name.contains(item)) {
                return item.replace("/", "_") + ".json";
            }
        }
        return "";
    }

    private boolean isInIgnoreList(String name) {
        ArrayList<String> tempList = MockResponse.getIgnoreList();
        for (String item : tempList) {
            if (name.contains(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean isResponseFileExist(String fileName) {
        if (TextUtils.isEmpty(getResponseStringFromAssets(fileName))) {
            return false;
        }

        return true;
    }
}
