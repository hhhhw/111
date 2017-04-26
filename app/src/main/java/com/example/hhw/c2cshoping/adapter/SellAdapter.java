package com.example.hhw.c2cshoping.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.bean.GoodsBean;

import java.util.List;

public class SellAdapter extends BaseQuickAdapter<GoodsBean,BaseViewHolder> {

    public SellAdapter(int layoutResId, List<GoodsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean item) {
        helper.setText(R.id.item_name,item.getGoodsName())
                .setText(R.id.item_address,item.getAddress())
                .setText(R.id.item_isbaoyou,"包邮")
                .setText(R.id.item_price,"￥:"+item.getPrice())
                .setText(R.id.item_selled,item.getSelledNumber()+"人收货");
    }
}
