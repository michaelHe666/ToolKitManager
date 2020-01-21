package cn.edu.zust.dmt.tkm.interfaces.listeners;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/3/2020 8:36
 * copyright(c) all rights reserved by MR.M
 **/
public interface HomeFairListener extends BaseFairListener{
    /**
     * @return a recyclerView for show toolKit list
     */
    @NonNull
    RecyclerView getToolKitRecyclerView();
}
