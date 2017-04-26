package com.example.hhw.c2cshoping.adapter;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;

import java.util.List;

public class SearchAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public SearchAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.search_item_text,item);
        helper.addOnClickListener(R.id.search_item_del).addOnClickListener(R.id.search_item_text);
    }
}
