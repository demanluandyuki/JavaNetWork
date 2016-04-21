package com.joyfulmath.sample.javanetwork.androidbase.viewpager.view;


import android.support.v4.app.Fragment;

import com.joyfulmath.sample.javanetwork.R;
import com.joyfulmath.sample.javanetwork.utils.TraceLog;

import org.androidannotations.annotations.EFragment;

/**
 * @author deman.lu
 * @version on 2016-04-21 17:22
 */
@EFragment(R.layout.fragment_test2)
public class FragmentTest2 extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        TraceLog.i();
    }
}
