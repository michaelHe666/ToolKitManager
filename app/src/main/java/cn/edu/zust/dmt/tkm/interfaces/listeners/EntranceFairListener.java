package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.BaseNewIntentInterface;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyTopBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/2/2020 20:07
 * copyright(c) all rights reserved by MR.M
 **/
public interface EntranceFairListener extends BaseFairListener {

    /**
     * @return get intent from activity
     */
    @NonNull
    Intent getIntentToEntrance();

    /**
     * @return viewGroup as fragment container
     */
    @NonNull
    ViewGroup getFragmentContainer();
}