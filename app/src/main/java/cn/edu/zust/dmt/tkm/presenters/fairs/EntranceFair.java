package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.BaseThreadCallbackInterface;
import cn.edu.zust.dmt.tkm.models.responds.BaseRespondModel;
import cn.edu.zust.dmt.tkm.models.responds.PostLoginRespondModel;
import cn.edu.zust.dmt.tkm.models.responds.PostRegisterRespondModel;
import cn.edu.zust.dmt.tkm.presenters.helpers.HttpHelper;
import cn.edu.zust.dmt.tkm.views.activities.MainActivity;
import cn.edu.zust.dmt.tkm.interfaces.listeners.EntranceFairListener;
import cn.edu.zust.dmt.tkm.models.requests.PostLoginRequestModel;
import cn.edu.zust.dmt.tkm.presenters.networks.BaseCallbackPost;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description user singleton-pattern
 * @time 1/2/2020 20:09
 * copyright(c) all rights reserved by MR.M
 **/
public class EntranceFair {

    private static volatile EntranceFair INSTANCE = null;

    private EntranceFairListener mCurrentListener;

    /**
     * @description forbidden create class by new
     */
    private EntranceFair() {
        mCurrentListener = null;
    }

    //todo:效率提高问题
    public static synchronized void loadFair(@NonNull EntranceFairListener entranceFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new EntranceFair();
        }
        //todo:INSTANCE副本调用接口空指针异常，静态方法内局部变量副本持有方法？
        INSTANCE.mCurrentListener = entranceFairListener;
        INSTANCE.setEntranceRadioGroup();
        INSTANCE.setSubmitButton();
        //todo:执行INSTANCE.mCurrentListener=null后startLogin抛出空指针异常
    }

    /**
     * @description set radioGroup to control whether login or register
     */
    private void setEntranceRadioGroup() {
        final RadioGroup radioGroup = mCurrentListener.getStateRadioGroup();
        final int loginButtonRID = mCurrentListener.getLoginButton().getId();
        final int registerButtonRID = mCurrentListener.getRegisterButton().getId();
        final View mSubmitView = mCurrentListener.getSubmitTriggerView();
        radioGroup.check(loginButtonRID);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == loginButtonRID) {
                    mSubmitView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startLogin();
                        }
                    });
                } else if (checkedId == registerButtonRID) {
                    mSubmitView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startRegister();
                        }
                    });
                }
            }
        });
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
                mCurrentListener.getPhoneNumberEditText().getText().toString(),
                mCurrentListener.getPasswordEditText().getText().toString()));
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
     * @description start post params to register server
     */
    private void startRegister() {
        mCurrentListener.showLoadingProgress();
        String postParamsString = (new Gson()).toJson(new PostLoginRequestModel(
                mCurrentListener.getPhoneNumberEditText().getText().toString(),
                mCurrentListener.getPasswordEditText().getText().toString()));
        mCurrentListener.setBaseThreadCallback(new BaseThreadCallbackInterface() {
            @Override
            public void getThreadCallback(@NonNull Object obj) {
                BaseRespondModel baseRespondModel = parseCallbackObj(obj);
                if (baseRespondModel != null) {
                    endRegister(baseRespondModel);
                }
            }
        });
        new BaseCallbackPost(mCurrentListener.getThreadCallbackMethods(), HttpHelper.REGISTER_PATH, postParamsString)
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
     * @param baseRespondModel get respond model
     */
    private void endRegister(@NonNull BaseRespondModel baseRespondModel) {
        baseRespondModel.getDataModel(PostRegisterRespondModel.class);
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