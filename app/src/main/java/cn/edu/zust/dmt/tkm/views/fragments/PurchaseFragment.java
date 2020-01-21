package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.PurchaseFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.PurchaseFair;
import cn.edu.zust.dmt.tkm.views.widgets.raw.MyFormBar;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/2/2020 16:04
 * copyright(c) all rights reserved by MR.M
 **/
public class PurchaseFragment extends BaseFragment
        implements PurchaseFairListener {

    private MyFormBar mDateFormBar;

    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_purchase, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {
        mDateFormBar = contentView.findViewById(R.id.fragmentPurchaseDateMyFormBar);
    }

    @Override
    protected void bindDataToView(View contentView) {
        PurchaseFair.loadFair(this);
    }
}