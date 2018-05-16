package com.huangbryant.myfirstmvp.presenter;

import android.util.Log;

import com.huangbryant.myfirstmvp.base.BasePresenter;
import com.huangbryant.myfirstmvp.Movies;
import com.huangbryant.myfirstmvp.model.IProductModel;
import com.huangbryant.myfirstmvp.model.IProductModelImpl;
import com.huangbryant.myfirstmvp.ui.IProductView;

import java.util.List;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public class ProductPresenter extends BasePresenter {
    private IProductView productView;
    private IProductModel productModel;

    /**
     * 将view与model绑定
     */
    @Override
    public void fetch() {
        Log.e("----", "hsdiudchsd");
        productModel.loadProduct(new IProductModel.onCompleteListener() {
            @Override
            public void onComplete(List<Movies.NewsBean> list) {
                if (productView != null) {
                    productView.showProduct(list);
                }
            }
        });
    }

    @Override
    public void initIView() {
        productModel = new IProductModelImpl();
        productView = (IProductView) weakReference.get();
    }
}
