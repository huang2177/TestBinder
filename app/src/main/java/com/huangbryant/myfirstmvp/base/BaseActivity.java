package com.huangbryant.myfirstmvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author 黄双
 * @date 2018/1/15 0015
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {

    public BasePresenter<V> presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();

        presenter = createPresenter();
        presenter.attachView((V) this);
        presenter.fetch();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    /**
     * 用于实现类返回视图Id
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 用于实现类初始化控件
     */
    public abstract void initView();

    /**
     * 用于实现类创建presenter
     *
     * @return
     */
    public abstract BasePresenter<V> createPresenter();
}
