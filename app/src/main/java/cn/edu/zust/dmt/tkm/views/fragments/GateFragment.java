package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.GateFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.GateFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 2/3/2020 19:52
 * copyright(c) all rights reserved by MR.M
 **/
public class GateFragment extends BaseFragment
        implements GateFairListener {

    private Button mLoginButton;
    private Button mRegisterButton;

    @Override
    protected final View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gate, container, false);
    }

    @Override
    protected final void initializeMemberVariables(View contentView) {
        mLoginButton = contentView.findViewById(R.id.fragmentGateLoginButton);
        mRegisterButton = contentView.findViewById(R.id.fragmentGateRegisterButton);
    }

    @Override
    protected final void bindDataToView(View contentView) {
        GateFair.loadFair(this);
    }

    @NonNull
    @Override
    public final View getLoginTriggerView() {
        return mLoginButton;
    }

    @NonNull
    @Override
    public final View getRegisterTriggerView() {
        return mRegisterButton;
    }
}
