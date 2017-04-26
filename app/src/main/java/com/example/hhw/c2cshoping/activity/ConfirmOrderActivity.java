package com.example.hhw.c2cshoping.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.ConfirmOrderAdapter;
import com.example.hhw.c2cshoping.view.MyToolbar;

import java.util.ArrayList;

public class ConfirmOrderActivity extends AppCompatActivity {
    private MyToolbar order_confirm_toolbar;
    private RecyclerView order_confirm_recyclerView;
    private View headView;
    private ConfirmOrderAdapter myAdapter;
    private ArrayList<Integer> list;
    private Button order_confirm_payButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        initView();
        initDate();
        initToolBar();
        initAdapter();
        initListener();
    }

    private void initListener() {
        order_confirm_payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmPayDialog();
            }
        });
    }

    private void showConfirmPayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrderActivity.this)
                .setTitle("支付确认").setMessage("总计xx元")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ConfirmOrderActivity.this,PayResultActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void initDate() {
        list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(10);
    }

    private void initAdapter() {
        myAdapter = new ConfirmOrderAdapter(R.layout.order_confirm_item,list);
        myAdapter.addHeaderView(headView);
        order_confirm_recyclerView.setAdapter(myAdapter);
    }

    private void initView() {
        order_confirm_toolbar = (MyToolbar) findViewById(R.id.order_confirm_toolbar);
        order_confirm_recyclerView = (RecyclerView) findViewById(R.id.order_confirm_recyclerView);
        order_confirm_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        headView = View.inflate(this,R.layout.order_confirm_head,null);
        order_confirm_payButton = (Button) findViewById(R.id.order_confirm_payButton);
    }

    private void initToolBar() {
        order_confirm_toolbar.setTextTitle("确认订单");
    }
}
