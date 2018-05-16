package com.huangbryant.myfirstmvp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.huangbryant.myfirstmvp.base.BaseActivity;
import com.huangbryant.myfirstmvp.base.BasePresenter;
import com.huangbryant.myfirstmvp.card.OtherActivity;
import com.huangbryant.myfirstmvp.presenter.ProductPresenter;
import com.huangbryant.myfirstmvp.ui.IProductView;
import com.huangbryant.tree.IMyAidlInterface;

import java.util.List;


/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity implements IProductView, AdapterView.OnItemClickListener, ServiceConnection {

    private Adapter adapter;
    private ListView listView;
    private Intent intent;
    private IMyAidlInterface aidlInterface;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.lv);
        listView.setOnItemClickListener(this);

        intent = new Intent();
        intent.setAction("com.huang.service");
        intent.setPackage("com.huangbryant.tree");
    }

    @Override
    public BasePresenter createPresenter() {
        return new ProductPresenter();
    }

    /**
     * 显示数据
     *
     * @param list
     */
    @Override
    public void showProduct(List<Movies.NewsBean> list) {
        if (list != null) {
            adapter = new Adapter(list, this);
            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            if (position == 0) {
                bindService(intent, this, Context.BIND_AUTO_CREATE);
            } else if (position == 1) {
                Toast.makeText(this, aidlInterface.getName(), Toast.LENGTH_LONG).show();
            } else {
                aidlInterface.setName("Kobe");
            }
        } catch (RemoteException e) {

        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        aidlInterface = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
