package com.tonyqian.tqian1_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class EmotionAdapter extends RecyclerView.Adapter<EmotionAdapter.EmotionViewHolder> {
    private String[] emotionList;
    private FeelsBookActivity feelsBookActivity;

    public EmotionAdapter(FeelsBookActivity feelsBookActivity, String[] basicEmotions) {
        this.emotionList = basicEmotions;
        this.feelsBookActivity = feelsBookActivity;
    }

    // finds how many times this emotion has been added based on feelings log
    public int emotionCount(String emotionName) {
        int count = 0;
        for (int i = 0; i < Common.myFeelings.size(); i++) {
            if (Common.myFeelings.get(i).getEmotion().equals(emotionName)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public EmotionAdapter.EmotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emotion_view, parent, false);
        EmotionViewHolder vh = new EmotionViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final EmotionViewHolder holder, int position) {
        // grabs the emotion at list position
        String emotionName = emotionList[position];
        // grabs the count for this emotion
        String emotionCount = "(" + emotionCount(emotionName) + ")";
        // sets the emotion name
        holder.EmotionName.setText(emotionName);
        // sets the emotion count
        holder.EmotionCount.setText(emotionCount);

        // listener for add feeling button
        holder.AddFeelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when button is clicked - get the position of the button
                int position = holder.getAdapterPosition();
                // use position to add a feeling and re-calculate + update its total count
                String emotionName = emotionList[position];
                feelsBookActivity.addFeeling(emotionName);
                String emotionCount = "(" + emotionCount(emotionName) + ")";
                holder.EmotionCount.setText(emotionCount);
            }
        });

    }

    @Override
    public int getItemCount() {
        return emotionList.length;
    }

    public static class EmotionViewHolder extends RecyclerView.ViewHolder {
        TextView EmotionName;
        TextView EmotionCount;
        Button AddFeelingButton;

        public EmotionViewHolder(View v) {
            super(v);
            EmotionName = v.findViewById(R.id.emotion_name);
            EmotionCount = v.findViewById(R.id.emotion_count);
            AddFeelingButton = v.findViewById(R.id.add_feeling_button);
        }
    }
}
