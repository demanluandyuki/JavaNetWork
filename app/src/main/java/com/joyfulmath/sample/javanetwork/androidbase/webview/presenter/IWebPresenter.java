package com.joyfulmath.sample.javanetwork.androidbase.webview.presenter;

import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.joyfulmath.sample.javanetwork.androidbase.BasePresenter;

/**
 * @author deman.lu
 * @version on 2016-03-11 14:40
 */
public interface IWebPresenter extends BasePresenter
{
    WebChromeClient generateWebChromeClient();
    WebViewClient   generateWebViewClient();
    JsPresenterInterface getJsCallback();
    String JsInterfaceName();
    void init();
    void setCookie();
}
