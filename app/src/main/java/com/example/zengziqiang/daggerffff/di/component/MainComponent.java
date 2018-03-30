package com.example.zengziqiang.daggerffff.di.component;

import com.example.zengziqiang.daggerffff.MainActivity;
import com.example.zengziqiang.daggerffff.di.module.MainModule;

import dagger.Component;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/26
 * @desc 将module管理起来
 */

@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
