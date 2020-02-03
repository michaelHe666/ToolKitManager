package cn.edu.zust.dmt.tkm.presenters.fairs;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.interfaces.listeners.EntranceFairListener;
import cn.edu.zust.dmt.tkm.views.fragments.LoginFragment;

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
        INSTANCE.loadLoginFragment();
        //todo:执行INSTANCE.mCurrentListener=null后startLogin抛出空指针异常
    }

    private void loadLoginFragment(){
        mCurrentListener.getFragmentManagerMethods().getMyFragmentManager()
                .beginTransaction()
                .replace(mCurrentListener.getFragmentContainer().getId(),new LoginFragment())
                .commit();
    }
}