package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.util.Date;
import com.example.hhw.c2cshoping.view.MyToolbar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private MyToolbar register_toolbar;
    private CheckBox register_isRead;
    private Button register_button;
    private TextView register_user,register_password,register_rePassword,register_phone,register_linkRead;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initToolBar();
        initListener();
    }

    private void initToolBar() {
        register_toolbar.setTextTitle("注册新账号");
    }

    private void initListener() {
        register_linkRead.setOnClickListener(this);
        register_button.setOnClickListener(this);
    }

    private void initView() {
        register_toolbar = (MyToolbar) findViewById(R.id.register_toolbar);
        register_isRead = (CheckBox) findViewById(R.id.register_isRead);
        register_button = (Button) findViewById(R.id.register_button);
        register_password = (TextView) findViewById(R.id.register_password);
        register_rePassword = (TextView) findViewById(R.id.register_rePassword);
        register_phone = (TextView) findViewById(R.id.register_phone);
        register_linkRead = (TextView) findViewById(R.id.register_linkRead);
        register_linkRead.setText(Html.fromHtml("我已同意<a href='http://www.baidu.com'>《服务条款》</a>"));
        register_user = (TextView) findViewById(R.id.register_user);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_linkRead:
                Toast.makeText(RegisterActivity.this,"服务条款...",Toast.LENGTH_SHORT).show();break;
            case R.id.register_button:
                registerNewUser();break;
        }
    }

    private void registerNewUser() {
        String user , password , rePassword , phone;
        user = register_user.getText().toString().trim();
        password = register_password.getText().toString().trim();
        rePassword = register_rePassword.getText().toString().trim();
        phone = register_phone.getText().toString().trim();

        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword) || TextUtils.isEmpty(phone)){
            Toast.makeText(this,"输入完整信息",Toast.LENGTH_SHORT).show();
        }else if (!password.equals(rePassword)){
            Toast.makeText(this,"两次密码不相同",Toast.LENGTH_SHORT).show();
        }else if (! register_isRead.isChecked()){
            Toast.makeText(this,"请同意服务条款",Toast.LENGTH_SHORT).show();
        }else {
            //。。。。注册 。。。。
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            Date.setUser_id("ACFUN");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}