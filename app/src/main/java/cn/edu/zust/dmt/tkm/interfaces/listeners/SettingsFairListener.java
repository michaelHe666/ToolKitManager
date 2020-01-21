package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/2/2020 14:41
 * copyright(c) all rights reserved by MR.M
 **/
public interface SettingsFairListener extends BaseFairListener{
    /**
     * @return any view which can trigger accountSettings event by
     *  onClickListener
     */
    @NonNull
    View getAccountSettingTriggerView();
}
