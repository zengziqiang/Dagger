package com.example.zengziqiang.daggerffff.model;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/27
 * @desc
 */

public class MainModelImpl implements MainModel {
    @Override
    public String fetchPersionInfo(String username) {
        return "网络请求成功";
    }
}
