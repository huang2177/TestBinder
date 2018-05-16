package com.huangbryant.myfirstmvp.model;


import android.util.Log;

import com.huangbryant.myfirstmvp.Movies;
import com.huangbryant.myfirstmvp.MoviesInterface;
import com.huangbryant.myfirstmvp.network.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IProduct 的实现类 处理网络请求
 *
 * @author 黄双
 * @date 2018/1/15 0015
 */

public class IProductModelImpl implements IProductModel {

    @Override
    public void loadProduct(final onCompleteListener onCompleteListener) {
        if (onCompleteListener != null) {

            MoviesInterface user = RetrofitManager.getInstance().create(MoviesInterface.class);

            Map<String, String> map = new HashMap<>(8);
            map.put("category", "0");
            map.put("keywords", "");
            map.put("page", "1");
            map.put("size", "30");

            Call<Movies> call = user.getMovies(map);

            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    Log.e("======", response.code() + "===");
                    if (response.isSuccessful()) {
                        onCompleteListener.onComplete(response.body().getNews());
                    }
                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {
                    Log.e("======", t.getMessage()+"===");
                }
            });
        }
    }
}
