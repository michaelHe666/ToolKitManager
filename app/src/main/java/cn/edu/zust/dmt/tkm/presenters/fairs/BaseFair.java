package cn.edu.zust.dmt.tkm.presenters.fairs;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.listeners.BaseFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description use singleton-pattern
 * @time 1/1/2020 16:48
 * copyright(c) all rights reserved by MR.M
 **/
public class BaseFair {

    //todo:change to list to allow concurrence
    private BaseFairListener mCurrentListener;

    private static volatile BaseFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private BaseFair() {
        mCurrentListener = null;
    }

    /**
     * @param baseFairListener object to load baseFair to view
     */
    public static synchronized void loadFair(@NonNull BaseFairListener baseFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new BaseFair();
        }
        INSTANCE.mCurrentListener = baseFairListener;
    }
}