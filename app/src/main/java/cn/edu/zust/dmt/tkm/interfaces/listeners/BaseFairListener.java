package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.BaseActivityFragmentMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseActivityStartMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseNewIntentInterface;
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

    /**
     * @description show loading progress full dialog to forbid screen
     * operation
     */
    void showLoadingProgress();

    /**
     * @description hide loading progress to allow screen operation
     */
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
     * @param view target view to extend top to screen-top
     */
    void setImmersiveTopView(@NonNull View view);

    /**
     * @param baseThreadCallback callback method provider
     */
    void setBaseThreadCallback(@NonNull BaseThreadCallbackInterface baseThreadCallback);

    /**
     * @param baseNewIntentInterface store methods for new intent
     */
    void setNewIntentMethods(@NonNull BaseNewIntentInterface baseNewIntentInterface);

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