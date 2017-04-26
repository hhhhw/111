package com.example.hhw.c2cshoping.fragment;


//代码杂乱 ，先写着后面再改

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.activity.LoginActivity;
import com.example.hhw.c2cshoping.adapter.CartAdapter;
import com.example.hhw.c2cshoping.base.BaseFragment;
import com.example.hhw.c2cshoping.bean.CartBean;
import com.example.hhw.c2cshoping.view.MyToolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartFragment extends BaseFragment {
    private List<CartBean> listCart ,listTemp;
    private MyToolbar cart_toolbar;
    private RelativeLayout cart_under;
    private RecyclerView cart_recycler;
    private CheckBox cart_check_all;
    private TextView cart_tv_total;
    private Button cart_btn_order , cart_btn_del ;
    private double totalPrice ;
    private boolean isEdit = false;
    private CartAdapter adapter ;
    @Override
    public View InitView() {
        listCart = new ArrayList<>();
        listTemp = new ArrayList<>();         //删除用临时集合
        View view = View.inflate(getContext(),R.layout.fragment_cart,null);
        cart_toolbar = (MyToolbar) view.findViewById(R.id.cart_toolbar);
        cart_under = (RelativeLayout) view.findViewById(R.id.cart_under);
        cart_check_all = (CheckBox) view.findViewById(R.id.cart_check_all);
        cart_tv_total = (TextView) view.findViewById(R.id.cart_tv_total);
        cart_btn_order = (Button) view.findViewById(R.id.cart_btn_order);
        cart_btn_del = (Button) view.findViewById(R.id.cart_btn_del);
        cart_recycler = (RecyclerView) view.findViewById(R.id.cart_recycle);
        cart_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void InitToolbar() {
        super.InitToolbar();
        if (cart_toolbar != null){
            cart_toolbar.getmToolbarSearchview().setVisibility(View.GONE);
            cart_toolbar.setTextTitle("购物车("+listCart.size()+")");
            if (listCart.size() == 0){
                cart_toolbar.getmToolbarRightButton().setVisibility(View.GONE);
            }else {
                cart_toolbar.getmToolbarRightButton().setVisibility(View.VISIBLE);
                cart_toolbar.setRightButtonText("编辑");
            }
            cart_toolbar.setButtonOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isEdit){
                        isEdit = false;
                        cart_btn_order.setVisibility(View.VISIBLE);
                        cart_btn_del.setVisibility(View.GONE);
                        cart_toolbar.setRightButtonText("编辑");
                    }else {
                        isEdit = true;
                        cart_btn_order.setVisibility(View.GONE);
                        cart_btn_del.setVisibility(View.VISIBLE);
                        cart_toolbar.setRightButtonText("完成");
                    }
                }
            });
        }
    }

    @Override
    public void InitDate() {
        super.InitDate();
        //网络获取listCart;
        getDate();
        if (listCart.size() == 0){
            cart_under.setVisibility(View.GONE);
        }else {
            cart_under.setVisibility(View.VISIBLE);
        }
        initAdapter();
        getTotalPrice();
    }

    private void initAdapter() {
        adapter = new CartAdapter(R.layout.cart_item,listCart);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        cart_recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //跳转到对应店铺
                Toast.makeText(getContext(),"GOTO"+position,Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cart_item_cb){
                    boolean isAll = true;
                    boolean isC = listCart.get(position).isChecked();
                    listCart.get(position).setChecked(!isC);
                    for (int i = 0;i<listCart.size();i++){
                        if (!listCart.get(i).isChecked()){
                            isAll = false;
                            break;
                        }
                    }
                    cart_check_all.setChecked(isAll);
                }
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setRefreshPrice(new CartAdapter.refreshPrice() {
            @Override
            public void refeshTotalPrice(CartBean c) {
                if (c != null){
                    listCart.remove(c);
                }
                cart_toolbar.setTextTitle("购物车("+listCart.size()+")");
                if (listCart.size() == 0){
                    cart_under.setVisibility(View.GONE);
                }else {
                    cart_under.setVisibility(View.VISIBLE);
                }
                if (listCart.size() == 0){
                    cart_toolbar.getmToolbarRightButton().setVisibility(View.GONE);
                }else {
                    cart_toolbar.getmToolbarRightButton().setVisibility(View.VISIBLE);
                    cart_toolbar.setRightButtonText("编辑");
                }
                adapter.notifyDataSetChanged();
                getTotalPrice();
            }
        });
    }

    @Override
    public void InitListener() {
        super.InitListener();
        cart_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到结算界面
//                Toast.makeText(getContext(),"结算",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("orders",(Serializable) listCart);
//                intent.setClass(getContext(), );
//                intent.putExtras(bundle);
//                startActivity(intent);
            }
        });
        cart_btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0;i<listCart.size();i++){
                    if (listCart.get(i).isChecked()){
                        listTemp.add(listCart.get(i));
                    }
                }
                for (int i = 0;i<listTemp.size();i++){
                    listCart.remove(listTemp.get(i));
                }
                listTemp.clear();
                cart_toolbar.setTextTitle("购物车("+listCart.size()+")");
                if (listCart.size() == 0){
                    cart_under.setVisibility(View.GONE);
                }else {
                    cart_under.setVisibility(View.VISIBLE);
                }
                if (listCart.size() == 0){
                    cart_toolbar.getmToolbarRightButton().setVisibility(View.GONE);
                }else {
                    cart_toolbar.getmToolbarRightButton().setVisibility(View.VISIBLE);
                    cart_toolbar.setRightButtonText("编辑");
                }
                adapter.notifyDataSetChanged();
                getTotalPrice();
                isEdit = false;
            }
        });
        cart_check_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                for (int i = 0;i<listCart.size();i++) {
                    listCart.get(i).setChecked(isChecked);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
    //测试用
    public void getDate() {
        for (int i = 1;i<=5;i++){
            CartBean c = new CartBean();
            c.setName("name"+i);
            c.setPrice(i);
            c.setAmount(i);
            listCart.add(c);
        }
    }

    public void getTotalPrice() {
        totalPrice = 0;
        for (int i = 0; i < listCart.size();i++){
            totalPrice += (listCart.get(i).getPrice()*listCart.get(i).getAmount());
        }
        cart_tv_total.setText("合计:"+totalPrice);
    }
}
