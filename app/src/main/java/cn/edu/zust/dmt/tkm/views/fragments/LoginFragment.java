package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.LoginFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.LoginFair;

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

    private EditText mPhoneNumberEditText;
    private EditText mPasswordEditText;
    private Button mSubmitButton;
    private Button mFindPasswordButton;

    @Override
    protected final View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    protected final void initializeMemberVariables(View contentView) {
        mPhoneNumberEditText = contentView.findViewById(R.id.fragmentLoginPhoneNumberEditText);
        mPasswordEditText = contentView.findViewById(R.id.fragmentLoginPasswordEditText);
        mSubmitButton = contentView.findViewById(R.id.fragmentLoginSubmitButton);
        mFindPasswordButton = contentView.findViewById(R.id.fragmentLoginFindPasswordButton);
    }

    @Override
    protected final void bindDataToView(View contentView) {
        LoginFair.loadFair(this);
    }

    @NonNull
    @Override
    public final EditText getPhoneNumberEditText() {
        return mPhoneNumberEditText;
    }

    @NonNull
    @Override
    public final EditText getPasswordEditText() {
        return mPasswordEditText;
    }

    @NonNull
    @Override
    public final View getSubmitTriggerView() {
        return mSubmitButton;
    }

    @NonNull
    @Override
    public final View getFindPasswordTriggerView() {
        return mFindPasswordButton;
    }
}
