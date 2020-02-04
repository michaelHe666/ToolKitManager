package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.views.widgets.combined.MyFormBar;

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
    MyFormBar getVoucherNameMyFormBar();

    /**
     * @return reference of editText for user to input password
     */
    @NonNull
    MyFormBar getVoucherTokenMyFormBar();

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
    View getFindVoucherTriggerView();
}
