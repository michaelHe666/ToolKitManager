package cn.edu.zust.dmt.tkm.presenters.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.models.MyToolKitModel;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.adapters
 * @description $
 * @time 1/5/2020 20:07
 * copyright(c) all rights reserved by MR.M
 **/
public class ToolKitRecyclerViewAdapter extends RecyclerView.Adapter<ToolKitRecyclerViewAdapter.MyViewHolder> {

    private List<MyToolKitModel> myToolKitModelList;

    public ToolKitRecyclerViewAdapter(List<MyToolKitModel> myToolKitModelList) {
        this.myToolKitModelList = myToolKitModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.views_my_tool_kit_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyToolKitModel myToolKitModel = myToolKitModelList.get(position);
        holder.mTitleTextView.setText(myToolKitModel.getName());
        holder.mDeadlineTextView.setText(myToolKitModel.getDeadline());
        if (myToolKitModel.getPosition() == 1) {
            holder.mPositionCardView.setCardBackgroundColor(
                    holder.mPositionCardView.getResources().getColor(R.color.color_my_tool_kit_card_normal));
        }
        if (myToolKitModel.getRisk() == 1) {
            holder.mRiskCardView.setCardBackgroundColor(
                    holder.mRiskCardView.getResources().getColor(R.color.color_my_tool_kit_card_normal));
        }
    }

    @Override
    public int getItemCount() {
        return myToolKitModelList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTextView;
        TextView mDeadlineTextView;

        CardView mPositionCardView;
        CardView mRiskCardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTitleTextView = itemView.findViewById(R.id.viewsMyToolKitCardTitleTextView);
            this.mDeadlineTextView = itemView.findViewById(R.id.viewsMyToolKitCardDeadlineTextView);
            this.mPositionCardView = itemView.findViewById(R.id.viewsMyToolKitCardPositionCardView);
            this.mRiskCardView = itemView.findViewById(R.id.viewsMyToolKitCardRiskCardView);
        }
    }
}
