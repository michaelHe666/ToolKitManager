package cn.edu.zust.dmt.tkm.views.widgets.customized;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views
 * @description $
 * @time 1/3/2020 8:03
 * copyright(c) all rights reserved by MR.M
 **/
public class MyMessageBar extends ConstraintLayout {
    /**
     * @description member views
     */
    private ImageView mImageView;
    private TextView mTextView;

    /**
     * @description attributes
     */
    private String mTitleString;
    private int mIconRID;

    public MyMessageBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews(context);
        initializeViews(context, attrs);
    }

    /**
     * @description bind child views to class member variables
     */
    private void bindViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.views_my_message_bar, this);
        mImageView = view.findViewById(R.id.viewsMyMessageBarImageView);
        mTextView = view.findViewById(R.id.viewsMyMessageBarTextView);
    }

    /**
     * @description initialize MyMessageBar
     */
    private void initializeViews(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyMessageBar);
        mTitleString = typedArray.getString(R.styleable.MyMessageBar_myMessageBarTitle);
        mIconRID = typedArray.getResourceId(R.styleable.MyMessageBar_myMessageBarIcon, 0);

        if (mIconRID != 0) {
            mImageView.setImageDrawable(getResources().getDrawable(mIconRID));
        }

        mTextView.setText(mTitleString);
        typedArray.recycle();
    }
}