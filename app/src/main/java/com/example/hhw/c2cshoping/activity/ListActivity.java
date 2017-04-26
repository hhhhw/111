package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.SellAdapter;
import com.example.hhw.c2cshoping.bean.GoodsBean;
import com.example.hhw.c2cshoping.view.MyToolbar;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    private static final int PAGE_SIZE = 10;            //初始显示数目
    private SwipeRefreshLayout list_activity_swipe;
    private MyToolbar list_activity_toolbar;
    private RecyclerView list_activity_recycle;
    private ArrayList<GoodsBean> list ;
    private boolean isFirst = true;
    private SellAdapter sellAdapter,sellAdapter2;
    private int type ;                          //type 1-商品，2-店铺
    private String entry = "商品列表";                       //entry 搜索内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        type = intent.getIntExtra("type",1);
        entry = intent.getStringExtra("entry");
        initView();
        initDate();
        initToolbar();
        initAdapter();
        initListener();
    }

    private void initListener() {
    }

    private void initAdapter() {
        sellAdapter = new SellAdapter(R.layout.first_list_item,list);
        sellAdapter.setOnLoadMoreListener(this,list_activity_recycle);
        sellAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ListActivity.this,CommodityDetailActivity.class);
                intent.putExtra("commodityId","" + position);
                startActivity(intent);
            }
        });

        sellAdapter2 = new SellAdapter(R.layout.second_list_item,list);
        sellAdapter2.setOnLoadMoreListener(this,list_activity_recycle);
        sellAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ListActivity.this,CommodityDetailActivity.class);
                intent.putExtra("commodityId","" + position);
                startActivity(intent);
            }
        });
        list_activity_recycle.setAdapter(sellAdapter);
    }

    private void initView() {
        list_activity_swipe = (SwipeRefreshLayout) findViewById(R.id.list_activity_swipe);
        list_activity_swipe.setOnRefreshListener(this);
        list_activity_swipe.setColorSchemeColors(Color.rgb(47, 223, 189));

        list_activity_toolbar = (MyToolbar) findViewById(R.id.list_activity_toolbar);
        list_activity_recycle = (RecyclerView) findViewById(R.id.list_activity_recycle);
        list_activity_recycle.setLayoutManager(new GridLayoutManager(ListActivity.this,2));
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++){
                GoodsBean gb = new GoodsBean();
                gb.setAddress("address"+i);
                gb.setGoodsName("name"+i);
                gb.setSelledNumber(i*100);
                gb.setPrice(i);
                list.add(gb);
        }
    }

    private void initToolbar() {
        list_activity_toolbar.setTextTitle(entry);
        list_activity_toolbar.setRightButtonText("列");
        list_activity_toolbar.setButtonOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirst){
                    //布局变成网格
                    isFirst = false;
                    list_activity_toolbar.setRightButtonText("格");
                    list_activity_recycle.setLayoutManager(new LinearLayoutManager(ListActivity.this));
                    list_activity_recycle.setAdapter(sellAdapter2);
                }else {
                    //布局变成列
                    isFirst = true;
                    list_activity_toolbar.setRightButtonText("列");
                    list_activity_recycle.setLayoutManager(new GridLayoutManager(ListActivity.this,2));
                    list_activity_recycle.setAdapter(sellAdapter);
                }
            }
        });
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
