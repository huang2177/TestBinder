package com.huangbryant.myfirstmvp.base;

import java.lang.ref.WeakReference;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public abstract class BasePresenter<T> {

    public WeakReference<T> weakReference;

    /**
     * 将view 与 model 绑定
     *
     * @param view
     */
    public void attachView(T view) {
        weakReference = new WeakReference<T>(view);
        initIView();
    }

    /**
     * 解绑
     */
    public void detachView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }


    /**
     * 请求数据
     */
    public abstract void fetch();

    /**
     * 获取view
     */
    public abstract void initIView();
}
