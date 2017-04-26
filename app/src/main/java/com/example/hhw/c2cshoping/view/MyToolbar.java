package com.example.hhw.c2cshoping.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hhw.c2cshoping.R;


public class MyToolbar extends Toolbar {

    TextView mToolbarTitle,mToolbarSearchview;
    Button mToolbarRightButton;
    private View mView;
    private TintTypedArray mTintTypedArray;

    public MyToolbar(Context context) {
        this(context,null);
    }

    public MyToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyToolbar(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
        initView();
        setContentInsetsRelative(10,10);
        if(attrs != null){
            mTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(),attrs,R.styleable.MyToolBar,defStyleAttr,0);
            Drawable buttonDrawable = mTintTypedArray.getDrawable(R.styleable.MyToolBar_rightButtonIcon);
            boolean isShowSearchView = mTintTypedArray.getBoolean(R.styleable.MyToolBar_isShowSearchView,false);
            String buttonText = mTintTypedArray.getString(R.styleable.MyToolBar_rightButtonText);
            if(buttonDrawable != null){
                setRightButtonDrawable(buttonDrawable);
            }

            setRightButtonText(buttonText);

            if (isShowSearchView){
                ShowSearchView();
                hideTextView();
            }else {
                hideSearchView();
                showTextView();
            }
            mTintTypedArray.recycle();
        }
    }

    private void initView() {
        if(mView == null){
            mView = View.inflate(getContext(), R.layout.layout_mtoolbar,null);
            mToolbarTitle = (TextView) mView.findViewById(R.id.toolbar_title);
            mToolbarSearchview = (TextView) mView.findViewById(R.id.toolbar_searchview);
            mToolbarRightButton = (Button) mView.findViewById(R.id.toolbar_rightButton);
        }
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        addView(mView,params);
    }

    private void showTextView() {
        if(mToolbarTitle!=null){
            mToolbarTitle.setVisibility(VISIBLE);
        }
    }

    private void hideSearchView() {
        if (mToolbarSearchview!=null){
            mToolbarSearchview.setVisibility(GONE);
        }
    }

    private void hideTextView() {
        if (mToolbarTitle!=null){
            mToolbarTitle.setVisibility(GONE);
        }
    }

    private void ShowSearchView() {
        if (mToolbarSearchview!=null){
            mToolbarSearchview.setVisibility(VISIBLE);
        }
    }

    public Button getmToolbarRightButton() {
        return mToolbarRightButton;
    }

    public TextView getmToolbarSearchview() {
        return mToolbarSearchview;
    }

    public void setRightButtonDrawable(Drawable rightButtonDrawable) {
        if (mToolbarRightButton != null){
            mToolbarRightButton.setVisibility(VISIBLE);
            mToolbarRightButton.setBackground(rightButtonDrawable);
        }
    }

    public void setRightButtonText(String rightButtonText) {
        mToolbarRightButton.setVisibility(VISIBLE);
        if (mToolbarRightButton != null){
            mToolbarRightButton.setText(rightButtonText);
        }
    }

    public void setTextTitle(String TitleText){
        mToolbarTitle.setVisibility(VISIBLE);
        if (mToolbarTitle != null){
            mToolbarTitle.setText(TitleText);
        }
    }

    public void setButtonOnClickListener(OnClickListener listener){
        if (mToolbarRightButton != null){
            mToolbarRightButton.setOnClickListener(listener);
        }
    }


}
