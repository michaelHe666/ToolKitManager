package cn.edu.zust.dmt.tkm.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import org.jetbrains.annotations.NotNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MainFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.MainFair;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyTopBar;

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

    private MyTopBar mTopBar;
    private ViewPager2 mViewPager2;
    private ImageButton mHomeButton;
    private ImageButton mManagementButton;
    private ImageButton mMessageButton;
    private ImageButton mSettingsButton;

    @Override
    protected final void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected final void initializeMemberVariables() {
        mTopBar = findViewById(R.id.activityMainMyTopBar);
        mViewPager2 = findViewById(R.id.activityMainContainerViewPager2);
        mHomeButton = findViewById(R.id.activityMainHomeImageButton);
        mManagementButton = findViewById(R.id.activityMainManagementImageButton);
        mMessageButton = findViewById(R.id.activityMainMessageImageButton);
        mSettingsButton = findViewById(R.id.activityMainSettingsImageButton);
    }

    @Override
    protected final void bindDataToView() {
        MainFair.loadFair(this);
    }

    @NonNull
    @Override
    public MyTopBar getMyTopBar() {
        return mTopBar;
    }

    @NotNull
    @Override
    public final Intent getIntentToMain() {
        return this.getIntent();
    }

    @NotNull
    @Override
    public final ViewPager2 getMainViewPager2() {
        return mViewPager2;
    }

    @NonNull
    @Override
    public final View getHomeTriggerView() {
        return mHomeButton;
    }

    @NonNull
    @Override
    public final View getManagementTriggerView() {
        return mManagementButton;
    }

    @NonNull
    @Override
    public final View getMessageTriggerView() {
        return mMessageButton;
    }

    @NonNull
    @Override
    public final View getSettingsTriggerView() {
        return mSettingsButton;
    }
}