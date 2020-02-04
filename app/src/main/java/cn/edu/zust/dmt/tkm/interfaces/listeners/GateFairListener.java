package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 2/3/2020 19:55
 * copyright(c) all rights reserved by MR.M
 **/
public interface GateFairListener extends BaseFairListener {
    /**
     * @return any view which can trigger login event by onClickListener
     */
    @NonNull
    View getLoginTriggerView();

    /**
     * @return any view which can trigger register event by onClickListener
     */
    @NonNull
    View getRegisterTriggerView();
}
