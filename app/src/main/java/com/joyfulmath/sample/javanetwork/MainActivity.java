package com.joyfulmath.sample.javanetwork;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.joyfulmath.sample.javanetwork.UrlTester.EncoderTester;
import com.joyfulmath.sample.javanetwork.UrlTester.ProtocolTester;
import com.joyfulmath.sample.javanetwork.UrlTester.URLTestFactory;
import com.joyfulmath.sample.javanetwork.UrlTester.UrlValueTester;

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
//        testProtocol();
//        testUrlValue();
        testEncoderValue();
    }

    @Background
    void getAddress()
    {
        ITestOperator sample = new INetAddressSample();
        sample.startTest();
    }

    @Background
    void testProtocol()
    {
        ITestOperator protocolTest = URLTestFactory.getOperator(ProtocolTester.class);
        protocolTest.startTest();
    }

    @Background
    void testUrlValue()
    {
        ITestOperator url = URLTestFactory.getOperator(UrlValueTester.class);
        url.startTest();
    }

    @Background
    void testEncoderValue()
    {
        ITestOperator url = URLTestFactory.getOperator(EncoderTester.class);
        url.startTest();
    }
}
