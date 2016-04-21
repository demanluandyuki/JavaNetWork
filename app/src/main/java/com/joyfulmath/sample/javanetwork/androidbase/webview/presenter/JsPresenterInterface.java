package com.joyfulmath.sample.javanetwork.androidbase.webview.presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.JavascriptInterface;

/**
 * @author deman.lu
 * @version on 2016-03-15 14:47
 */
public class JsPresenterInterface {

    private Context context;
    public JsPresenterInterface(Context context)
    {
        this.context = context;
    }

    @JavascriptInterface
    public String version()
    {
        String versionName = null;
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(),0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionName;
    }
}
