package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import cn.edu.zust.dmt.tkm.views.widgets.combined.MyTopBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/1/2020 18:20
 * copyright(c) all rights reserved by MR.M
 **/
public interface MainFairListener extends BaseFairListener {
    @NonNull
    MyTopBar getMyTopBar();

    /**
     * @return intent to activity contains main views
     */
    @NonNull
    Intent getIntentToMain();

    /**
     * @return container
     */
    @NonNull
    ViewPager2 getMainViewPager2();

    /**
     * @return any view which can trigger home event by onClickListener
     */
    @NonNull
    View getHomeTriggerView();

    /**
     * @return any view which can trigger management event by onClickListener
     */
    @NonNull
    View getManagementTriggerView();

    /**
     * @return any view which can trigger message event by onClickListener
     */
    @NonNull
    View getMessageTriggerView();

    /**
     * @return any view which can trigger settings event by onClickListener
     */
    @NonNull
    View getSettingsTriggerView();
}