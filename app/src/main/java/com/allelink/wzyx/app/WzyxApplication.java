package com.allelink.wzyx.app;

import android.app.Application;
import android.content.Context;

import com.allelink.wzyx.utils.log.LogUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author yangc
 * @version 1.0
 * @filename WzyxApplication
 * @date 2017/11/3
 * @description Application类，用于初始化
 * @email 1048027353@qq.com
 */

public class WzyxApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        //控制日志输出
        LogUtil.LEVEL = LogUtil.VERBOSE;
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }

}
