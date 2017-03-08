package com.mc.bubbletest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.mc.bubbletest.R.id.fl_content;

public class MainActivity extends AppCompatActivity {

    private FrameLayout flContent;

    private NoScrollListView mListView;

    private CateListAdapter mAdapter;

    private List<Cate> mCateList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

    private void initView(){
        flContent = (FrameLayout) findViewById(fl_content);
    }

    private void setData(){
        mAdapter = new CateListAdapter(this);
        mListView = new NoScrollListView(this);
        mListView.setPadding(8,8,8,8);
        mListView.setAdapter(mAdapter);
        flContent.addView(mListView);
    }

    public void add(View view){
        Cate cate = new Cate();
        cate.setName("你的名字");
        mCateList.add(cate);
        mAdapter.setData(mCateList);
        if (mAdapter.getCount() > 0){
            mListView.setBackgroundColor(Color.GREEN);
        }
    }

    public void clear(View view){
        mCateList.clear();
        mAdapter.setData(mCateList);
        if (mAdapter.getCount() <= 0){
            mListView.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }
}
