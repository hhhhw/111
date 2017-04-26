package com.example.hhw.c2cshoping.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.activity.LoginActivity;
import com.example.hhw.c2cshoping.activity.MainActivity;
import com.example.hhw.c2cshoping.activity.OrderActivity;
import com.example.hhw.c2cshoping.base.BaseFragment;
import com.example.hhw.c2cshoping.view.CircleImageView;
import com.example.hhw.c2cshoping.util.Date;
import com.example.hhw.c2cshoping.view.MyToolbar;

public class MineFragment extends BaseFragment {
    private CircleImageView mine_image;         //头像
    private TextView mine_user,mine_money;      //用户名，密码
    private TextView mine_order,mine_commodity,mine_chpw,mine_address;  //订单，商品，修改密码，地址
    private Button mine_logout;                 //退出登录
    private MyToolbar mine_toolbar;

    @Override
    public View InitView() {
        View view = View.inflate(getContext(), R.layout.fragment_mine,null);
        mine_toolbar = (MyToolbar) view.findViewById(R.id.mine_toolbar);
        mine_image = (CircleImageView) view.findViewById(R.id.mine_image);
        mine_user = (TextView) view.findViewById(R.id.mine_user);
        mine_money = (TextView) view.findViewById(R.id.mine_money);
        mine_order = (TextView) view.findViewById(R.id.mine_order);
        mine_commodity = (TextView) view.findViewById(R.id.mine_commodity);
        mine_chpw = (TextView) view.findViewById(R.id.mine_chpw);
        mine_address = (TextView) view.findViewById(R.id.mine_address);
        mine_logout = (Button) view.findViewById(R.id.mine_logout);
        return view;
    }

    @Override
    public void InitListener() {
        super.InitListener();
        mine_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Date.getUser_id()!=null) {
                    //详细信息
                }else{
                    Intent login = new Intent(getContext(), LoginActivity.class);
                    startActivity(login);
                }
            }
        });
        mine_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //订单管理
                Intent intent = new Intent(getContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
        mine_commodity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //商铺管理
            }
        });
        mine_chpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //修改密码
            }
        });
        mine_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //地址管理
            }
        });
        mine_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date.setUser_id(null);
                mine_user.setText("未登录");
                mine_money.setVisibility(View.GONE);
                mine_logout.setVisibility(View.GONE);
                Toast.makeText(getContext(),"已退出",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void InitDate() {
        super.InitDate();
        //从SharedPreferences 读入userid ， 余额
        //余额，退出登录可见。    显示用户名 ，头像。
        if(Date.getUser_id()!=null){
            mine_user.setText(Date.getUser_id());
            mine_money.setVisibility(View.VISIBLE);
            mine_logout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void InitToolbar() {
        if (mine_toolbar != null){
            mine_toolbar.getmToolbarSearchview().setVisibility(View.GONE);
            mine_toolbar.setTextTitle("我的信息");
        }
    }
}
