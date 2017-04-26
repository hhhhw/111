package com.example.hhw.c2cshoping.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.OrderFragmentPagerAdapter;
import com.example.hhw.c2cshoping.view.MyToolbar;

public class OrderActivity extends AppCompatActivity {
    private TabLayout order_tabLayout;
    private ViewPager order_viewPager;
    private MyToolbar order_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        order_toolbar = (MyToolbar) findViewById(R.id.order_toolbar);
        order_tabLayout = (TabLayout) findViewById(R.id.order_tabLayout);
        order_viewPager = (ViewPager) findViewById(R.id.order_viewPager);
        order_viewPager.setAdapter(new OrderFragmentPagerAdapter(getSupportFragmentManager()));
        order_tabLayout.setupWithViewPager(order_viewPager);
        order_toolbar.setTextTitle("订单详情");
    }
}
