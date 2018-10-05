package com.tonyqian.tqian1_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 FeelingAdapter is a RecyclerView.Adapter that is used for rendering a list which represents a log
 of the feelings that the user has added. Each item on the list contains details about the entry,
 as well as buttons for editing and deleting the entry.
 */
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
    public void onBindViewHolder(final FeelingViewHolder holder, int position) {
        // grabs the emotion at ArrayList
        Feeling feeling = Common.myFeelings.get(position);

        // use SDF to get iso8601 compliant DateTime format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        holder.FeelingEmotion.setText(feeling.getEmotion());
        String dateText = sdf.format(feeling.getDate());
        holder.FeelingDate.setText(dateText);
        String commentText = "Comment: " + feeling.getComment();
        holder.FeelingComment.setText(commentText);

        // listener for edit feeling button
        holder.EditFeelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when button is clicked - get the position of the button
                int position = holder.getAdapterPosition();
                // use position to tell ViewFeelingsActivity which feeling to edit
                viewFeelingsActivity.editFeeling(position);
            }
        });

        // listener for delete feeling button
        holder.DeleteFeelingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when button is clicked - get the position of the button
                int position = holder.getAdapterPosition();
                // use position to tell ViewFeelingsActivity which feeling to edit
                viewFeelingsActivity.deleteFeeling(position);
                // tell observers that item was removed so it can update on screen
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Common.myFeelings.size();
    }

    public static class FeelingViewHolder extends RecyclerView.ViewHolder {
        TextView FeelingEmotion;
        TextView FeelingDate;
        TextView FeelingComment;
        Button EditFeelingButton;
        Button DeleteFeelingButton;

        public FeelingViewHolder(View v) {
            super(v);
            FeelingEmotion = v.findViewById(R.id.feelingEmotion);
            FeelingDate = v.findViewById(R.id.feelingDate);
            FeelingComment = v.findViewById(R.id.feelingComment);
            EditFeelingButton = v.findViewById(R.id.editFeelingButton);
            DeleteFeelingButton = v.findViewById(R.id.deleteFeelingButton);
        }
    }
}
