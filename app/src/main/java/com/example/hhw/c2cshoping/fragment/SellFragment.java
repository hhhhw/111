package com.example.hhw.c2cshoping.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.HomeAdapter;
import com.example.hhw.c2cshoping.base.BaseFragment;
import com.example.hhw.c2cshoping.bean.CategoryBean;
import com.example.hhw.c2cshoping.view.MyToolbar;

import java.util.ArrayList;


public class SellFragment extends BaseFragment {
    private MyToolbar sell_toolbar ;
    private RecyclerView sell_recycle ;
    private ArrayList<CategoryBean> list ;
    @Override
    public View InitView() {
        View view = View.inflate(getContext(),R.layout.fragment_sell,null);
        sell_toolbar = (MyToolbar) view.findViewById(R.id.sell_toolbar);
        sell_recycle = (RecyclerView) view.findViewById(R.id.sell_recycle);
        sell_recycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        return view;
    }

    @Override
    public void InitListener() {
        super.InitListener();
    }

    @Override
    public void InitToolbar() {
        super.InitToolbar();
        sell_toolbar.setTextTitle("我的店铺");
    }

    @Override
    public void InitAdapter() {
        super.InitAdapter();
        HomeAdapter homeAdapter = new HomeAdapter(R.layout.category_item,list);
        sell_recycle.setAdapter(homeAdapter);
    }

    @Override
    public void InitDate() {
        super.InitDate();
        list = new ArrayList<>();
        list.add(new CategoryBean("全部订单"));
        list.add(new CategoryBean("已评价"));
        list.add(new CategoryBean("已下单"));
        list.add(new CategoryBean("已付款"));
        list.add(new CategoryBean("已发货"));
        list.add(new CategoryBean("已收货"));
    }
}
