package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.view.View;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.views.activities.EntranceActivity;
import cn.edu.zust.dmt.tkm.interfaces.listeners.SettingsFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/2/2020 13:58
 * copyright(c) all rights reserved by MR.M
 **/
public class SettingsFair {

    private SettingsFairListener mCurrentListener;

    private static volatile SettingsFair INSTANCE = null;

    private SettingsFair() {
        this.mCurrentListener = null;
    }

    public static synchronized void loadFair(@NonNull SettingsFairListener settingsFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new SettingsFair();
        }
        INSTANCE.mCurrentListener = settingsFairListener;
        INSTANCE.setAccountSettingsButton();
    }

    private void setAccountSettingsButton() {
        mCurrentListener.getAccountSettingTriggerView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentListener.getActivityStartMethods().startBaseActivity(EntranceActivity.class);
            }
        });
    }
}