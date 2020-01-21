package cn.edu.zust.dmt.tkm.interfaces.listeners;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.interfaces.listeners
 * @description $
 * @time 1/2/2020 18:04
 * copyright(c) all rights reserved by MR.M
 **/
public interface TopBarFairListener extends BaseFairListener {

    void hideTopBarRightButton();

    /**
     * @param drawableRID show topBar right button by drawableRID
     */
    void showTopBarRightButton(int drawableRID);

    void hideTopBarLeftButton();

    /**
     * @param drawableRID show topBar left button by drawableRID
     */
    void showTopBarLeftButton(int drawableRID);

    /**
     * @param stringRID set topBar title by string RID
     */
    void setTopBarTitle(int stringRID);

    void setTopBarLeftButtonListener(View.OnClickListener onClickListener);

    /**
     * @return RID of fragment container
     */
    int getFragmentContainerRID();

    /**
     * @return get Intent to TopBarFair related views
     */
    @NonNull
    Intent getIntentToTopBar();
}
