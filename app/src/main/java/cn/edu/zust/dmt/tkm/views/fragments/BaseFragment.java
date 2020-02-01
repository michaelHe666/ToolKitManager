package cn.edu.zust.dmt.tkm.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import cn.edu.zust.dmt.tkm.interfaces.BaseActivityFragmentMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseActivityStartMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;
import cn.edu.zust.dmt.tkm.views.activities.BaseActivity;
import cn.edu.zust.dmt.tkm.interfaces.listeners.BaseFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/1/2020 16:43
 * copyright(c) all rights reserved by MR.M
 **/
public abstract class BaseFragment extends Fragment
        implements BaseFairListener {

    private BaseActivity myParentActivity;

    private BaseThreadCallbackInterface mBaseThreadCallbackInterface;

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        myParentActivity = (BaseActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LoadFragmentView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeMemberVariables(view);
        bindDataToView(view);
    }

    @Override
    public void onDestroy() {
        myParentActivity = null;
        super.onDestroy();
    }

    @Override
    public final void showLoadingProgress() {
        myParentActivity.showLoadingProgress();
    }

    @Override
    public final void hideLoadingProgress() {
        myParentActivity.hideLoadingProgress();
    }

    /**
     * @param stringRId toast text rid
     */
    @Override
    public final void showAppStyleShortToast(int stringRId) {
        myParentActivity.showAppStyleShortToast(stringRId);
    }

    /**
     * @param message toast text
     */
    @Override
    public final void showAppStyleShortToast(@NotNull String message) {
        myParentActivity.showAppStyleShortToast(message);
    }

    /**
     * @param returnCode error code get
     * @param prompt     error message get
     * @description set new error view
     */
    @Override
    public void catchBasicFailure(int returnCode, @NotNull String prompt) {
        myParentActivity.catchBasicFailure(returnCode, prompt);
    }

    @Override
    public final void setBaseThreadCallback(BaseThreadCallbackInterface baseThreadCallback) {
        this.mBaseThreadCallbackInterface = baseThreadCallback;
    }

    @NonNull
    @Override
    public final BaseActivityStartMethodsInterface getActivityStartMethods() {
        return myParentActivity.getActivityStartMethods();
    }

    @NonNull
    @Override
    public final BaseActivityFragmentMethodsInterface getFragmentManagerMethods() {
        return myParentActivity.getFragmentManagerMethods();
    }

    @NonNull
    @Override
    public final BaseThreadCallbackInterface getThreadCallbackMethods() {
        return this.mBaseThreadCallbackInterface;
    }

    public final BaseActivity getParentActivity() {
        return myParentActivity;
    }

    protected abstract View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initializeMemberVariables(View contentView);

    protected abstract void bindDataToView(View contentView);
}