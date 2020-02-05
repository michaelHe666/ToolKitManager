package cn.edu.zust.dmt.tkm.presenters.fairs;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.presenters.adapters.HomeRecyclerViewAdapter;
import cn.edu.zust.dmt.tkm.interfaces.listeners.HomeFairListener;
import cn.edu.zust.dmt.tkm.models.MyToolKitModel;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/5/2020 19:36
 * copyright(c) all rights reserved by MR.M
 **/
public class HomeFair {

    private HomeFairListener mCurrentListener;

    private static volatile HomeFair INSTANCE = null;

    private HomeFair() {
        this.mCurrentListener = null;
    }

    public static synchronized void LoadFair(@NonNull HomeFairListener homeFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new HomeFair();
        }
        INSTANCE.mCurrentListener = homeFairListener;
        INSTANCE.initializeToolKitRecyclerView();
    }

    private void initializeToolKitRecyclerView() {
        List<MyToolKitModel> myMessageModelList = new ArrayList<>();
        myMessageModelList.add(new MyToolKitModel("机械工具夹T1", "2019/12/31", 1, 1));
        myMessageModelList.add(new MyToolKitModel("机械工具夹T2", "2020/1/15", 0, 1));
        myMessageModelList.add(new MyToolKitModel("电子笔工具夹", "2019/12/31", 1, 1));
        myMessageModelList.add(new MyToolKitModel("激光工具夹R1", "2019/1/27", 0, 0));
        myMessageModelList.add(new MyToolKitModel("机械工具夹T3", "2019/12/3", 1, 1));
        myMessageModelList.add(new MyToolKitModel("机械工具夹T4", "2019/10/31", 1, 0));
        myMessageModelList.add(new MyToolKitModel("机械工具夹T5", "2019/4/6", 1, 1));

        HomeRecyclerViewAdapter adapter = new HomeRecyclerViewAdapter(myMessageModelList);
        RecyclerView recyclerView = mCurrentListener.getToolKitRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
