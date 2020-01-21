package cn.edu.zust.dmt.tkm.presenters.fairs;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.listeners.PurchaseFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/2/2020 16:08
 * copyright(c) all rights reserved by MR.M
 **/
public class PurchaseFair {

    private PurchaseFairListener mCurrentListener;

    private static volatile PurchaseFair INSTANCE = null;

    private PurchaseFair() {
        this.mCurrentListener = null;
    }

    public static synchronized void loadFair(@NonNull PurchaseFairListener purchaseFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new PurchaseFair();
        }
        INSTANCE.mCurrentListener = purchaseFairListener;
    }
}