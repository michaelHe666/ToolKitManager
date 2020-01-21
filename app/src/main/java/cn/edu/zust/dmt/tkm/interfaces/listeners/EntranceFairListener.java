package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/2/2020 20:07
 * copyright(c) all rights reserved by MR.M
 **/
public interface EntranceFairListener extends BaseFairListener {

    /**
     * @return reference of RadioGroup to record use login or not
     */
    @NonNull
    RadioGroup getStateRadioGroup();

    /**
     * @return reference of RadioButton of login
     */
    @NonNull
    RadioButton getLoginButton();

    /**
     * @return reference of RadioButton of register
     */
    @NonNull
    RadioButton getRegisterButton();

    /**
     * @return reference of editText for user to input phoneNumber
     */
    @NonNull
    EditText getPhoneNumberEditText();

    /**
     * @return reference of editText for user to input password
     */
    @NonNull
    EditText getPasswordEditText();

    /**
     * @return any view which can trigger login event by onClickListener
     */
    @NonNull
    View getSubmitTriggerView();
}