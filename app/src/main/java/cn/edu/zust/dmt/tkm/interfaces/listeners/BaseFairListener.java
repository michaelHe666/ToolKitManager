package cn.edu.zust.dmt.tkm.interfaces.listeners;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.BaseActivityFragmentMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseActivityStartMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 12/31/2019 14:49
 * copyright(c) all rights reserved by MR.M
 **/
public interface BaseFairListener {

    void showLoadingProgress();

    void hideLoadingProgress();

    /**
     * @param stringRId toast text rid
     */
    void showAppStyleShortToast(int stringRId);

    /**
     * @param message toast text
     */
    void showAppStyleShortToast(@NonNull String message);

    /**
     * @description catch basic failure and make toast
     */
    void catchBasicFailure(int returnCode, @NonNull String prompt);

    /**
     * @param baseThreadCallback callback method provider
     */
    void setBaseThreadCallback(BaseThreadCallbackInterface baseThreadCallback);

    /**
     * @return interface transfer activity start method
     */
    @NonNull
    BaseActivityStartMethodsInterface getActivityStartMethods();

    /**
     * @return interface transfer fragment manager
     */
    @NonNull
    BaseActivityFragmentMethodsInterface getFragmentManagerMethods();

    /**
     * @return interface transfer callback method
     */
    @NonNull
    BaseThreadCallbackInterface getThreadCallbackMethods();
}