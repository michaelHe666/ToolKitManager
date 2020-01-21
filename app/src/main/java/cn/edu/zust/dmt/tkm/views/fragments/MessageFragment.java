package cn.edu.zust.dmt.tkm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MessageFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.MessageFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/1/2020 20:03
 * copyright(c) all rights reserved by MR.M
 **/
public class MessageFragment extends BaseFragment
        implements MessageFairListener {

    private RecyclerView mMessageRecyclerView;

    @Override
    protected View LoadFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    protected void initializeMemberVariables(View contentView) {
        mMessageRecyclerView = contentView.findViewById(R.id.fragmentMessageRecyclerView);
    }

    @Override
    protected void bindDataToView(View contentView) {
        MessageFair.LoadFair(this);
    }

    @NonNull
    @Override
    public RecyclerView getMessageRecyclerView() {
        return mMessageRecyclerView;
    }
}
