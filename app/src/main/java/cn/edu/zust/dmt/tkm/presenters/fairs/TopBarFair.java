package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.views.fragments.PurchaseFragment;
import cn.edu.zust.dmt.tkm.interfaces.listeners.TopBarFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/2/2020 18:09
 * copyright(c) all rights reserved by MR.M
 **/
public class TopBarFair {

    private TopBarFairListener mCurrentListener;

    private static volatile TopBarFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private TopBarFair() {
        mCurrentListener = null;
    }

    public static synchronized void loadFair(@NonNull TopBarFairListener topBarFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new TopBarFair();
        }
        INSTANCE.mCurrentListener = topBarFairListener;
        INSTANCE.parseIntentToTopBarActivity();
    }

    private void parseIntentToTopBarActivity() {
        Bundle bundle = mCurrentListener.getIntentToTopBar().getExtras();

        if (bundle != null) {
            String string = bundle.getString("key_target_fragment");

            if (string != null) {
                try {
                    this.getClass().getDeclaredMethod("replaceTo" + string + "Fragment").invoke(this);
                    this.getClass().getDeclaredMethod("set" + string + "TopBar").invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void replaceToPurchaseFragment() {
        FragmentManager fragmentManager = mCurrentListener.getFragmentManagerMethods().getMyFragmentManager();
        fragmentManager.beginTransaction()
                .replace(mCurrentListener.getFragmentContainerRID(), new PurchaseFragment())
                .commit();
    }

    private void setPurchaseTopBar() {
        mCurrentListener.setTopBarTitle(R.string.string_fragment_management_purchase);
        mCurrentListener.showTopBarLeftButton(R.drawable.icon_universe_back);
        mCurrentListener.setTopBarLeftButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                baseActivity.onBackPressed();
            }
        });
    }
}