package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.LoginFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.LoginFair;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyFormBar;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyTopBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 2/3/2020 18:47
 * copyright(c) all rights reserved by MR.M
 **/
public class LoginFragment extends BaseFragment
        implements LoginFairListener {

    private MyTopBar mTopBar;
    private MyFormBar mVoucherNameEditText;
    private MyFormBar mVoucherTokenEditText;
    private Button mSubmitButton;
    private Button mFindVoucherButton;

    @Override
    protected final View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected final void initializeMemberVariables(View contentView) {
        mTopBar = contentView.findViewById(R.id.fragmentLoginMyTopBar);
        mVoucherNameEditText = contentView.findViewById(R.id.fragmentLoginVoucherNameMyFormBar);
        mVoucherTokenEditText = contentView.findViewById(R.id.fragmentLoginVoucherTokenMyFormBar);
        mSubmitButton = contentView.findViewById(R.id.fragmentLoginSubmitButton);
        mFindVoucherButton = contentView.findViewById(R.id.fragmentLoginFindVoucherButton);
    }

    @Override
    protected final void bindDataToView(View contentView) {
        LoginFair.loadFair(this);
    }

    @NonNull
    @Override
    public final View getImmersiveTopView() {
        return mTopBar;
    }

    @NonNull
    @Override
    public final MyFormBar getVoucherNameMyFormBar() {
        return mVoucherNameEditText;
    }

    @NonNull
    @Override
    public final MyFormBar getVoucherTokenMyFormBar() {
        return mVoucherTokenEditText;
    }

    @NonNull
    @Override
    public final View getSubmitTriggerView() {
        return mSubmitButton;
    }

    @NonNull
    @Override
    public final View getFindVoucherTriggerView() {
        return mFindVoucherButton;
    }
}
