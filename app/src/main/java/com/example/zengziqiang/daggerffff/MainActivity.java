package com.example.zengziqiang.daggerffff;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zengziqiang.daggerffff.di.component.DaggerMainComponent;
import com.example.zengziqiang.daggerffff.di.module.MainModule;
import com.example.zengziqiang.daggerffff.presenter.MainPresenter;
import com.example.zengziqiang.daggerffff.utils.Tools;
import com.example.zengziqiang.daggerffff.view.MainView;

import javax.inject.Inject;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date 2018/3/30
 * @desc MVP基于dagger最基础的实现方式
 */
public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {

    private Button btn_login;

    @Inject
    MainPresenter presenter;

    @Inject
    Tools tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注入依赖
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(MainActivity.this);
        showToast("消息提示:" + tools.ShowMsg());

        initView();
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.GetUserInfo();
                break;
        }
    }

    /**
     * 网络请求等待操作
     */
    @Override
    public void LoadDatas() {

    }

    /**
     * 网络请求成功的操作
     *
     * @param result
     */
    @Override
    public void NetWorkSuccess(String result) {
        showToast(result);
    }
}
