package com.example.hhw.c2cshoping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.hhw.c2cshoping.fragment.MyOrderFragment;


public class OrderFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] str = {"全部订单","未付款","待发货","已发货","待评价"};
    public OrderFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyOrderFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
