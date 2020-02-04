package cn.edu.zust.dmt.tkm.views.widgets.combined;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 **/
public class MyTopBar extends ConstraintLayout {

    /**
     * @description member views
     */
    private ImageButton mLeftButton;
    private ImageButton mRightButton;
    private TextView mCenterTextView;

    /**
     * @description attributes
     */
    private String mTitleString = "";
    private int mRightButtonRID = 0;
    private Boolean isRightButtonShown = false;
    private int mLeftButtonRID = 0;
    private Boolean isLeftButtonShown = false;

    public MyTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews(context);
        initializeViews(context, attrs);
    }

    /**
     * @description bind child views to class member variables
     */
    private void bindViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.views_my_top_bar, this);
        mLeftButton = view.findViewById(R.id.viewsMyTopBarLeftImageButton);
        mCenterTextView = view.findViewById(R.id.viewsMyTopBarCenterTextView);
        mRightButton = view.findViewById(R.id.viewsMyTopBarRightImageButton);
    }

    /**
     * @description initialize myTopBar
     */
    private void initializeViews(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyTopBar);
        mTitleString = typedArray.getString(R.styleable.MyTopBar_myTopBarTitle);
        mLeftButtonRID = typedArray.getResourceId(R.styleable.MyTopBar_myTopBarLeftIcon, mLeftButtonRID);
        isLeftButtonShown = typedArray.getBoolean(R.styleable.MyTopBar_myTopBarShowLeftIcon, isLeftButtonShown);
        mRightButtonRID = typedArray.getResourceId(R.styleable.MyTopBar_myTopBarRightIcon, mRightButtonRID);
        isRightButtonShown = typedArray.getBoolean(R.styleable.MyTopBar_myTopBarShowRightIcon, isRightButtonShown);

        if (!isRightButtonShown) {
            mRightButton.setVisibility(View.GONE);
        }
        if (mRightButtonRID != 0) {
            mRightButton.setImageDrawable(getResources().getDrawable(mRightButtonRID));
        }
        if (!isLeftButtonShown) {
            mLeftButton.setVisibility(View.GONE);
        }
        if (mLeftButtonRID != 0) {
            mLeftButton.setImageDrawable(getResources().getDrawable(mLeftButtonRID));
        }
        if (!TextUtils.isEmpty(mTitleString)) {
            mCenterTextView.setText(mTitleString);
        }

        typedArray.recycle();
    }

    /**
     * @param onClickListener left button listener interface
     */
    public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
        mLeftButton.setOnClickListener(onClickListener);
    }

    /**
     * @param onClickListener right button listener interface
     */
    public void setRightButtonOnClickListener(OnClickListener onClickListener) {
        mRightButton.setOnClickListener(onClickListener);
    }

    /**
     * @param leftButtonRID show left icon button by RID
     */
    public void showLeftButton(int leftButtonRID) {
        if (mLeftButtonRID != leftButtonRID) {
            mLeftButtonRID = leftButtonRID;
            mLeftButton.setImageDrawable(getResources().getDrawable(mLeftButtonRID));
        }
        mLeftButton.setVisibility(View.VISIBLE);
    }

    public void hideLeftButton() {
        mLeftButton.setVisibility(View.GONE);
    }

    /**
     * @param rightButtonRID show right icon button by RID
     */
    public void showRightButton(int rightButtonRID) {
        if (mRightButtonRID != rightButtonRID) {
            mRightButtonRID = rightButtonRID;
            mRightButton.setImageDrawable(getResources().getDrawable(mRightButtonRID));
        }
        mRightButton.setVisibility(View.VISIBLE);
    }

    public void hideRightButton() {
        mRightButton.setVisibility(View.GONE);
    }

    /**
     * @param stringRID resources id for title string
     */
    public void setTitle(int stringRID) {
        mCenterTextView.setText(getResources().getString(stringRID));
    }

    /**
     * @param string resources id for title string
     */
    public void setTitle(String string) {
        mCenterTextView.setText(string);
    }
}
