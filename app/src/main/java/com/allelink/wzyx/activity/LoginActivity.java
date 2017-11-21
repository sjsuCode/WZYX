package com.allelink.wzyx.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.widget.Button;

import com.allelink.wzyx.R;
import com.allelink.wzyx.activity.base.BaseActivity;
import com.allelink.wzyx.app.AccountManager;
import com.allelink.wzyx.app.sign.signin.ISignInListener;
import com.allelink.wzyx.app.sign.signin.SignInHandler;
import com.allelink.wzyx.utils.activity.ActivityUtils;
import com.allelink.wzyx.utils.log.LogUtil;
import com.allelink.wzyx.utils.regex.RegexUtils;
import com.allelink.wzyx.utils.toast.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author yangc
 * @filename LoginActivity.java
 * @date 2017/11/3
 * @version 1.0
 * @description 登陆页
 * @email 1048027353@qq.com
 */

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    /**
    * UI
    */
    @BindView(R.id.et_login_phone_number)
    TextInputEditText etPhoneNumber = null;
    @BindView(R.id.et_login_password)
    TextInputEditText etPassword = null;
    @BindView(R.id.btn_login_back)
    Button btnBack = null;
    @BindView(R.id.btn_login_login)
    Button btnLogin = null;
    @BindView(R.id.tv_login_register)
    AppCompatTextView tvRegister = null;
    @BindView(R.id.tv_login_forget_password)
    AppCompatTextView tvForgetPassword = null;
    /**
     * 手机号码
     */
    private String mPhoneNumber = null;
    /**
     * 密码
     */
    private String mPassword = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //绑定ButterKnife
        ButterKnife.bind(this);
    }
    /**
    * 导航栏返回按钮点击事件
    */
    @OnClick(R.id.btn_login_back)
    void back(){
        LogUtil.d(TAG,"back");
    }
    /**
     * 登陆按钮点击事件
     */
    @OnClick(R.id.btn_login_login)
    void login(){
        LogUtil.d(TAG,"login");
        mPhoneNumber = etPhoneNumber.getText().toString().trim();
        mPassword = etPassword.getText().toString().trim();
        if(!checkPhoneNumber(mPhoneNumber)){
            ToastUtil.toastShort(LoginActivity.this,getResources().getString(R.string.wrong_phone_number));
            return;
        }
        if (!checkPassword(mPassword)){
            ToastUtil.toastShort(LoginActivity.this,getResources().getString(R.string.wrong_password));
            return;
        }
        //在按钮上显示“登录中...”来提示用户
        btnLogin.setEnabled(false);
        btnLogin.setText(getResources().getString(R.string.on_logining));
        params.put("phone_number", mPhoneNumber);
        params.put("password", mPassword);
        SignInHandler.signIn(params, new ISignInListener() {
            @Override
            public void onSignInSuccess(String response) {
                LogUtil.d(TAG,response);
                //登录成功后设置登录状态，取消按钮提示
                btnLogin.setEnabled(true);
                btnLogin.setText(getResources().getString(R.string.login));
                AccountManager.setSignState(true);
                ToastUtil.toastShort(LoginActivity.this,response);
            }
            @Override
            public void onSignInFailure(String error) {
                LogUtil.d(TAG,error);
                //登录失败后取消按钮提示
                btnLogin.setEnabled(true);
                btnLogin.setText(getResources().getString(R.string.login));
                ToastUtil.toastShort(LoginActivity.this,error);
            }
        });
    }
    /**
     * 跳转到注册界面
     */
    @OnClick(R.id.tv_login_register)
    void skip2RegisterActivity(){
        LogUtil.d(TAG,"2register");
        ActivityUtils.startActivity(LoginActivity.this,RegisterActivity.class);
    }
    /**
     * 跳转到忘记密码界面
     */
    @OnClick(R.id.tv_login_forget_password)
    void skip2ForgetPasswordActivity(){
        LogUtil.d(TAG,"2forgetpassword");
    }
    /**
     * 检查手机是否合法
     * @return TODO
     */
    private boolean checkPhoneNumber(String phoneNumber) {
        if(TextUtils.isEmpty(phoneNumber) || !RegexUtils.isMobileExact(phoneNumber)){
            return false;
        }else {
            return true;
        }
    }
    /**
     * 检查密码是否合法
     * @return TODO
     */
    private boolean checkPassword(String password) {
        if(TextUtils.isEmpty(password) || !RegexUtils.isPassword(password)){
            return false;
        }
        return true;
    }
}
