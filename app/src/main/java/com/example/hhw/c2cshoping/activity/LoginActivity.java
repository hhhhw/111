package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.util.Date;
import com.example.hhw.c2cshoping.view.MyToolbar;

public class LoginActivity extends AppCompatActivity {
    private MyToolbar login_toolbar;
    private EditText login_userid,login_password;
    private Button login_button;
    private TextView login_register , login_wangjimm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initToolbar();
        setListener();
    }

    private void initToolbar() {
        login_toolbar.setTextTitle("登录");
    }

    private void setListener() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        login_wangjimm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //忘记密码
                Toast.makeText(LoginActivity.this,"未完待续···",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void userLogin() {
        String id = login_userid.getText().toString().trim();
        String password = login_password.getText().toString().trim();
        if(TextUtils.isEmpty(id)&&TextUtils.isEmpty(password)) {
            Toast.makeText(this,"输入账号密码",Toast.LENGTH_SHORT).show();
        }else {
            //服务器验证
            //返回账户信息
            //SharedPreferences写入Userid,余额，从服务器下载头像到本地。
            //挑转到MainActivity - MineFragment
            Date.setUser_id("ACFUN");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

    public void initView() {
        login_toolbar = (MyToolbar) findViewById(R.id.login_toolbar);
        login_userid = (EditText) findViewById(R.id.login_userid);
        login_password = (EditText) findViewById(R.id.login_password);
        login_button = (Button) findViewById(R.id.login_button);
        login_register = (TextView) findViewById(R.id.login_register);
        login_wangjimm = (TextView) findViewById(R.id.login_wangjimm);
    }
}
