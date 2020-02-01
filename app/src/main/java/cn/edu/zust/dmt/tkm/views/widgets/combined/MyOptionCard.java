package cn.edu.zust.dmt.tkm.views.widgets.combined;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views
 * @description $
 * @time 1/2/2020 8:29
 * copyright(c) all rights reserved by MR.M
 **/
public class MyOptionCard extends ConstraintLayout {

    /**
     * @description member views
     */
    private CardView mCardView;
    private ImageView mImageView;
    private TextView mTextView;

    /**
     * @description attributes
     */
    private float mCornerRadius;
    private String mTitleString;
    private int mIconRID;
    private int mBackgroundColorRID;

    public MyOptionCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        bindViews(context);
        initializeViews(context, attrs);
    }

    /**
     * @description bind child views to class member variables
     */
    private void bindViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.views_my_option_card, this);
        mCardView = view.findViewById(R.id.viewsMyOptionCardCardView);
        mImageView = view.findViewById(R.id.viewsMyOptionCardImageView);
        mTextView = view.findViewById(R.id.viewsMyOptionCardTextView);
    }

    /**
     * @description initialize MyOptionCard
     */
    private void initializeViews(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyOptionCard);
        mTitleString = typedArray.getString(R.styleable.MyOptionCard_myOptionCardTitle);
        mCornerRadius = typedArray.getDimension(R.styleable.MyOptionCard_myOptionCardCornerRadius, 0);
        mIconRID = typedArray.getResourceId(R.styleable.MyOptionCard_myOptionCardIcon, 0);
        mBackgroundColorRID = typedArray.getResourceId(R.styleable.MyOptionCard_myOptionCardBackgroundColor, 0);

        if (mIconRID != 0) {
            mImageView.setImageDrawable(getResources().getDrawable(mIconRID));
        }

        if (mBackgroundColorRID != 0) {
            mCardView.setCardBackgroundColor(getResources().getColor(mBackgroundColorRID));
        }

        mCardView.setRadius(mCornerRadius);

        mTextView.setText(mTitleString);
        typedArray.recycle();
    }

}
