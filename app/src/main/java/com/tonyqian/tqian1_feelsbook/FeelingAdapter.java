package com.tonyqian.tqian1_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

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
        Feeling feeling = Common.myFeelings.get(position);

        // use SDF to get iso8601 compliant DateTime format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        holder.FeelingEmotion.setText(feeling.getEmotion());
        String dateText = sdf.format(feeling.getDate());
        holder.FeelingDate.setText(dateText);
        String commentText = "Comment: " + feeling.getComment();
        holder.FeelingComment.setText(commentText);
    }

    @Override
    public int getItemCount() {
        return Common.myFeelings.size();
    }

    public static class FeelingViewHolder extends RecyclerView.ViewHolder {
        TextView FeelingEmotion;
        TextView FeelingDate;
        TextView FeelingComment;

        public FeelingViewHolder(View v) {
            super(v);
            FeelingEmotion = v.findViewById(R.id.feeling_emotion);
            FeelingDate = v.findViewById(R.id.feeling_date);
            FeelingComment = v.findViewById(R.id.feeling_comment);
        }
    }
}
