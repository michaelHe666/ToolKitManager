package cn.edu.zust.dmt.tkm.interfaces;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces
 * @description $
 * @time 1/17/2020 13:46
 * copyright(c) all rights reserved by MR.M
 **/
public interface BaseActivityFragmentMethodsInterface {
    /**
     * @return get fragmentManager from baseActivity
     */
    @NonNull
    FragmentManager getMyFragmentManager();
}