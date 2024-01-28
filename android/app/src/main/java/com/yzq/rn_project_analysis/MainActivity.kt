package com.yzq.rn_project_analysis

import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

/**
 * @description: 承载React Native的Activity，继承自ReactActivity
 * @author : yuzhiqiang
 */

class MainActivity : ReactActivity() {


    /**
     * 要加载的js组件名，对应index.js中的AppRegistry.registerComponent('RNProjectAnalysis', () => App);
     * @return String
     */
    override fun getMainComponentName(): String = "RNProjectAnalysis"

    /**
     * 返回ReactActivityDelegate实例，这里使用了DefaultReactActivityDelegate，内部实现了ReactActivityDelegate接口
     * @return ReactActivityDelegate
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate =
        DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
}
