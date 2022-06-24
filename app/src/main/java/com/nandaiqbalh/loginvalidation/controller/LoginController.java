package com.nandaiqbalh.loginvalidation.controller;

import com.nandaiqbalh.loginvalidation.model.User;
import com.nandaiqbalh.loginvalidation.view.ILoginView;

public class LoginController implements ILoginController{

    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);
        int loginCode = user.isValid();

        if (loginCode == 0){
            loginView.onLoginError("Please input the email!");
        } else if (loginCode ==1){
            loginView.onLoginError("Please input valid email address!");
        } else if (loginCode == 2){
            loginView.onLoginError("Please input the password!");
        } else if (loginCode == 3){
            loginView.onLoginError("Password must be more than six characters!");
        } else {
            loginView.onLoginSuccess("Login success!");
        }
    }

}
