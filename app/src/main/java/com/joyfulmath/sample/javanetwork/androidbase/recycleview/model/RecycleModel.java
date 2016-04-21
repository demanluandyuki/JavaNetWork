package com.joyfulmath.sample.javanetwork.androidbase.recycleview.model;

import java.util.ArrayList;

/**
 * @author deman.lu email luyuanchun032@pingan.com.cn
 * @version on 2016-03-10 14:07
 */
public class RecycleModel {

    public ArrayList<String> getData()
    {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
        return mDatas;
    }
}
