package cn.edu.zust.dmt.tkm.presenters.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.models.MyMessageModel;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.adapters
 * @description $
 * @time 1/3/2020 8:21
 * copyright(c) all rights reserved by MR.M
 **/
public class MessageRecyclerViewAdapter extends RecyclerView.Adapter<MessageRecyclerViewAdapter.MyViewHolder> {

    private List<MyMessageModel> myMessageModelList = new ArrayList<>();

    public MessageRecyclerViewAdapter(List<MyMessageModel> messageModelList) {
        this.myMessageModelList = messageModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.views_my_message_bar, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyMessageModel messageModel = myMessageModelList.get(position);
        holder.mIconImage.setImageDrawable(holder.mIconImage.getResources().getDrawable(messageModel.getIconRID()));
        holder.mTitleTextView.setText(messageModel.getTitle());
        if (position != 0) {
            holder.mRootView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        }
    }

    @Override
    public int getItemCount() {
        return myMessageModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mIconImage;
        TextView mTitleTextView;
        ConstraintLayout mRootView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mRootView=itemView.findViewById(R.id.viewsMyMessageBarConstraintLayout);
            mIconImage = itemView.findViewById(R.id.viewsMyMessageBarImageView);
            mTitleTextView = itemView.findViewById(R.id.viewsMyMessageBarTextView);
        }
    }
}
