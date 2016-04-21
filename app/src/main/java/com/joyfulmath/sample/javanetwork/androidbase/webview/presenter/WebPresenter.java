package com.joyfulmath.sample.javanetwork.androidbase.webview.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.joyfulmath.sample.javanetwork.androidbase.webview.model.WebModel;
import com.joyfulmath.sample.javanetwork.androidbase.webview.view.IWebView;

import java.net.URI;

/**
 * @author deman.lu
 * @version on 2016-03-11 14:40
 */
public class WebPresenter implements IWebPresenter{

    WebModel  model;
    IWebView mViewController;
    Context context;
    WebChromeClient webChromeClient = new WebChromeClient(){
        @Override
        public View getVideoLoadingProgressView() {
            return super.getVideoLoadingProgressView();
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if(newProgress <100)
            {
                mViewController.showLoading();
            }
            else
            {
                mViewController.closeLoading();
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();
        }
    };

    WebViewClient webViewClient = new WebViewClient(){

        /**
         * the most important API for H5 & app to connect
         * @param view view
         * @param url  url
         * @return     true. doing with url. false,pass the event.
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(url.contains("abcxxx.html"))
            {
                /*it must be here, can clear last one in history*/
                mViewController.clearHistory();
            }
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    };


    public WebPresenter(IWebView mViewController,Context context) {
        this.mViewController = mViewController;
        model = new WebModel();
        this.context = context;

    }
    @Override
    public WebChromeClient generateWebChromeClient() {
        return webChromeClient;
    }

    @Override
    public WebViewClient generateWebViewClient() {
        return webViewClient;
    }

    @Override
    public JsPresenterInterface getJsCallback() {
        return new JsPresenterInterface(context);
    }

    @Override
    public String JsInterfaceName() {
        return "demo";
    }


    @Override
    public void init() {
        mViewController.loadUrl(model.getUrl());
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        model = null;
        webViewClient = null;
        webChromeClient = null;
    }

    @Override
    public void onBackClick() {
    }

    @Override
    @SuppressWarnings("all")
    public void setCookie() {
        URI uri = URI.create(model.getUrl());
        if (TextUtils.isEmpty(uri.getHost())) {
            return;
        }

        if (Build.VERSION.SDK_INT <= 20) {
            CookieSyncManager.createInstance(context);
        }

        CookieManager cm = CookieManager.getInstance();
        cm.setAcceptCookie(true);
        cm.removeSessionCookies(null);
        cm.setCookie(model.getUrl(),new String("cookievalue"));

        if (Build.VERSION.SDK_INT >= 21) {
            cm.flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
    }
}
