package cn.edu.zust.dmt.tkm.views.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import org.jetbrains.annotations.NotNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.BaseActivityFragmentMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseActivityStartMethodsInterface;
import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;
import cn.edu.zust.dmt.tkm.presenters.helpers.ToastHelper;
import cn.edu.zust.dmt.tkm.interfaces.listeners.BaseFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.BaseFair;
import cn.edu.zust.dmt.tkm.presenters.tools.BaseActivityStackManager;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.activities
 * @description base view for v in MVP-pattern
 * @time 12/31/2019 14:32
 * copyright(c) all rights reserved by MR.M
 **/
public abstract class BaseActivity extends AppCompatActivity
        implements BaseActivityStartMethodsInterface,
        BaseActivityFragmentMethodsInterface,
        BaseFairListener {

    /**
     * @description processing dialog
     */
    private AlertDialog mProgressDialog;

    /**
     * @description helper to show toasts in different styles
     */
    protected final ToastHelper mToastHelper = ToastHelper.getInstance();

    /**
     * @description store callback method
     */
    protected BaseThreadCallbackInterface mBaseThreadCallbackInterface;

    /**
     * @description activity initializer
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo:get activityManager apart
        BaseActivityStackManager.addBaseActivity(this);

        //todo:add base fair
        BaseFair.loadFair(this);

        //set screen orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        loadActivityView(savedInstanceState);
        initializeMemberVariables();
        bindDataToView();
    }

    /**
     * @description remove activity from manager
     */
    @Override
    protected void onDestroy() {
        //todo:get activityManager apart
        BaseActivityStackManager.finishBaseActivity(this);
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //todo:get activityManager apart
            BaseActivityStackManager.finishBaseActivity(this);
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * @param targetActivityClass target activity
     */
    @Override
    public final void startBaseActivity(@NotNull Class<? extends BaseActivity> targetActivityClass) {
        this.startActivity(new Intent(this, targetActivityClass));
    }

    /**
     * @param targetActivityClass target activity
     * @param bundle              data to target activity
     */
    @Override
    public final void startBaseActivity(@NotNull Class<? extends BaseActivity> targetActivityClass, @NotNull Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        intent.putExtras(bundle);
        this.startActivity(intent);
    }

    /**
     * @param intent for activity to start to
     */
    @Override
    public final void startBaseActivity(@NotNull Intent intent) {
        this.startActivity(intent);
    }

    @NotNull
    @Override
    public final FragmentManager getMyFragmentManager() {
        return getSupportFragmentManager();
    }

    /**
     * @description set new processing dialog view if not exist
     */
    @Override
    public final void showLoadingProgress() {
        if (mProgressDialog == null) {
            mProgressDialog = new AlertDialog.Builder(this)
                    .setView(R.layout.activity_base_dialog_progressing)
                    .setCancelable(false)
                    .create();
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();

            if (mProgressDialog.getWindow() != null) {
                WindowManager.LayoutParams layoutParams = mProgressDialog.getWindow().getAttributes();
                layoutParams.gravity = Gravity.CENTER;
                mProgressDialog.getWindow().setAttributes(layoutParams);
            }
        }
    }

    /**
     * @description hide processing dialog view if exist
     */
    @Override
    public final void hideLoadingProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * @param message toast text
     */
    @Override
    public final void showAppStyleShortToast(@NotNull String message) {
        mToastHelper.showAppStyleShortToast(message, this);
    }

    /**
     * @param stringRId toast text rid
     */
    @Override
    public final void showAppStyleShortToast(int stringRId) {
        mToastHelper.showAppStyleShortToast(stringRId, this);
    }

    /**
     * @param returnCode error code get
     * @param prompt     error message get
     * @description set new error view
     */
    @Override
    public void catchBasicFailure(int returnCode, @NotNull String prompt) {
        if (!TextUtils.isEmpty(prompt)) {
            mToastHelper.showAppStyleShortToast(returnCode + prompt, this);
        }
    }

    /**
     * @param baseThreadCallback callback method provider
     */
    @Override
    public void setBaseThreadCallback(BaseThreadCallbackInterface baseThreadCallback) {
        this.mBaseThreadCallbackInterface = baseThreadCallback;
    }

    @NonNull
    @Override
    public final BaseActivityStartMethodsInterface getActivityStartMethods() {
        return this;
    }

    @NonNull
    @Override
    public final BaseActivityFragmentMethodsInterface getFragmentManagerMethods() {
        return this;
    }

    @NonNull
    @Override
    public final BaseThreadCallbackInterface getThreadCallbackMethods() {
        return this.mBaseThreadCallbackInterface;
    }

    /**
     * @param savedInstanceState get the bundle from activity onCreate
     * @description initialize activity view to window
     */
    protected abstract void loadActivityView(Bundle savedInstanceState);

    /**
     * @description initialize activity member variables
     */
    protected abstract void initializeMemberVariables();

    /**
     * @description initialize data to activity view
     */
    protected abstract void bindDataToView();
}