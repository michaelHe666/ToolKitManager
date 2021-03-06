package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.content.Intent;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.BaseNewIntentInterface;
import cn.edu.zust.dmt.tkm.interfaces.listeners.EntranceFairListener;
import cn.edu.zust.dmt.tkm.views.fragments.FindVoucherFragment;
import cn.edu.zust.dmt.tkm.views.fragments.GateFragment;
import cn.edu.zust.dmt.tkm.views.fragments.LoginFragment;
import cn.edu.zust.dmt.tkm.views.fragments.RegisterFragment;

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
        //todo:INSTANCE副本调用接口空指针异常，静态方法内INSTANCE副本是否持有方法？
        INSTANCE.mCurrentListener = entranceFairListener;
        INSTANCE.parseIntent();
        INSTANCE.setNewIntentMethods();
        //todo:执行INSTANCE.mCurrentListener=null后startLogin抛出空指针异常
    }

    /**
     * @description parse intent to activity onCreate
     */
    private void parseIntent() {
        Intent intent = mCurrentListener.getIntentToEntrance();
        if (intent.getAction() != null) {
            if (intent.getAction().equals(Intent.ACTION_MAIN)) {
                loadGateFragment();
            }
        }
    }

    /**
     * @description set activity methods of parsing new intent
     */
    private void setNewIntentMethods() {
        mCurrentListener.setNewIntentMethods(new BaseNewIntentInterface() {
            @Override
            public void parseNewIntent(@NonNull Intent intent) {
                if (intent.getStringExtra("target") != null) {
                    String string = intent.getStringExtra("target");
                    switch (string){
                        case "login":
                            loadLoginFragment();
                            break;
                        case "register":
                            loadRegisterFragment();
                            break;
                        case "findVoucher":
                            loadFindVoucherFragment();
                            break;
                    }
                }
            }
        });
    }

    /**
     * @description load gateFragment to container
     */
    private void loadGateFragment() {
        mCurrentListener.getFragmentManagerMethods().getMyFragmentManager()
                .beginTransaction()
                .replace(mCurrentListener.getFragmentContainer().getId(), new GateFragment())
                .commit();
    }

    /**
     * @description load loginFragment to container
     */
    private void loadLoginFragment() {
        mCurrentListener.getFragmentManagerMethods().getMyFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.right_screen_in, R.anim.left_screen_out
                )
                .replace(mCurrentListener.getFragmentContainer().getId(), new LoginFragment())
                .commit();
    }

    /**
     * @description load registerFragment to container
     */
    private void loadRegisterFragment() {
        mCurrentListener.getFragmentManagerMethods().getMyFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.right_screen_in, R.anim.left_screen_out
                )
                .replace(mCurrentListener.getFragmentContainer().getId(), new RegisterFragment())
                .commit();
    }

    /**
     * @description load findVoucherFragment to container
     */
    private void loadFindVoucherFragment() {
        mCurrentListener.getFragmentManagerMethods().getMyFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.right_screen_in, R.anim.left_screen_out
                )
                .replace(mCurrentListener.getFragmentContainer().getId(), new FindVoucherFragment())
                .commit();
    }
}