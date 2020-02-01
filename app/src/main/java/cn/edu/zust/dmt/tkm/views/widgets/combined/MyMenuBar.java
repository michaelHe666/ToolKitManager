package cn.edu.zust.dmt.tkm.views.widgets.combined;

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
 * @time 1/2/2020 13:02
 * copyright(c) all rights reserved by MR.M
 **/
public class MyMenuBar extends ConstraintLayout {

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

    public MyMenuBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews(context);
        initializeViews(context, attrs);
    }

    /**
     * @description bind child views to class member variables
     */
    private void bindViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.views_my_menu_bar, this);
        mImageView = view.findViewById(R.id.viewsMyMenuBarImageView);
        mTextView = view.findViewById(R.id.viewsMyMenuBarTextView);
    }

    /**
     * @description initialize MyMenuBar
     */
    private void initializeViews(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyMenuBar);
        mTitleString = typedArray.getString(R.styleable.MyMenuBar_myMenuBarTitle);
        mIconRID = typedArray.getResourceId(R.styleable.MyMenuBar_myMenuBarIcon, 0);

        if (mIconRID != 0) {
            mImageView.setImageDrawable(getResources().getDrawable(mIconRID));
        }

        mTextView.setText(mTitleString);
        typedArray.recycle();
    }

}
