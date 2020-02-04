package cn.edu.zust.dmt.tkm.views.widgets.combined;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views
 * @description $
 * @time 1/2/2020 17:33
 * copyright(c) all rights reserved by MR.M
 **/
public class MyFormBar extends ConstraintLayout {

    /**
     * @description member views
     */
    private TextView mTextView;
    private EditText mEditText;
    private int mTextSize = 40;

    /**
     * @description attributes
     */
    private String mTitleString;
    private String mHintString;

    public MyFormBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews(context);
        initializeViews(context, attrs);
    }

    /**
     * @description bind child views to class member variables
     */
    private void bindViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.views_my_form_bar, this);
        mEditText = view.findViewById(R.id.viewsMyFormBarEditText);
        mTextView = view.findViewById(R.id.viewsMyFormBarTextView);
    }

    /**
     * @description initialize MyFormBar
     */
    private void initializeViews(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyFormBar);
        mTitleString = typedArray.getString(R.styleable.MyFormBar_myFormBarTitle);
        mHintString = typedArray.getString(R.styleable.MyFormBar_myFormBarHint);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.MyFormBar_myFormBarTextSize, mTextSize);

        mTextView.setText(mTitleString);
        mEditText.setHint(mHintString);
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        mEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        typedArray.recycle();
    }

    public void setEditTextOnClickListener(OnClickListener onClickListener) {
        mEditText.setOnClickListener(onClickListener);
    }

    public Editable getText() {
        return mEditText.getText();
    }

    public void setContentText(String content) {
        mEditText.setText(content);
    }
}
