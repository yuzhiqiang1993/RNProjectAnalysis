package com.yzq.rn_project_analysis

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactHost
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.react.flipper.ReactNativeFlipper
import com.facebook.soloader.SoLoader


/**
 * @description: 入口，实现了ReactApplication接口
 * @author : yuzhiqiang
 */

class MainApplication : Application(), ReactApplication {

    /**
     * 创建ReactNativeHost，这里使用了默认的DefaultReactNativeHost
     */
    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {
            //获取已注册的ReactPackage列表
            override fun getPackages(): List<ReactPackage> =
                PackageList(this).packages.apply {
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    //用于添加不能自动链接的包，例如自定义的插件
                    // add(MyReactNativePackage())
                }

            //获取JS入口文件名，对应index.js
            override fun getJSMainModuleName(): String = "index"

            //是否开启开发者支持
            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            //是否开启新架构
            override val isNewArchEnabled: Boolean = BuildConfig.IS_NEW_ARCHITECTURE_ENABLED

            //是否开启Hermes引擎
            override val isHermesEnabled: Boolean = BuildConfig.IS_HERMES_ENABLED
        }


    /**
     * 获取ReactHost，这里使用了默认的DefaultReactHost
     *
     */
    override val reactHost: ReactHost
        get() = getDefaultReactHost(this.applicationContext, reactNativeHost)

    override fun onCreate() {
        super.onCreate()
        //初始化SoLoader，用于加载so库
        SoLoader.init(this, false)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            load()
        }
        //初始化Flipper，用于调试
        ReactNativeFlipper.initializeFlipper(this, reactNativeHost.reactInstanceManager)
    }
}
