package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.listeners.GateFairListener;
import cn.edu.zust.dmt.tkm.views.activities.EntranceActivity;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 2/3/2020 19:59
 * copyright(c) all rights reserved by MR.M
 **/
public class GateFair {

    private GateFairListener mCurrentListener;
    private static volatile GateFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private GateFair() {
    }

    /**
     * @param gateFairListener object to load baseFair to view
     */
    public static synchronized void loadFair(@NonNull GateFairListener gateFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new GateFair();
        }
        INSTANCE.mCurrentListener = gateFairListener;
        INSTANCE.setLoginTriggerView();
        INSTANCE.setRegisterTriggerView();
    }

    private void setLoginTriggerView() {
        mCurrentListener.getLoginTriggerView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("target", "login");
                mCurrentListener.getActivityStartMethods().startBaseActivity(
                        EntranceActivity.class, bundle
                );
            }
        });
    }

    private void setRegisterTriggerView() {
        mCurrentListener.getRegisterTriggerView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("target", "register");
                mCurrentListener.getActivityStartMethods().startBaseActivity(
                        EntranceActivity.class, bundle
                );
            }
        });
    }
}
