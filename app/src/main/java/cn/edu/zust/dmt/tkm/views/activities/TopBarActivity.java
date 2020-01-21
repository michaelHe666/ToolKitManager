package cn.edu.zust.dmt.tkm.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.TopBarFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.TopBarFair;
import cn.edu.zust.dmt.tkm.views.widgets.raw.MyTopBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.activities
 * @description $
 * @time 1/2/2020 16:00
 * copyright(c) all rights reserved by MR.M
 **/
public class TopBarActivity extends BaseActivity
        implements TopBarFairListener {

    private MyTopBar mTopBar;

    @Override
    protected void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_top_bar);
    }

    @Override
    protected void initializeMemberVariables() {
        mTopBar = findViewById(R.id.activityTopBarTopBar);
    }

    @Override
    protected void bindDataToView() {
        TopBarFair.loadFair(this);
    }

    @Override
    public void hideTopBarRightButton() {
        mTopBar.hideRightButton();
    }

    @Override
    public void showTopBarRightButton(int drawableRID) {
        mTopBar.showRightButton(drawableRID);
    }

    @Override
    public void hideTopBarLeftButton() {
        mTopBar.hideLeftButton();
    }

    @Override
    public void showTopBarLeftButton(int drawableRID) {
        mTopBar.showLeftButton(drawableRID);
    }

    @Override
    public void setTopBarTitle(int stringRID) {
        mTopBar.setTitle(stringRID);
    }

    @Override
    public void setTopBarLeftButtonListener(View.OnClickListener onClickListener) {
        mTopBar.setLeftButtonOnClickListener(onClickListener);
    }

    @Override
    public int getFragmentContainerRID() {
        return R.id.activityTopBarContainerFrameLayout;
    }

    @NonNull
    @Override
    public Intent getIntentToTopBar() {
        return this.getIntent();
    }
}
