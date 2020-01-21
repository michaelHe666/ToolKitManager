package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.ManagementFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.ManagementFair;
import cn.edu.zust.dmt.tkm.views.widgets.raw.MyOptionCard;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/1/2020 20:03
 * copyright(c) all rights reserved by MR.M
 **/
public class ManagementFragment extends BaseFragment
        implements ManagementFairListener {

    private MyOptionCard mPurchaseButton;

    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_management, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {
        mPurchaseButton = contentView.findViewById(R.id.fragmentManagementPurchaseMyOptionCard);
    }

    @Override
    protected void bindDataToView(View contentView) {
        ManagementFair.LoadFair(this);
    }

    @NonNull
    @Override
    public View getPurchaseTriggerView() {
        return mPurchaseButton;
    }
}
