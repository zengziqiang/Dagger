package com.example.zengziqiang.daggerffff.di.module;

import com.example.zengziqiang.daggerffff.model.MainModel;
import com.example.zengziqiang.daggerffff.model.MainModelImpl;
import com.example.zengziqiang.daggerffff.presenter.MainPresenter;
import com.example.zengziqiang.daggerffff.presenter.MainPresenterImpl;
import com.example.zengziqiang.daggerffff.utils.Tools;
import com.example.zengziqiang.daggerffff.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/26
 * @desc 需要注入什么就提供什么
 */

@Module
public class MainModule {

    private MainView mainView;

    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    public MainView provideMainView() {
        return mainView;
    }

    @Provides
    public MainPresenter provideMainPresenter(MainView mainView, MainModel mainModel) {
        return new MainPresenterImpl(mainView, mainModel);
    }

    @Provides
    public MainModel provideMainModel() {
        return new MainModelImpl();
    }

    @Provides
    public Tools Tools() {
        return new Tools();
    }

}
