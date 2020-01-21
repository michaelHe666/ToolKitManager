package cn.edu.zust.dmt.tkm.interfaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.views.activities.BaseActivity;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces
 * @description $
 * @time 1/17/2020 10:15
 * copyright(c) all rights reserved by MR.M
 **/
public interface BaseActivityStartMethodsInterface {
    /**
     * @param targetActivityClass target activity
     * @description simple turn to baseActivityClass
     */
    void startBaseActivity(@NonNull Class<? extends BaseActivity> targetActivityClass);

    /**
     * @param targetActivityClass target activity
     * @param bundle data to target activity
     * @description turn to baseActivityClass with bundle
     */
    void startBaseActivity(@NonNull Class<? extends BaseActivity> targetActivityClass, @NonNull Bundle bundle);

    /**
     * @param intent for activity to start to
     * @description open intent so you can define all behaviors
     */
    void startBaseActivity(@NonNull Intent intent);
}