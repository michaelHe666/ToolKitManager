package cn.edu.zust.dmt.tkm.views.activities;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.EntranceFairListener;
import cn.edu.zust.dmt.tkm.presenters.fairs.EntranceFair;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.activities
 * @description $
 * @time 1/2/2020 13:29
 * copyright(c) all rights reserved by MR.M
 **/
public class EntranceActivity extends BaseActivity
        implements EntranceFairListener {

    private ConstraintLayout mFragmentContainer;

    /**
     * @param savedInstanceState get the bundle from activity onCreate
     */
    @Override
    protected void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_entrance);
    }

    @Override
    protected void initializeMemberVariables() {
        mFragmentContainer=findViewById(R.id.activityEntranceFragmentContainerConstraintLayout);
    }

    @Override
    protected void bindDataToView() {
        EntranceFair.loadFair(this);
    }

    @NonNull
    @Override
    public ViewGroup getFragmentContainer() {
        return mFragmentContainer;
    }
}