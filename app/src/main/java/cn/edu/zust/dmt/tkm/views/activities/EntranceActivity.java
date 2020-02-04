package cn.edu.zust.dmt.tkm.views.activities;

import android.content.Intent;
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
    protected final void loadActivityView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_entrance);
    }

    @Override
    protected final void initializeMemberVariables() {
        mFragmentContainer = findViewById(R.id.activityEntranceFragmentContainerFrameLayout);
    }

    @Override
    protected final void bindDataToView() {
        EntranceFair.loadFair(this);
    }

    @NonNull
    @Override
    public final Intent getIntentToEntrance() {
        return this.getIntent();
    }

    @NonNull
    @Override
    public final ViewGroup getFragmentContainer() {
        return mFragmentContainer;
    }
}