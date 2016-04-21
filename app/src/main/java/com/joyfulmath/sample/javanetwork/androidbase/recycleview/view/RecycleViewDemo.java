package com.joyfulmath.sample.javanetwork.androidbase.recycleview.view;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joyfulmath.sample.javanetwork.R;
import com.joyfulmath.sample.javanetwork.androidbase.recycleview.presenter.RecycleAdapter;
import com.joyfulmath.sample.javanetwork.androidbase.recycleview.presenter.RecyclePresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * @author deman.lu
 * @version on 2016-03-10 14:05
 */
@EActivity(R.layout.activity_recycleview_demo)
public class RecycleViewDemo extends Activity{
    @ViewById(R.id.act_solution_1_lv)
    RecyclerView mRcyV;
    RecyclePresenter mPresenter;

    @AfterViews
    void afterView()
    {
        mPresenter = new RecyclePresenter(this);
//        mRcyV.setLayoutManager(new GridLayoutManager(this,4));
        mRcyV.setLayoutManager(new LinearLayoutManager(this));
        mRcyV.setAdapter(mPresenter.mAdapter);
//        mRcyV.addItemDecoration(new RecycleGridItemDecoration(this));
        mRcyV.setItemAnimator(new DefaultItemAnimator());
//        mRcyV.setRecycledViewPool();
    }

    @Click(R.id.btn_add)
    void onStartClick()
    {
        mPresenter.onStartClick();
    }

    @Click(R.id.btn_remove)
    void onRemoveClick()
    {
        mPresenter.onRemoveClick();
    }
}
