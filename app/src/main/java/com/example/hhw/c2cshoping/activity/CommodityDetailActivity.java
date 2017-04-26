package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.DetailAdapter;
import com.example.hhw.c2cshoping.view.NumberView;

import java.util.ArrayList;

public class CommodityDetailActivity extends AppCompatActivity {
    private RecyclerView detail_activity_recycleView;
    private DetailAdapter myAdapter;
    private ArrayList<String> list;
    private Button detail_activity_buy;
    private NumberView myNumber;
    private View view;
    private int commodityNumber = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil_commodity);
        initView();
        getDate();
        initAdapter();
        initListener();
    }

    private void initListener() {
        myNumber.setOnButtonClickListener(new NumberView.OnButtonClickListener() {
            @Override
            public void onButtonAddClick(View view, int value) {
                commodityNumber = value;
            }
            @Override
            public void onButtonSubClick(View view, int value) {
                commodityNumber = value;
            }
        });
        detail_activity_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommodityDetailActivity.this,ConfirmOrderActivity.class);
                intent.putExtra("Number",commodityNumber);
                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        myAdapter = new DetailAdapter(R.layout.commodity_detail_item,list,this);
        myAdapter.setHeaderView(view);
        detail_activity_recycleView.setAdapter(myAdapter);
    }

    private void initView() {
        view = View.inflate(this,R.layout.commodity_detail_head,null);
        myNumber = (NumberView) view.findViewById(R.id.detail_head_numberView);
        myNumber.setValue(1);

        detail_activity_recycleView = (RecyclerView) findViewById(R.id.detail_activity_recyclerView);
        detail_activity_recycleView.setLayoutManager(new LinearLayoutManager(this));
        detail_activity_buy = (Button) findViewById(R.id.detail_activity_buy);
    }

    public void getDate() {
        list = new ArrayList<>();
        list.add("http://img4.imgtn.bdimg.com/it/u=2552434277,682249949&fm=23&gp=0.jpg");
        list.add("http://h.hiphotos.baidu.com/image/h%3D220/sign=a62494f2374e251ffdf7e3fa9787c9c2/72f082025aafa40facebf815ac64034f79f019cc.jpg");
        list.add("http://www.5857.com/uploadfile/2015/0321/20150321103512823.jpg");
    }
}
