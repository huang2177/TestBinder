package com.huangbryant.myfirstmvp.ui;

import com.huangbryant.myfirstmvp.Movies;

import java.util.List;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public interface IProductView {
    /**
     * 显示商品
     * @param list
     */
    void showProduct(List<Movies.NewsBean> list);
}
