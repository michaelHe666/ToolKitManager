package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/1/2020 18:20
 * copyright(c) all rights reserved by MR.M
 **/
public interface MainFairListener extends BaseFairListener{
    void hideTopBarRightButton();

    /**
     * @param drawableRID show topBar right button by drawableRID
     */
    void showTopBarRightButton(int drawableRID);

    /**
     * @param stringRID set topBar title by string RID
     */
    void setTopBarTitle(int stringRID);

    /**
     * @return intent to activity contains main views
     */
    @NonNull
    Intent getIntentToMain();

    /**
     * @return container
     */
    @NonNull
    ViewPager getMainViewPager();

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