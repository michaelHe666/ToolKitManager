package cn.edu.zust.dmt.tkm.presenters.fairs;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MainFairListener;
import cn.edu.zust.dmt.tkm.presenters.adapters.MainViewPager2Adapter;
import cn.edu.zust.dmt.tkm.views.activities.BaseActivity;
import cn.edu.zust.dmt.tkm.views.fragments.HomeFragment;
import cn.edu.zust.dmt.tkm.views.fragments.ManagementFragment;
import cn.edu.zust.dmt.tkm.views.fragments.MessageFragment;
import cn.edu.zust.dmt.tkm.views.fragments.SettingsFragment;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyTopBar;

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
        INSTANCE.setImmersiveTopView();
        INSTANCE.setMainViewPager2();
        INSTANCE.parseIntentToMain();
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
                    this.getClass().getDeclaredMethod("load" + string + "Fragment").invoke(this);
                    this.getClass().getDeclaredMethod("set" + string + "TopBar").invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setImmersiveTopView() {
        mCurrentListener.setImmersiveTopView(mCurrentListener.getMyTopBar());
    }

    private void setMainViewPager2() {
        ViewPager2 viewPager2 = mCurrentListener.getMainViewPager2();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ManagementFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new SettingsFragment());
        viewPager2.setAdapter(new MainViewPager2Adapter((BaseActivity) mCurrentListener, fragmentList));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0: setHomeTopBar();break;
                    case 1: setManagementTopBar();break;
                    case 2: setMessageTopBar();break;
                    case 3: setSettingsTopBar();break;
                }
            }
        });
    }

    private void setHomeButton() {
        View view = mCurrentListener.getHomeTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHomeFragment();
                setHomeTopBar();
            }
        });
    }

    private void setManagementButton() {
        View view = mCurrentListener.getManagementTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadManagementFragment();
                setManagementTopBar();
            }
        });
    }

    private void setMessageButton() {
        View view = mCurrentListener.getMessageTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMessageFragment();
                setMessageTopBar();
            }
        });
    }

    private void setSettingsButton() {
        View view = mCurrentListener.getSettingsTriggerView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadSettingsFragment();
                setSettingsTopBar();
            }
        });
    }

    private void loadHomeFragment() {
        mCurrentListener.getMainViewPager2().setCurrentItem(0);
    }

    private void loadManagementFragment() {
        mCurrentListener.getMainViewPager2().setCurrentItem(1);
    }

    private void loadMessageFragment() {
        mCurrentListener.getMainViewPager2().setCurrentItem(2);
    }

    private void loadSettingsFragment() {
        mCurrentListener.getMainViewPager2().setCurrentItem(3);
    }

    /**
     * @description set topBar title and buttons
     */
    private void setHomeTopBar() {
        MyTopBar myTopBar = mCurrentListener.getMyTopBar();
        myTopBar.setTitle(R.string.string_activity_main_home);
        //todo:XML中myTopBar设置width为0时设置icon无效，设置title有效
        myTopBar.showRightButton(R.drawable.icon_universe_settings);
    }

    private void setManagementTopBar() {
        MyTopBar myTopBar = mCurrentListener.getMyTopBar();
        myTopBar.setTitle(R.string.string_activity_main_management);
        myTopBar.showRightButton(R.drawable.icon_universe_settings);
    }

    private void setMessageTopBar() {
        MyTopBar myTopBar = mCurrentListener.getMyTopBar();
        myTopBar.setTitle(R.string.string_activity_main_message);
        myTopBar.showRightButton(R.drawable.icon_universe_settings);
    }

    private void setSettingsTopBar() {
        MyTopBar myTopBar = mCurrentListener.getMyTopBar();
        myTopBar.setTitle(R.string.string_activity_main_settings);
        myTopBar.hideRightButton();
    }
}