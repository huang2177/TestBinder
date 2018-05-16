package com.huangbryant.myfirstmvp.model;

import com.huangbryant.myfirstmvp.Movies;

import java.util.List;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public interface IProductModel {
    /**
     * 加载商品
     */
    void loadProduct(onCompleteListener onCompleteListener);

    interface onCompleteListener {
        /**
         * 加载完成的监听
         *
         * @param list
         */
        void onComplete(List<Movies.NewsBean> list);
    }
}
