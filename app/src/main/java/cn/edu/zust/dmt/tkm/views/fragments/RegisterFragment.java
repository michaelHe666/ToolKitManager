package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 2/4/2020 18:57
 * copyright(c) all rights reserved by MR.M
 **/
public class RegisterFragment extends BaseFragment {
    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {

    }

    @Override
    protected void bindDataToView(View contentView) {

    }
}
