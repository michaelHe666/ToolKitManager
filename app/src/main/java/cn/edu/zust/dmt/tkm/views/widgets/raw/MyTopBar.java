package cn.edu.zust.dmt.tkm.views.widgets.raw;

import android.content.Context;
import android.content.res.TypedArray;
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
    private String mTitleString;
    private int mRightButtonRID;
    private Boolean isRightButtonShown;
    private int mLeftButtonRID;
    private Boolean isLeftButtonShown;

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
        mTitleString = typedArray.getString(R.styleable.MyTopBar_title);
        mLeftButtonRID = typedArray.getResourceId(R.styleable.MyTopBar_leftIcon, 0);
        isLeftButtonShown = typedArray.getBoolean(R.styleable.MyTopBar_showLeftIcon, false);
        mRightButtonRID = typedArray.getResourceId(R.styleable.MyTopBar_rightIcon, 0);
        isRightButtonShown = typedArray.getBoolean(R.styleable.MyTopBar_showRightIcon, false);

        if (!isRightButtonShown) {
            mRightButton.setVisibility(View.GONE);
        } else {
            mRightButton.setImageDrawable(getResources().getDrawable(mRightButtonRID));
        }

        if (!isLeftButtonShown) {
            mLeftButton.setVisibility(View.GONE);
        } else {
            mRightButton.setImageDrawable(getResources().getDrawable(mLeftButtonRID));
        }

        mCenterTextView.setText(mTitleString);
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

    public void setTitle(int stringRID) {
        mCenterTextView.setText(getResources().getString(stringRID));
    }
}
