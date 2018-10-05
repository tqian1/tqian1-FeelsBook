package com.tonyqian.tqian1_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmotionAdapter extends RecyclerView.Adapter<EmotionAdapter.EmotionViewHolder> {
    private String[] emotionList;
    private FeelsBookActivity feelsBookActivity;

    public EmotionAdapter(FeelsBookActivity feelsBookActivity, String[] basicEmotions) {
        this.emotionList = basicEmotions;
        this.feelsBookActivity = feelsBookActivity;
    }

    @Override
    public EmotionAdapter.EmotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emotion_view, parent, false);
        EmotionViewHolder vh = new EmotionViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(EmotionViewHolder holder, int position) {
        holder.EmotionName.setText(emotionList[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                feelsBookActivity.addFeeling(emotionList[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return emotionList.length;
    }

    public static class EmotionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView EmotionName;
        ItemClickListener itemClickListener;

        public EmotionViewHolder(View v) {
            super(v);
            EmotionName = v.findViewById(R.id.emotion_name);
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
