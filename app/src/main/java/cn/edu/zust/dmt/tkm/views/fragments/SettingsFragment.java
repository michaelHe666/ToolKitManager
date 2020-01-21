package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.SettingsFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.SettingsFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/1/2020 20:04
 * copyright(c) all rights reserved by MR.M
 **/
public class SettingsFragment extends BaseFragment
        implements SettingsFairListener {

    private ImageButton mAccountButton;

    private TextView mUsernameTextView;

    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {
        mAccountButton = contentView.findViewById(R.id.fragmentSettingsAccountImageButton);
        mUsernameTextView = contentView.findViewById(R.id.fragmentSettingsUserTextView);
    }

    @Override
    protected void bindDataToView(View contentView) {
        SettingsFair.loadFair(this);
    }

    @NonNull
    @Override
    public View getAccountSettingTriggerView() {
        return mAccountButton;
    }
}