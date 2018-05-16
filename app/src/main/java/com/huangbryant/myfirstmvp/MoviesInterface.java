package com.huangbryant.myfirstmvp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author 黄双
 * @date 2018/1/16 0016
 */

public interface MoviesInterface {
    @GET("news")
    Call<Movies> getMovies(@QueryMap() Map<String, String> map);
}
