package com.tonyqian.tqian1_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeelingAdapter extends RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder> {
    private ViewFeelingsActivity viewFeelingsActivity;

    public FeelingAdapter(ViewFeelingsActivity viewFeelingsActivity) {
        this.viewFeelingsActivity = viewFeelingsActivity;
    }

    @Override
    public FeelingAdapter.FeelingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feeling_view, parent, false);
        FeelingViewHolder vh = new FeelingViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(FeelingViewHolder holder, int position) {
        holder.FeelingName.setText(Common.myFeelings.get(position).getEmotion());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                viewFeelingsActivity.editFeeling(Common.myFeelings.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Common.myFeelings.size();
    }

    public static class FeelingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView FeelingName;
        ItemClickListener itemClickListener;

        public FeelingViewHolder(View v) {
            super(v);
            FeelingName = v.findViewById(R.id.feeling_name);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
