package com.joyfulmath.sample.javanetwork.androidbase.recycleview.presenter;

import android.content.Context;

import com.joyfulmath.sample.javanetwork.androidbase.recycleview.model.RecycleModel;

import java.util.ArrayList;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2016-03-10 14:06
 */
public class RecyclePresenter {

    private RecycleModel model;
    public RecycleAdapter mAdapter;
    public RecyclePresenter(Context context)
    {
        model = new RecycleModel();
        mAdapter = new RecycleAdapter(context,getData());
    }

    public ArrayList<String> getData()
    {
        return model.getData();
    }

    public void onStartClick()
    {
        mAdapter.addData(2);
    }

    public void onRemoveClick()
    {
        mAdapter.removeData(1);
    }
}
