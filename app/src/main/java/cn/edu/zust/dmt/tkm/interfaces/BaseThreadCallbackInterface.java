package cn.edu.zust.dmt.tkm.interfaces;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces
 * @description $
 * @time 1/14/2020 15:51
 * copyright(c) all rights reserved by MR.M
 **/
public interface BaseThreadCallbackInterface {
    /**
     * @param obj obj returned by holder
     */
    void getThreadCallback(@NonNull Object obj);
}