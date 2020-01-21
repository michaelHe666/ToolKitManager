package cn.edu.zust.dmt.tkm.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MainFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.MainFair;
import cn.edu.zust.dmt.tkm.views.widgets.raw.MyTopBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.activities
 * @description $
 * @time 1/2/2020 10:29
 * copyright(c) all rights reserved by MR.M
 **/
public class MainActivity extends BaseActivity
        implements MainFairListener {

    private MyTopBar mMyTopBar;
    private ViewPager mViewPager;
    private ImageButton mHomeButton;
    private ImageButton mManagementButton;
    private ImageButton mMessageButton;
    private ImageButton mSettingsButton;

    @Override
    protected void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initializeMemberVariables() {
        mMyTopBar = findViewById(R.id.activityMainMyTopBar);
        mViewPager = findViewById(R.id.activityMainContainerViewPager);
        mHomeButton = findViewById(R.id.activityMainHomeImageButton);
        mManagementButton = findViewById(R.id.activityMainManagementImageButton);
        mMessageButton = findViewById(R.id.activityMainMessageImageButton);
        mSettingsButton = findViewById(R.id.activityMainSettingsImageButton);
    }

    @Override
    protected void bindDataToView() {
        MainFair.loadFair(this);
    }

    @Override
    public void hideTopBarRightButton() {
        mMyTopBar.hideRightButton();
    }

    /**
     * @param drawableRID show topBar right button by drawableRID
     */
    @Override
    public void showTopBarRightButton(int drawableRID) {
        mMyTopBar.showRightButton(drawableRID);
    }

    /**
     * @param stringRID set topBar title by string RID
     */
    @Override
    public void setTopBarTitle(int stringRID) {
        mMyTopBar.setTitle(stringRID);
    }

    @NotNull
    @Override
    public Intent getIntentToMain() {
        return this.getIntent();
    }

    @NotNull
    @Override
    public ViewPager getMainViewPager() {
        return mViewPager;
    }

    @NonNull
    @Override
    public View getHomeTriggerView() {
        return mHomeButton;
    }

    @NonNull
    @Override
    public View getManagementTriggerView() {
        return mManagementButton;
    }

    @NonNull
    @Override
    public View getMessageTriggerView() {
        return mMessageButton;
    }

    @NonNull
    @Override
    public View getSettingsTriggerView() {
        return mSettingsButton;
    }
}