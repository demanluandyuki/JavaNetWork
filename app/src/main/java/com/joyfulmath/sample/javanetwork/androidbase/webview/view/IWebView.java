package com.joyfulmath.sample.javanetwork.androidbase.webview.view;

import com.joyfulmath.sample.javanetwork.androidbase.BaseView;

/**
 * @author deman.lu
 * @version on 2016-03-11 14:33
 */
public interface IWebView extends BaseView {
    void loadUrl(String url);
    void clearHistory();
}
