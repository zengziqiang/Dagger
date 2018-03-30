package com.example.zengziqiang.daggerffff;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zengziqiang.daggerffff.di.component.DaggerMainComponent;
import com.example.zengziqiang.daggerffff.di.module.MainModule;
import com.example.zengziqiang.daggerffff.presenter.MainPresenter;
import com.example.zengziqiang.daggerffff.utils.ErrorInterface;
import com.example.zengziqiang.daggerffff.utils.Tools;
import com.example.zengziqiang.daggerffff.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainView {

    private Button btn_login;

    @Inject
    MainPresenter presenter;

    @Inject
    Tools tools;
    private RelativeLayout rl_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(MainActivity.this);
        initView();

        showToast("消息提示:" + tools.ShowMsg());
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                LoadDatas();
                handler.sendEmptyMessageDelayed(0, 5000);
//                presenter.GetUserInfo();

                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    presenter.GetUserInfo();
                    break;
            }
        }
    };

    @Override
    public void LoadDatas() {
        Loading();
    }

    @Override
    public void NetWorkSuccess(String result) {
        CloseDialog();
        showToast(result);
        rl_root = findViewById(R.id.rl_root);
        showErrorMsg(MainActivity.this, rl_root, new ErrorInterface() {
            @Override
            public void toLoadAgain() {
                showToast("重新加载数据");
            }
        });
    }
}
