package com.example.zengziqiang.daggerffff.di.component;

import com.example.zengziqiang.daggerffff.MainActivity;
import com.example.zengziqiang.daggerffff.di.module.MainModule;
import com.example.zengziqiang.daggerffff.utils.Tools;

import dagger.Component;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/26
 * @desc
 */

@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
