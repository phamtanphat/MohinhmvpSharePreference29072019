package com.example.mohinhmvp29072019;

public class MainPresenter implements ResponseLogin {

    private LoginModel loginModel;

    public MainPresenter(){
        loginModel = new LoginModel(this);
    }

    public void login(String taikhoan, String matkhau) {
        loginModel.validateLogin(taikhoan , matkhau);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError() {

    }
}
