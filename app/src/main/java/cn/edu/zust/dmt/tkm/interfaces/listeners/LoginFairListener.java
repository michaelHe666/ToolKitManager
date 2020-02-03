package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 2/3/2020 18:29
 * copyright(c) all rights reserved by MR.M
 **/
public interface LoginFairListener extends BaseFairListener {

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

    /**
     * @return any view which can trigger find-password event
     *         by onClickListener
     */
    @NonNull
    View getFindPasswordTriggerView();
}
