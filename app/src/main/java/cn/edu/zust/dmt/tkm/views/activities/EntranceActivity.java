package cn.edu.zust.dmt.tkm.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.EntranceFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.EntranceFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.activities
 * @description $
 * @time 1/2/2020 13:29
 * copyright(c) all rights reserved by MR.M
 **/
public class EntranceActivity extends BaseActivity
        implements EntranceFairListener {

    /**
     * @description radio group to record whether use login or register
     * method
     */
    private RadioGroup mStateRadioGroup;
    private RadioButton mLoginButton;
    private RadioButton mRegisterButton;

    private EditText mPhoneNumberEditText;
    private EditText mPasswordEditText;
    private Button mSubmitButton;

    /**
     * @param savedInstanceState get the bundle from activity onCreate
     */
    @Override
    protected void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_entrance);
    }

    @Override
    protected void initializeMemberVariables() {
        mStateRadioGroup = findViewById(R.id.activityLoginStateRadioGroup);
        mLoginButton = findViewById(R.id.activityLoginLoginRadioButton);
        mRegisterButton = findViewById(R.id.activityLoginRegisterRadioButton);
        mPhoneNumberEditText = findViewById(R.id.activityLoginPhoneNumberEditText);
        mPasswordEditText = findViewById(R.id.activityLoginPasswordEditText);
        mSubmitButton = findViewById(R.id.activityLoginSubmitButton);
    }

    @Override
    protected void bindDataToView() {
        EntranceFair.loadFair(this);
    }

    @NonNull
    @Override
    public RadioGroup getStateRadioGroup() {
        return mStateRadioGroup;
    }

    @NonNull
    @Override
    public RadioButton getLoginButton() {
        return mLoginButton;
    }

    @NonNull
    @Override
    public RadioButton getRegisterButton() {
        return mRegisterButton;
    }

    @NonNull
    @Override
    public EditText getPhoneNumberEditText() {
        return mPhoneNumberEditText;
    }

    @NonNull
    @Override
    public EditText getPasswordEditText() {
        return mPasswordEditText;
    }

    @NonNull
    @Override
    public View getSubmitTriggerView() {
        return mSubmitButton;
    }
}