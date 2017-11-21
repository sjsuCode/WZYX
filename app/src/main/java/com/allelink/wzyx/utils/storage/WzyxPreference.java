package com.allelink.wzyx.utils.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.allelink.wzyx.app.WzyxApplication;

/**
 * @author yangc
 * @version 1.0
 * @filename WzyxPreference
 * @date 2017/11/10
 * @description 本地数据存储
 * @email 1048027353@qq.com
 */

public class WzyxPreference {

    /**
    * 获取全局SharedPreferences
    */
    private static final SharedPreferences PREFERENCES =
            PreferenceManager.getDefaultSharedPreferences(WzyxApplication.getContext());
    private static final String APP_PREFERENCE_KEY = "profile";
    private static SharedPreferences getAppPreference(){
        return PREFERENCES;
    }

    /**
    * 设置登录状态
    */
    public static void setAppFlag(String key,boolean flag){
        getAppPreference()
                .edit()
                .putBoolean(key,flag)
                .apply();
    }

    /**
     * 获得登录状态
     */
    public static boolean getAppFlag(String key){
        return getAppPreference().getBoolean(key,false);
    }

}
