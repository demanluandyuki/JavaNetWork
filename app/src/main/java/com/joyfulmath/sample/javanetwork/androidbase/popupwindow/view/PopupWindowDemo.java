package com.joyfulmath.sample.javanetwork.androidbase.popupwindow.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.joyfulmath.sample.javanetwork.R;
import com.joyfulmath.sample.javanetwork.androidbase.popupwindow.presenter.IPopupPresenter;
import com.joyfulmath.sample.javanetwork.androidbase.popupwindow.presenter.PopupPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * @author deman.lu
 * @version on 2016-03-16 17:28
 */
@EActivity(R.layout.activity_main)
public class PopupWindowDemo extends Activity implements IPopupView{

    @ViewById(R.id.bt_start)
    Button mStart;
    PopupWindow  mPopupWindow = null;
    IPopupPresenter popupPresenter;
    @AfterViews
    @SuppressWarnings("all")
    void initView()
    {
        mStart.setText("popupwindows");
        popupPresenter = new PopupPresenter();
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }


    @Override
    @SuppressWarnings("all")
    public void showPopupWindow() {
        View view  = LayoutInflater.from(this).inflate(R.layout.popup_menu_add_photo,null);
        TextView takePhoto = (TextView) view.findViewById(R.id.take_photo_tv);
        TextView choosePhoto = (TextView) view.findViewById(R.id.choose_photo_tv);
        TextView cancel = (TextView) view.findViewById(R.id.cancel);
        onPopupClick mClicklistener = new onPopupClick();
        takePhoto.setOnClickListener(mClicklistener);
        choosePhoto.setOnClickListener(mClicklistener);
        cancel.setOnClickListener(mClicklistener);

        if(mPopupWindow == null)
        {
            mPopupWindow = new PopupWindow(this);
            mPopupWindow.setWidth(500);
            mPopupWindow.setHeight(500);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setAnimationStyle(R.style.contextMenuAnim);
        }

        mPopupWindow.setContentView(view);
        mPopupWindow.showAsDropDown(mStart, 20, 30);
    }

    public class onPopupClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.take_photo_tv:
                    popupPresenter.onTakePhoto();
                    break;
                case R.id.choose_photo_tv:
                    popupPresenter.onSelectPhoto();
                    break;
                case R.id.cancel:
                    mPopupWindow.dismiss();
                    break;
            }
        }
    }
}
