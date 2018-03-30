# Dagger2
dagger2 about dependency inject

---


# 添加依赖相关

## 在project的build.gradle中添加
```
dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        // 添加android-apt 插件
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
```


## 在app的build.gradle中添加相关依赖

```
  // dagger 2 的配置
    compile 'com.google.dagger:dagger:2.6.1'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.6.1'
    compile 'org.glassfish:javax.annotation:10.0-b28'
```


    
#    使用思路
   与MVP模式为例：
   我们的view需要presenter，那么我们将presenter注入到view中去，办法就是将presenter转换成一个module，通过component进行依赖，这样就可以注入到view中。但情况并没有这么简单，还有scope,等等相关的注解，这里只列举了一个简单示例，仅供参考！
    
