package com.mc.bubbletest;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

/**
 * Created by zhangzhenguo on 2017/3/8.
 */

public class CategoryLayoutView extends FrameLayout {

    private ListView mListView;

    private CateListAdapter mAdapter;

    private int top;

    public CategoryLayoutView(@NonNull Context context) {
        this(context,null);
    }

    public CategoryLayoutView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CategoryLayoutView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mListView = new ListView(context);
        mAdapter = new CateListAdapter(context);
        mListView.setAdapter(mAdapter);
        addView(mListView);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mListView.layout(0,top,right,bottom);
    }

    public void setData(int top,List<Cate> data){
        if (data == null){
            return;
        }
        this.top = top;
        mAdapter.setData(data);
    }
}
