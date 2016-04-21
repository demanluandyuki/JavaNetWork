package com.joyfulmath.sample.javanetwork.androidbase.viewpager.view;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.joyfulmath.sample.javanetwork.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;


/**
 * @author deman.lu
 * @version on 2016-04-21 17:08
 */
@EActivity(R.layout.activity_view_pager_demo)
public class ViewPagerDemo extends FragmentActivity {
    @ViewById(R.id.vp_mytest_id)
    ViewPager mVpTest;
    @ViewById(R.id.tv_item_1)
    TextView mTvItem1;
    @ViewById(R.id.tv_item_2)
    TextView mTvItem2;

    ArrayList<Fragment> fragments = new ArrayList<>();

    @AfterViews
    void initViews()
    {
        FragmentTest1_ fragmentTest1 = new FragmentTest1_();
        FragmentTest2_ fragmentTest2 = new FragmentTest2_();
        fragments.add(fragmentTest1);
        fragments.add(fragmentTest2);
        mVpTest.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        mVpTest.setOffscreenPageLimit(1);

        mTvItem1.setSelected(true);
        mTvItem2.setSelected(false);
        mVpTest.setCurrentItem(0, false);
    }


    @Click(R.id.tv_item_1)
    void onItem1Click()
    {
        mTvItem1.setSelected(true);
        mTvItem2.setSelected(false);
        mVpTest.setCurrentItem(0, false);
    }

    @Click(R.id.tv_item_2)
    void onItem2Click()
    {
        mTvItem2.setSelected(true);
        mTvItem1.setSelected(false);
        mVpTest.setCurrentItem(1,false);
    }
}
