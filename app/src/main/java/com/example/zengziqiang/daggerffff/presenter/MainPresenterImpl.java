package com.example.zengziqiang.daggerffff.presenter;

import com.example.zengziqiang.daggerffff.model.MainModel;
import com.example.zengziqiang.daggerffff.view.MainView;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/26
 * @desc
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    public MainPresenterImpl(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void attachV(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void GetUserInfo() {
        // mainView.NetWorkSuccess("");
//        mainView.LoadDatas();
        String aaaa = mainModel.fetchPersionInfo("aaaa");
        mainView.NetWorkSuccess(aaaa);
    }
}
