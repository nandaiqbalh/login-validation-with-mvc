package com.nandaiqbalh.loginvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nandaiqbalh.loginvalidation.controller.ILoginController;
import com.nandaiqbalh.loginvalidation.controller.LoginController;
import com.nandaiqbalh.loginvalidation.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edtEmail, edtPassword;
    Button btnLogin;

    ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        inisialisasi();

        // button triggered
        mainButton();

    }

    private void inisialisasi(){

        edtEmail = (EditText) findViewById(R.id.edt_email_login);
        edtPassword = (EditText) findViewById(R.id.edt_password_login);

        btnLogin = (Button) findViewById(R.id.btn_login);

        loginController = new LoginController(this);
    }

    private void mainButton(){

        // button login on click listerner
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginController.onLogin(edtEmail.getText().toString().trim(), edtPassword.getText().toString().trim());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}