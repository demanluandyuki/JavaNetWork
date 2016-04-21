package com.joyfulmath.sample.javanetwork.androidbase.scrollview.view;

import android.app.Activity;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;

import com.joyfulmath.sample.javanetwork.R;
import com.joyfulmath.sample.javanetwork.androidbase.scrollview.presenter.ScrollPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2016-03-09 17:40
 */
@EActivity(R.layout.activity_scrollview_demo)
public class ScrollViewDemo extends Activity implements IScrollView{

    @ViewById(R.id.act_solution_1_lv)
    ListView mListView;
    @ViewById(R.id.act_solution_1_sv)
    ScrollView mSv;
    SimpleAdapter simpleAdapter = null;
    ScrollPresenter scrollPresenter = null;

    @AfterViews
    void initView() {
        scrollPresenter = new ScrollPresenter(this);
        simpleAdapter = new SimpleAdapter(this, scrollPresenter.getdata(),
                R.layout.item_list, new String[]{"title", "info"},
                new int[]{R.id.tv_1, R.id.tv_2});
        mListView.setAdapter(simpleAdapter);
        mSv.smoothScrollTo(0,0);
    }


}
