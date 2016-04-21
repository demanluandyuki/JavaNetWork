package com.joyfulmath.sample.javanetwork.androidbase.webview.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.joyfulmath.sample.javanetwork.R;
import com.joyfulmath.sample.javanetwork.androidbase.webview.presenter.IWebPresenter;
import com.joyfulmath.sample.javanetwork.androidbase.webview.presenter.WebPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * @author deman.lu
 * @version on 2016-03-11 14:32
 */
@EActivity(R.layout.activity_webview_demo)
public class WebViewDemo extends Activity implements IWebView{
    @ViewById(R.id.wv_demo)
    WebView mWebView = null;
    WebSettings mSettings = null;
    IWebPresenter mPresenter = null;
    ProgressDialog mProDialog = null;
    @AfterViews
    void afterViews()
    {
        mProDialog = new ProgressDialog(this,R.style.AppTheme);
        mPresenter = new WebPresenter(this,this.getApplicationContext());
        mWebView.setWebChromeClient(mPresenter.generateWebChromeClient());
        mWebView.setWebViewClient(mPresenter.generateWebViewClient());
        mWebView.addJavascriptInterface(mPresenter.getJsCallback(), mPresenter.JsInterfaceName());
        mSettings = mWebView.getSettings();
        mSettings.setJavaScriptEnabled(true);
        mSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mSettings.setAppCacheEnabled(true);
        mSettings.setDatabaseEnabled(true);
        mPresenter.init();
        mPresenter.setCookie();
    }

    @Override
    public void loadUrl(String url) {
        mWebView.loadUrl(url);
    }


    @Override
    public void clearHistory() {
        mWebView.clearHistory();
    }

    @Override
    public void showLoading() {
        mProDialog.show();
    }

    @Override
    public void closeLoading() {
        mProDialog.dismiss();
    }

    @Override
    public void showSomeToast(String msg) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            mPresenter.onBackClick();
        } else {
            super.onBackPressed();
        }
    }
}
