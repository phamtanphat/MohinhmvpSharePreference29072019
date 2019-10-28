package com.example.mohinhmvp29072019;

import android.util.Log;

public class MainPresenter implements ResponseLogin {

    private LoginModel loginModel;
    private OnListenLogin onListenLogin;

    public MainPresenter(OnListenLogin onListenLogin){
        loginModel = new LoginModel(this);
        this.onListenLogin = onListenLogin;

    }

    public void login(String taikhoan, String matkhau) {
        loginModel.validateLogin(taikhoan , matkhau);
    }

    @Override
    public void onSuccess() {
        onListenLogin.loginSuccess();
    }

    @Override
    public void onError() {
       onListenLogin.loginFail();
    }
}
