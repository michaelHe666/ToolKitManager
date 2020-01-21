package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.HomeFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.HomeFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/1/2020 19:14
 * copyright(c) all rights reserved by MR.M
 **/
public class HomeFragment extends BaseFragment
        implements HomeFairListener {

    private RecyclerView mRecyclerView;

    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {
        mRecyclerView = contentView.findViewById(R.id.fragmentHomeRecyclerView);
    }

    @Override
    protected void bindDataToView(View contentView) {
        HomeFair.LoadFair(this);
    }

    @NonNull
    @Override
    public RecyclerView getToolKitRecyclerView() {
        return mRecyclerView;
    }
}
