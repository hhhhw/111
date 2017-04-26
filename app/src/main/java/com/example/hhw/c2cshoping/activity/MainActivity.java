package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.fragment.HomeFragment;

import com.example.hhw.c2cshoping.fragment.CartFragment;
import com.example.hhw.c2cshoping.fragment.MineFragment;

import com.example.hhw.c2cshoping.fragment.SellFragment;
import com.example.hhw.c2cshoping.util.Date;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fm = null;
    private HomeFragment home;
    private SellFragment sell;
    private CartFragment cart;
    private MineFragment mine;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = fm.beginTransaction();
            if(home != null){
                ft.hide(home);
            }
            if(sell != null){
                ft.hide(sell);
            }
            if(cart != null){
                ft.hide(cart);
            }
            if(mine != null){
                ft.hide(mine);
            }
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (home == null){
                        home = new HomeFragment();
                        ft.add(R.id.content,home);
                    }
                    ft.show(home);
                    ft.commit();
                    return true;
                case R.id.navigation_sell:
                    if (sell == null){
                        sell = new SellFragment();
                        ft.add(R.id.content,sell);
                    }
                    ft.show(sell);
                    ft.commit();
                    return true;
                case R.id.navigation_cart:
                    if (cart == null){
                        cart = new CartFragment();
                        ft.add(R.id.content,cart);
                    }
                    if(Date.getIsCartChange()){
                        ft.remove(cart);
                        cart = new CartFragment();
                        ft.add(R.id.content,cart);
                    }
                    ft.show(cart);
                    ft.commit();
                    return true;
                case R.id.navigation_mine:
                    if (mine == null){
                        mine = new MineFragment();
                        ft.add(R.id.content,mine);
                    }
                    ft.show(mine);
                    ft.commit();
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        home = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.content,home);
        ft.show(home);
        ft.commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (Date.getUser_id()!=null){
            mine.InitDate();
        }
        super.onNewIntent(intent);
    }
}
