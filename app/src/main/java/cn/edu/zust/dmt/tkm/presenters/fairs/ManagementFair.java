package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.views.activities.TopBarActivity;
import cn.edu.zust.dmt.tkm.interfaces.listeners.ManagementFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/2/2020 16:15
 * copyright(c) all rights reserved by MR.M
 **/
public class ManagementFair {

    private ManagementFairListener mCurrentListener;

    private static volatile ManagementFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private ManagementFair() {
        mCurrentListener = null;
    }

    public static synchronized void LoadFair(@NonNull ManagementFairListener managementFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new ManagementFair();
        }
        INSTANCE.mCurrentListener = managementFairListener;
        INSTANCE.setPurchaseButton();
    }

    private void setPurchaseButton() {
        mCurrentListener.getPurchaseTriggerView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("key_target_fragment", "Purchase");
                mCurrentListener.getActivityStartMethods().startBaseActivity(TopBarActivity.class, bundle);
            }
        });
    }
}