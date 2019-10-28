package com.example.mohinhmvp29072019;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnListenLogin,OnListenSaveCache{

    Button mBtnDangNhap;
    EditText mEdtTaiKhoan, mEdtMatKhau;
    CheckBox mCbLuu;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        eventClick();
    }

    private void init() {
        mBtnDangNhap = findViewById(R.id.buttonDangNhap);
        mEdtTaiKhoan = findViewById(R.id.edittextTaiKhoan);
        mEdtMatKhau = findViewById(R.id.edittextMatkhau);
        mCbLuu = findViewById(R.id.checkboxLuuMatKhau);
        mainPresenter = new MainPresenter(this,this);
    }

    private void eventClick() {
        mBtnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = mEdtTaiKhoan.getText().toString().trim();
                String matkhau = mEdtMatKhau.getText().toString().trim();
                mainPresenter.login(taikhoan, matkhau);
            }
        });
    }

    @Override
    public void loginSuccess() {
        if (mCbLuu.isChecked()){
            mainPresenter.saveLogin(mEdtTaiKhoan.getText().toString().trim(),mEdtMatKhau.getText().toString().trim(),true,this);
        }
    }

    @Override
    public void loginFail() {

    }

    @Override
    public void saveSuccessFull() {
        Toast.makeText(this, "Thanh cong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveFailture(String error) {
        Toast.makeText(this, error , Toast.LENGTH_SHORT).show();
    }
}
