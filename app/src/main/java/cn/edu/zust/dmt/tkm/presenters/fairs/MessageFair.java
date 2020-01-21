package cn.edu.zust.dmt.tkm.presenters.fairs;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.presenters.adapters.MessageRecyclerViewAdapter;
import cn.edu.zust.dmt.tkm.interfaces.listeners.MessageFairListener;
import cn.edu.zust.dmt.tkm.models.MyMessageModel;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.fairs
 * @description $
 * @time 1/3/2020 8:37
 * copyright(c) all rights reserved by MR.M
 **/
public class MessageFair {

    private MessageFairListener mCurrentListener;

    private static volatile MessageFair INSTANCE = null;

    private MessageFair() {
        this.mCurrentListener = null;
    }

    public static synchronized void LoadFair(@NonNull MessageFairListener messageFairListener) {
        if (INSTANCE == null) {
            INSTANCE = new MessageFair();
        }
        INSTANCE.mCurrentListener = messageFairListener;
        INSTANCE.initializeMessageRecyclerView();
    }

    private void initializeMessageRecyclerView() {
        List<MyMessageModel> myMessageModelList = new ArrayList<>();
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小张"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小王"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小赵"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小李"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小郑"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小刘"));
        myMessageModelList.add(new MyMessageModel(R.drawable.picture_account_image, "小刘"));

        MessageRecyclerViewAdapter adapter = new MessageRecyclerViewAdapter(myMessageModelList);
        RecyclerView recyclerView = mCurrentListener.getMessageRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}