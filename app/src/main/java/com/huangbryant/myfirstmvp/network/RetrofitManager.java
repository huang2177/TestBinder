package com.huangbryant.myfirstmvp.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitManager
 *
 * @author 黄双
 * @date 2018/1/16 0016
 */

public class RetrofitManager {

    private Retrofit mRetrofit;

    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_TIME_OUT = 10;

    private RetrofitManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                //设置链接超时
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES)
                //设置读操作超时
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.MINUTES)
                //添加公共参数拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                //添加请求头
                                .addHeader("X-UA"
                                        , "android|5.5|41497|1f7a7ff3eef725502c3b982a3aca979f|ffffffff-d0d2-e3e3-c2c2-f3320033c587|85|samsung|6.0.1|3.10.84-11394230|||samsung|SM-A9100")
                                .build();
                        return chain.proceed(newRequest);
                    }
                });
        mRetrofit = new Retrofit.Builder()
                .baseUrl(API.BASEURL)
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

    /**
     * 获取 RetrofitManager 实例
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 静态内部类 防止内存泄漏
     */
    private static class SingletonHolder {
        /**
         * 初始化 RetrofitManager 实例
         */
        private static final RetrofitManager INSTANCE = new RetrofitManager();
    }
}
