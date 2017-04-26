package com.example.hhw.c2cshoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.MyOrderFragmentAdapter;
import com.example.hhw.c2cshoping.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by bbbb on 2017/4/26.
 */

public class MyOrderFragment extends BaseFragment {
    private ArrayList<String> list;
    private int fragmentType;
    private RecyclerView my_order_fragment_recyclerView;
    public static MyOrderFragment newInstance(int type){
        Bundle bundle = new Bundle();
        bundle.putInt("TYPE",type);
        MyOrderFragment myOrderFragment = new MyOrderFragment();
        myOrderFragment.setArguments(bundle);
        return myOrderFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentType = getArguments().getInt("TYPE");
        Log.d("TYPE",fragmentType+"");
    }

    @Override
    public View InitView() {
        View view = View.inflate(getContext(), R.layout.my_order_fragment,null);
        my_order_fragment_recyclerView = (RecyclerView) view.findViewById(R.id.my_order_fragment_recyclerView);
        my_order_fragment_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void InitAdapter() {
        super.InitAdapter();
        MyOrderFragmentAdapter myOrderFragmentAdapter = new MyOrderFragmentAdapter(R.layout.order_detail_item,list);
        my_order_fragment_recyclerView.setAdapter(myOrderFragmentAdapter);
    }

    @Override
    public void InitDate() {
        super.InitDate();
        list = new ArrayList<>();
        switch (fragmentType){
            case 0:
                list.add("0");
                list.add("1");
                list.add("2");
                list.add("3");break;
            case 1:
                list.add("0");
                list.add("0");
                list.add("0");
                list.add("0");break;
            case 2:
                list.add("1");
                list.add("1");
                list.add("1");
                list.add("1");break;
            case 3:
                list.add("2");
                list.add("2");
                list.add("2");
                list.add("2");break;
            case 4:
                list.add("3");
                list.add("3");
                list.add("3");
                list.add("3");break;
        }
    }
}
