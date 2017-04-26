package com.example.hhw.c2cshoping.fragment;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.activity.ListActivity;
import com.example.hhw.c2cshoping.activity.MainActivity;
import com.example.hhw.c2cshoping.activity.SearchActivity;
import com.example.hhw.c2cshoping.adapter.HomeAdapter;
import com.example.hhw.c2cshoping.adapter.MyPagerAdapter;
import com.example.hhw.c2cshoping.base.BaseFragment;
import com.example.hhw.c2cshoping.bean.CategoryBean;
import com.example.hhw.c2cshoping.view.MyToolbar;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {
    private RollPagerView mPagerView;
    private MyToolbar home_toolbar;
    private RecyclerView home_recycle;

    private ArrayList<CategoryBean> categoryBeen;
    @Override
    public View InitView() {
        View view = View.inflate(getContext(), R.layout.fragment_home,null);
        home_toolbar = (MyToolbar) view.findViewById(R.id.home_toolbar);
        home_recycle = (RecyclerView) view.findViewById(R.id.home_recycle);
        home_recycle.setLayoutManager(new GridLayoutManager(getContext(),2));
        mPagerView = (RollPagerView) getActivity().getLayoutInflater().inflate(R.layout.view_pager_layout, (ViewGroup) home_recycle.getParent(),false);
        mPagerView.setAdapter(new MyPagerAdapter(mPagerView));
        return view;
    }

    @Override
    public void InitDate() {
        super.InitDate();
        categoryBeen = new ArrayList<>();
        categoryBeen.add(new CategoryBean("全部商品"));
        categoryBeen.add(new CategoryBean("男装"));
        categoryBeen.add(new CategoryBean("女装"));
        categoryBeen.add(new CategoryBean("鞋子"));
        categoryBeen.add(new CategoryBean("玩具"));
        categoryBeen.add(new CategoryBean("美食"));
        categoryBeen.add(new CategoryBean("家电"));
        categoryBeen.add(new CategoryBean("办公"));
        categoryBeen.add(new CategoryBean("百货"));
    }

    @Override
    public void InitAdapter() {
        super.InitAdapter();
        HomeAdapter homeAdapter = new HomeAdapter(R.layout.category_item,categoryBeen);
        home_recycle.setAdapter(homeAdapter);
        homeAdapter.addHeaderView(mPagerView);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(),ListActivity.class);
                intent.putExtra("type",1);
                intent.putExtra("entry",categoryBeen.get(position).getCategoryText());
                startActivity(intent);
            }
        });
    }

    @Override
    public void InitListener() {
        super.InitListener();
        mPagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(),"this is " + position,Toast.LENGTH_SHORT).show();
            }
        });
        home_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void InitToolbar() {
        super.InitToolbar();
    }
}
