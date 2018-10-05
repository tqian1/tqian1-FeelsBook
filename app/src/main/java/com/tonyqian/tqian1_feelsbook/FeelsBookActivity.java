package com.tonyqian.tqian1_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FeelsBookActivity extends AppCompatActivity {

    private RecyclerView selectEmotionRecyclerView;
    private EmotionAdapter selectEmotionAdapter;
    private RecyclerView.LayoutManager selectEmotionLayoutManager;

    private String[] basicEmotions = { "love", "joy", "surprise", "anger", "sadness", "fear" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_book);

        selectEmotionRecyclerView = findViewById(R.id.emotionRecyclerView);
        selectEmotionLayoutManager = new LinearLayoutManager(this);
        selectEmotionRecyclerView.setLayoutManager(selectEmotionLayoutManager);
        selectEmotionAdapter = new EmotionAdapter(basicEmotions);
        selectEmotionRecyclerView.setAdapter(selectEmotionAdapter);
    }
}
