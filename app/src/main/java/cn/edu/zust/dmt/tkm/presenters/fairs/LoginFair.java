package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;
import cn.edu.zust.dmt.tkm.interfaces.listeners.LoginFairListener;
import cn.edu.zust.dmt.tkm.models.requests.PostLoginRequestModel;
import cn.edu.zust.dmt.tkm.models.responds.BaseRespondModel;
import cn.edu.zust.dmt.tkm.models.responds.PostLoginRespondModel;
import cn.edu.zust.dmt.tkm.presenters.helpers.HttpHelper;
import cn.edu.zust.dmt.tkm.presenters.networks.BaseCallbackPost;
import cn.edu.zust.dmt.tkm.views.activities.MainActivity;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 2/3/2020 18:28
 * copyright(c) all rights reserved by MR.M
 **/
public class LoginFair {

    private LoginFairListener mCurrentListener;

    private static volatile LoginFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private LoginFair() {
    }

    public static synchronized void loadFair(@NonNull LoginFairListener loginFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new LoginFair();
        }
        INSTANCE.mCurrentListener = loginFairListener;
        INSTANCE.setSubmitButton();
    }

    /**
     * @description set submitButton OnClickListener
     */
    private void setSubmitButton() {
        mCurrentListener.getSubmitTriggerView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });
    }

    /**
     * @description start post params to login server
     */
    private void startLogin() {
        mCurrentListener.showLoadingProgress();
        String postParamsString = (new Gson()).toJson(new PostLoginRequestModel(
                mCurrentListener.getVoucherNameMyFormBar().getText().toString(),
                mCurrentListener.getVoucherTokenMyFormBar().getText().toString()));
        mCurrentListener.setBaseThreadCallback(new BaseThreadCallbackInterface() {
            @Override
            public void getThreadCallback(@NonNull Object obj) {
                BaseRespondModel baseRespondModel = parseCallbackObj(obj);
                if (baseRespondModel != null) {
                    endLogin(baseRespondModel);
                }
            }
        });
        new BaseCallbackPost(mCurrentListener.getThreadCallbackMethods(), HttpHelper.LOGIN_PATH, postParamsString)
                .startAction();
    }

    /**
     * @param baseRespondModel get respond model
     */
    private void endLogin(@NonNull BaseRespondModel baseRespondModel) {
        baseRespondModel.getDataModel(PostLoginRespondModel.class);
        mCurrentListener.showAppStyleShortToast(R.string.string_presenter_login_prompt_success);
        Bundle bundle = new Bundle();
        bundle.putString("key_target_fragment", "Home");
        mCurrentListener.getActivityStartMethods().startBaseActivity(MainActivity.class, bundle);
    }

    /**
     * @param object get callback obj
     * @return baseRespondModel parsed form object
     */
    private BaseRespondModel parseCallbackObj(Object object) {
        mCurrentListener.hideLoadingProgress();
        if (object != null) {
            BaseRespondModel baseRespondModel = (new Gson()).fromJson(object.toString(), BaseRespondModel.class);
            Object obj = baseRespondModel.getObj();
            if (obj == null) {
                String string = baseRespondModel.getError();
                if (!TextUtils.isEmpty(string)) {
                    mCurrentListener.showAppStyleShortToast(string);
                }
                return null;
            }
            return baseRespondModel;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_target_fragment", "Home");
        mCurrentListener.getActivityStartMethods().startBaseActivity(MainActivity.class, bundle);
        return null;
    }
}
