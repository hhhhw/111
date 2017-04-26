package com.example.hhw.c2cshoping.view;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hhw.c2cshoping.R;

public class NumberView extends LinearLayout implements View.OnClickListener {
    public static final int MAX = 1000;
    public static final int MIN = 0;

    private TextView mTextNum;
    private Button mButtonAdd;
    private Button mButtonSub;

    private OnButtonClickListener onButtonClickListener;

    private LayoutInflater mflater;

    private int value;
    private int maxValue = MAX;
    private int minValue = MIN;
    public NumberView(Context context) {
        this(context, null);
    }

    public NumberView(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NumberView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mflater = LayoutInflater.from(context);
        initView();

        if (attrs != null){
            final TintTypedArray tta = TintTypedArray.obtainStyledAttributes(getContext(),attrs,R.styleable.NumberAddSubView,defStyleAttr,0);

            int val = tta.getInt(R.styleable.NumberAddSubView_value,0);
            setValue(val);
            int maxVal = tta.getInt(R.styleable.NumberAddSubView_maxValue,0);
            if (maxVal != 0)
                setMaxValue(maxVal);
            int minVal = tta.getInt(R.styleable.NumberAddSubView_minValue,0);
            if (minVal != 0)
                setMinValue(minVal);

            Drawable tvbg = tta.getDrawable(R.styleable.NumberAddSubView_TextBackground);
            if (tvbg != null)
                setTextViewBackground(tvbg);

            Drawable btnAddbg = tta.getDrawable(R.styleable.NumberAddSubView_buttonAddBackgroud);
            if (btnAddbg != null)
                setButtonAddBackground(btnAddbg);

            Drawable btnSubbg = tta.getDrawable(R.styleable.NumberAddSubView_buttonSubBackgroud);
            if (btnSubbg != null)
                setButtonSubBackground(btnSubbg);

            tta.recycle();
        }
    }

    private void initView() {
        View view = mflater.inflate(R.layout.widget_num,this,true);

        mTextNum = (TextView) view.findViewById(R.id.tv_num);
        mButtonAdd = (Button) view.findViewById(R.id.btn_add);
        mButtonSub = (Button) view.findViewById(R.id.btn_sub);
        mButtonAdd.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_add){
            numAdd();
            if (onButtonClickListener != null){
                onButtonClickListener.onButtonAddClick(v,this.value);
            }
        }else if (v.getId() == R.id.btn_sub){
            numSub();
            if (onButtonClickListener != null){
                onButtonClickListener.onButtonSubClick(v,this.value);
            }
        }
    }

    private void numSub() {
        getValue();
        if (this.value > minValue)
            this.value -= 1;
        mTextNum.setText(value + " ");
    }

    private void numAdd() {
        getValue();
        if (this.value <= maxValue)
            this.value += 1;
        mTextNum.setText(value + " ");
    }

    public int getValue() {
        String value = mTextNum.getText().toString().trim();
        if (value != null && !TextUtils.isEmpty(value)){
            this.value = Integer.parseInt(value);
        }
        return this.value;
    }

    public void setValue(int value) {
        mTextNum.setText(value + "");
        this.value = value;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setTextViewBackground(Drawable d){
        mTextNum.setBackground(d);
    }

    public void setButtonAddBackground(Drawable d){
        this.mButtonAdd.setBackground(d);
    }

    public void setButtonSubBackground(Drawable d){
        this.mButtonSub.setBackground(d);
    }
    public interface OnButtonClickListener {

        public void onButtonAddClick(View view, int value);

        public void onButtonSubClick(View view, int value);

    }
}
