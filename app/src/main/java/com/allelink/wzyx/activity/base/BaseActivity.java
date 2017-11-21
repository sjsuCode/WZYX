package com.allelink.wzyx.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

/**
 * @author yangc
 * @filename BaseActivity.java
 * @date 2017/11/3
 * @version 1.0
 * @description 基类activity
 * @email 1048027353@qq.com
 */

public class BaseActivity extends AppCompatActivity {
    protected HashMap<String, Object> params = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
