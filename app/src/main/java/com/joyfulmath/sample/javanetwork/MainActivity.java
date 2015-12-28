package com.joyfulmath.sample.javanetwork;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.bt_start)
    Button mBtStart;

    @AfterViews
    void afterView()
    {

    }

    @Click(R.id.bt_start)
    void onStartClick()
    {
//        getAddress();
        testProtocol();
    }

    @Background
    void getAddress()
    {
        IOperator sample = new INetAddressSample();
        sample.start();
    }

    @Background
    void testProtocol()
    {
        IOperator protocolTest = new ProtocalTester();
        protocolTest.start();
    }
}
