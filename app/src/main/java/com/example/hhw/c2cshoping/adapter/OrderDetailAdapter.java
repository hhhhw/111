package com.example.hhw.c2cshoping.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by bbbb on 2017/4/25.
 */

public class OrderDetailAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public OrderDetailAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
