package com.example.hhw.c2cshoping.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.OrderDetailAdapter;
import com.example.hhw.c2cshoping.view.MyToolbar;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {
    private MyToolbar order_detail_toolbar;
    private RecyclerView order_detail_recyclerView;
    private OrderDetailAdapter myAdapter;
    private ArrayList<String> list;
    private View headView, footerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initView();
        initDate();
        initToolbar();
        initAdapter();
    }

    private void initDate() {
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }

    private void initAdapter() {
        myAdapter = new OrderDetailAdapter(R.layout.order_detail_item,list);
        headView = View.inflate(this,R.layout.order_detail_head,null);
        footerView = View.inflate(this,R.layout.order_detail_footer,null);
        myAdapter.setHeaderView(headView);
        myAdapter.setFooterView(footerView);
        order_detail_recyclerView.setAdapter(myAdapter);
    }

    private void initToolbar() {
        order_detail_toolbar.setTextTitle("订单详情");
    }

    private void initView() {
        order_detail_toolbar = (MyToolbar) findViewById(R.id.order_detail_toolbar);
        order_detail_recyclerView = (RecyclerView) findViewById(R.id.order_detail_recyclerView);
        order_detail_recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
