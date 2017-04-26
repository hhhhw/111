package com.example.hhw.c2cshoping.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.bean.CategoryBean;
import com.example.hhw.c2cshoping.bean.GoodsBean;

import java.util.List;



public class HomeAdapter extends BaseQuickAdapter<CategoryBean,BaseViewHolder> {

    public HomeAdapter(int layoutResId, List<CategoryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryBean item) {
        helper.setText(R.id.category_text,item.getCategoryText())
                .setImageResource(R.id.category_icon,R.drawable.default_head);
    }

}
