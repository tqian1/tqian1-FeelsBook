package com.tonyqian.tqian1_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FeelsBookActivity extends AppCompatActivity {
    private RecyclerView selectEmotionRecyclerView;
    private RecyclerView.LayoutManager selectEmotionLayoutManager;
    private EmotionAdapter selectEmotionAdapter;

    private String[] basicEmotions = { "Love", "Joy", "Surprise", "Anger", "Sadness", "Fear" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_book);

        // get our RecyclerView
        selectEmotionRecyclerView = findViewById(R.id.emotionRecyclerView);
        // create linear layout manager and use it
        selectEmotionLayoutManager = new LinearLayoutManager(this);
        selectEmotionRecyclerView.setLayoutManager(selectEmotionLayoutManager);
        // create custom adapter and use it
        selectEmotionAdapter = new EmotionAdapter(this, basicEmotions);
        selectEmotionRecyclerView.setAdapter(selectEmotionAdapter);

        // loadSavedFeelings();
    }

    public void saveSelectedEmotion(String emotion) {

    }
}
