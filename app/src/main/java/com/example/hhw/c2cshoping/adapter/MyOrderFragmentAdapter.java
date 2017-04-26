package com.example.hhw.c2cshoping.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;

import java.util.List;

/**
 * Created by bbbb on 2017/4/27.
 */

public class MyOrderFragmentAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public MyOrderFragmentAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        switch (item){
            case "0":
                helper.getView(R.id.order_detail_item_pay).setVisibility(View.VISIBLE);break;
            case "1":
                helper.getView(R.id.order_detail_item_ship).setVisibility(View.VISIBLE);break;
            case "2":
                helper.getView(R.id.order_detail_item_arrived).setVisibility(View.VISIBLE);break;
            case "3":
                helper.getView(R.id.order_detail_item_assess).setVisibility(View.VISIBLE);break;
        }
    }
}
