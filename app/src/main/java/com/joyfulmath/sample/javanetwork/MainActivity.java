package com.joyfulmath.sample.javanetwork;

import android.app.KeyguardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.joyfulmath.sample.javanetwork.UrlTester.EncoderTester;
import com.joyfulmath.sample.javanetwork.UrlTester.ProtocolTester;
import com.joyfulmath.sample.javanetwork.UrlTester.URLTestFactory;
import com.joyfulmath.sample.javanetwork.UrlTester.UrlValueTester;
import com.joyfulmath.sample.javanetwork.androidbase.popupwindow.view.PopupWindowDemo_;
import com.joyfulmath.sample.javanetwork.androidbase.recycleview.view.RecycleViewDemo;
import com.joyfulmath.sample.javanetwork.androidbase.recycleview.view.RecycleViewDemo_;
import com.joyfulmath.sample.javanetwork.androidbase.viewpager.view.ViewPagerDemo_;
import com.joyfulmath.sample.javanetwork.androidbase.webview.view.WebViewDemo_;
import com.joyfulmath.sample.javanetwork.utils.TraceLog;

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
    void afterView() {

    }

    @Click(R.id.bt_start)
    void onStartClick() {
//        getAddress();
//        testProtocol();
//        testUrlValue();
//        testEncoderValue();
//        WebViewDemo_.intent(this).start();
//        RecycleViewDemo_.intent(this).start();
        ViewPagerDemo_.intent(this).start();
    }

    @Background
    void getAddress() {
        ITestOperator sample = new INetAddressSample();
        sample.startTest();
    }

    @Background
    void testProtocol() {
        ITestOperator protocolTest = URLTestFactory.getOperator(ProtocolTester.class);
        protocolTest.startTest();
    }

    @Background
    void testUrlValue() {
        ITestOperator url = URLTestFactory.getOperator(UrlValueTester.class);
        url.startTest();
    }

    @Background
    void testEncoderValue() {
        ITestOperator url = URLTestFactory.getOperator(EncoderTester.class);
        url.startTest();
    }

    void keylock() {
        KeyguardManager mKeyguardManager = (KeyguardManager) this.getSystemService(Context.KEYGUARD_SERVICE);
        boolean flag = mKeyguardManager.inKeyguardRestrictedInputMode();
        TraceLog.i("flag:" + flag);
    }

    void threadRun()
    {
        new Thread(){
            @Override
            public void run() {
                while(true)
                {
                    try {
                        keylock();
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
