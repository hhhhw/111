package com.example.hhw.c2cshoping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.hhw.c2cshoping.R;
import com.example.hhw.c2cshoping.adapter.SearchAdapter;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView search_activity_recycle;
    private Spinner search_activity_spinner;
    private EditText search_activity_searchEntry;
    private Button search_activity_goSearch;
    private TextView search_activity_delAll;
    private ArrayList<String> list;
    private int type ;
    private SearchAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initDate();
        isShowDelAll();
        initAdapter();
        initListener();
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0; i< 5;i++){
            list.add("历史记录"+i);
        }
    }

    private void initListener() {
        search_activity_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    type = 1;
                }else {
                    type = 2;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                type = 1;
            }
        });
        search_activity_goSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将当前搜索加入历史记录
                Intent intent = new Intent(SearchActivity.this,ListActivity.class);
                intent.putExtra("type",type);
                intent.putExtra("entry",search_activity_searchEntry.getText().toString().trim());
                startActivity(intent);
            }
        });
        search_activity_delAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                isShowDelAll();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initAdapter() {
        adapter = new SearchAdapter(R.layout.search_item,list);
        adapter.setOnItemChildClickListener(this);
        search_activity_recycle.setLayoutManager(new LinearLayoutManager(this));
        search_activity_recycle.setAdapter(adapter);
    }

    private void initView() {
        search_activity_recycle = (RecyclerView) findViewById(R.id.search_activity_recycle);
        search_activity_spinner = (Spinner) findViewById(R.id.search_activity_spinner);
        search_activity_searchEntry = (EditText) findViewById(R.id.search_activity_searchEntry);
        search_activity_goSearch = (Button) findViewById(R.id.search_activity_goSearch);
        search_activity_delAll = (TextView) findViewById(R.id.search_activity_dellAll);
    }

    public void isShowDelAll() {
        search_activity_delAll.setVisibility((list.size()==0)?View.GONE:View.VISIBLE);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()){
            case R.id.search_item_text:
                Intent intent = new Intent(SearchActivity.this,ListActivity.class);
                intent.putExtra("type",type);
                intent.putExtra("entry",list.get(position));
                startActivity(intent);break;
            case R.id.search_item_del:
                adapter.remove(position);break;
        }
    }
}
