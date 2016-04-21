package com.joyfulmath.sample.javanetwork.androidbase.scrollview.presenter;

import com.joyfulmath.sample.javanetwork.androidbase.scrollview.modle.DataController;
import com.joyfulmath.sample.javanetwork.androidbase.scrollview.view.IScrollView;

import java.util.List;
import java.util.Map;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2016-03-09 17:51
 */
public class ScrollPresenter {
    DataController mDataController = null;
    IScrollView mViewController = null;
    public ScrollPresenter(IScrollView viewController)
    {
        mViewController = viewController;
        mDataController = new DataController();
    }

    public List<Map<String, Object>> getdata()
    {
        return mDataController.getData();
    }
}
