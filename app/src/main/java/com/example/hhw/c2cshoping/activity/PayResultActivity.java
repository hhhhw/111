package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.view.MyToolbar;

public class PayResultActivity extends AppCompatActivity {
    private MyToolbar payResult_toolbar;
    private Button payResult_order,payResult_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_result);
        initView();
        initToolbar();
        initListener();
    }

    private void initListener() {
        payResult_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayResultActivity.this,OrderDetailActivity.class);
                startActivity(intent);
            }
        });
        payResult_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayResultActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initToolbar() {
        payResult_toolbar.setTextTitle("支付结果");
    }

    private void initView() {
        payResult_toolbar = (MyToolbar) findViewById(R.id.payResult_toolbar);
        payResult_order = (Button) findViewById(R.id.payResult_order);
        payResult_home = (Button) findViewById(R.id.payResult_home);
    }
}
