package com.example.hhw.c2cshoping.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;

import java.util.List;


public class DetailAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    private Context context ;
    public DetailAdapter(int layoutResId, List<String> data , Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView iv = helper.getView(R.id.detail_item_imageView);
        Glide.with(context).load(item).into(iv);
    }
}
