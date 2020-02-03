package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.presenters.adapters.BaseFragmentPagerAdapter;
import cn.edu.zust.dmt.tkm.views.fragments.HomeFragment;
import cn.edu.zust.dmt.tkm.views.fragments.ManagementFragment;
import cn.edu.zust.dmt.tkm.views.fragments.MessageFragment;
import cn.edu.zust.dmt.tkm.views.fragments.SettingsFragment;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MainFairListener;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description user singleton-pattern
 * @time 1/1/2020 18:19
 * copyright(c) all rights reserved by MR.M
 **/
public class MainFair {

    private MainFairListener mCurrentListener;

    private static volatile MainFair INSTANCE = null;

    /**
     * @description forbidden create class by new
     */
    private MainFair() {
        mCurrentListener = null;
    }

    public static synchronized void loadFair(@NonNull MainFairListener mainFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new MainFair();
        }
        INSTANCE.mCurrentListener = mainFairListener;
        INSTANCE.parseIntentToMain();
        INSTANCE.setMainViewPager();
        INSTANCE.setHomeButton();
        INSTANCE.setManagementButton();
        INSTANCE.setMessageButton();
        INSTANCE.setSettingsButton();
    }

    private void parseIntentToMain() {

        Bundle bundle = mCurrentListener.getIntentToMain().getExtras();

        if (bundle != null) {
            String string = bundle.getString("key_target_fragment");

            if (string != null) {
                try {
//                    this.getClass().getDeclaredMethod("replaceTo" + string + "Fragment").invoke(this);
                    this.getClass().getDeclaredMethod("set" + string + "TopBar").invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setMainViewPager() {
        ViewPager viewPager = mCurrentListener.getMainViewPager();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ManagementFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new SettingsFragment());
        viewPager.setAdapter(new BaseFragmentPagerAdapter(mCurrentListener.getFragmentManagerMethods().getMyFragmentManager(),
                fragmentList));
        viewPager.setOffscreenPageLimit(1);
    }

    private void setHomeButton() {
        View view = mCurrentListener.getHomeTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceToHomeFragment();
                setHomeTopBar();
            }
        });
    }

    private void setManagementButton() {
        View view = mCurrentListener.getManagementTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceToManagementFragment();
                setManagementTopBar();
            }
        });
    }

    private void setMessageButton() {
        View view = mCurrentListener.getMessageTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceToMessageFragment();
                setMessageTopBar();
            }
        });
    }

    private void setSettingsButton() {
        View view = mCurrentListener.getSettingsTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceToSettingsFragment();
                setSettingsTopBar();
            }
        });
    }

    private void replaceToHomeFragment() {
        mCurrentListener.getMainViewPager().setCurrentItem(0);
    }

    private void replaceToManagementFragment() {
        mCurrentListener.getMainViewPager().setCurrentItem(1);
    }

    private void replaceToMessageFragment() {
        mCurrentListener.getMainViewPager().setCurrentItem(2);
    }

    private void replaceToSettingsFragment() {
        mCurrentListener.getMainViewPager().setCurrentItem(3);
    }

    /**
     * @description set topBar title and buttons
     */
    private void setHomeTopBar() {
        mCurrentListener.setTopBarTitle(R.string.string_activity_main_home);
        mCurrentListener.showTopBarRightButton(R.drawable.icon_universe_settings);
    }

    private void setManagementTopBar() {
        mCurrentListener.setTopBarTitle(R.string.string_activity_main_management);
        mCurrentListener.showTopBarRightButton(R.drawable.icon_universe_settings);
    }

    private void setMessageTopBar() {
        mCurrentListener.setTopBarTitle(R.string.string_activity_main_message);
        mCurrentListener.showTopBarRightButton(R.drawable.icon_universe_settings);
    }

    private void setSettingsTopBar() {
        mCurrentListener.setTopBarTitle(R.string.string_activity_main_settings);
        mCurrentListener.hideTopBarRightButton();
    }
}