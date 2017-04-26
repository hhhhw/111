package com.example.hhw.c2cshoping.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.view.NumberView;

import java.util.List;

public class ConfirmOrderAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {
    private List<Integer> data;
    public ConfirmOrderAdapter(int layoutResId, List<Integer> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        if (data.size() == 1){
            helper.getView(R.id.order_confirm_item_numberLine).setVisibility(View.VISIBLE);
            NumberView numberView = helper.getView(R.id.order_confirm_item_numberView);
            numberView.setValue(item);
            numberView.setOnButtonClickListener(new NumberView.OnButtonClickListener() {
                @Override
                public void onButtonAddClick(View view, int value) {

                }

                @Override
                public void onButtonSubClick(View view, int value) {

                }
            });
        }
    }
}
