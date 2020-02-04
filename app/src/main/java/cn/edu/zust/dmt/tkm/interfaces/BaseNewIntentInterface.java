package cn.edu.zust.dmt.tkm.interfaces;

import android.content.Intent;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces
 * @description $
 * @time 2/3/2020 20:18
 * copyright(c) all rights reserved by MR.M
 **/
public interface BaseNewIntentInterface {

    /**
     * @param intent new intent to parse
     */
    void parseNewIntent(@NonNull Intent intent);
}
