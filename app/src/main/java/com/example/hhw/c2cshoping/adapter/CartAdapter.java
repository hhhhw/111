package com.example.hhw.c2cshoping.adapter;



import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.bean.CartBean;
import com.example.hhw.c2cshoping.view.NumberView;

import java.util.List;


public class CartAdapter extends BaseQuickAdapter<CartBean,BaseViewHolder> {
    private refreshPrice refreshPrice;
    public CartAdapter(int layoutResId, List<CartBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final CartBean item) {
        helper.setText(R.id.cart_item_name,item.getName());
        helper.setText(R.id.cart_item_price,String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_num,String.valueOf(item.getAmount()));
        helper.setChecked(R.id.cart_item_cb,item.isChecked());
        helper.addOnClickListener(R.id.cart_item_cb);

        //取得NumberView ，得到变化后的商品数量
        NumberView nv = helper.getView(R.id.num_control);
        nv.setOnButtonClickListener(new NumberView.OnButtonClickListener() {
            @Override
            public void onButtonAddClick(View view, int value) {
                item.setAmount(value);
                if (refreshPrice != null)
                    refreshPrice.refeshTotalPrice(null);
            }

            @Override
            public void onButtonSubClick(View view, int value) {
                CartBean c = null;
                item.setAmount(value);
                if (value <= 0){
                    c = item;
                }
                if (refreshPrice != null)
                    refreshPrice.refeshTotalPrice(c);
            }
        });
    }

    //接口回掉刷新总价钱
    public void setRefreshPrice(refreshPrice re) {
        this.refreshPrice = re;
    }

    public interface refreshPrice{
        public void refeshTotalPrice(CartBean c);
    }
}
