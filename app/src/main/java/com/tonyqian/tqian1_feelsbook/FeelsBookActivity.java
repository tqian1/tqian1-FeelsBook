package com.tonyqian.tqian1_feelsbook;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 ViewFeelingsActivity controls our main view which consists of some TextViews to describe elements,
 a RecyclerView for selecting emotions to add and viewing how many times they have been added,
 a PlainText comment input and a Button used for launching ViewFeelingsActivity where the user can
 view his log of feelings. This activity is also responsible for creating new Feeling entries as
 well as saving all feeling entries when the app is stopped and loading them when it is launched.
 */
public class FeelsBookActivity extends AppCompatActivity {
    private RecyclerView selectEmotionRecyclerView;
    private RecyclerView.LayoutManager selectEmotionLayoutManager;
    private EmotionAdapter selectEmotionAdapter;

    private String FILENAME = "myFeelings.json"; // name for file to save data as json
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

        // attempt to load saved feelings from previous save file
        loadSavedFeelingsFromFile();

        // display initial number of feelings on view feelings button
        updateViewFeelingsButton();
    }

    // Perform housekeeping by saving what we have
    @Override
    protected void onStop() {
        super.onStop();
        saveFeelingsToFile();
    }

    // Callback when Add button in EmotionRecyclerView is clicked
    public void addFeeling(String emotion) {
        EditText emotionComment = findViewById(R.id.emotionComment);
        String comment = emotionComment.getText().toString();
        Date currentTime = Calendar.getInstance().getTime();
        Feeling feeling = new Feeling(emotion, comment, currentTime);
        Common.myFeelings.add(feeling);
        updateViewFeelingsButton();
        Snackbar.make(findViewById(R.id.mainConstraintLayout),
                "Feeling added! \nEmotion: "+feeling.getEmotion(),
                Snackbar.LENGTH_SHORT).show();
    }

    // Updates the view feelings button to show counter of number of saved feelings
    public void updateViewFeelingsButton() {
        Button viewFeelingsButton = findViewById(R.id.viewFeelingsButton);
        String buttonText = "View Log (" + Common.myFeelings.size() + " feelings)";
        viewFeelingsButton.setText(buttonText);
    }

    // Callback when View Log button is pressed
    public void viewFeelings(View view) {
        Intent intent = new Intent(this, ViewFeelingsActivity.class);
        startActivityForResult(intent, 1);
    }

    // General callback method when return from other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // When returning from ViewFeelingsActivity
        if (requestCode==1) {
            // Update our EmotionAdapter in case Feelings were deleted
            selectEmotionAdapter.notifyDataSetChanged();
            // Update our View Log Button in case Feelings were deleted
            updateViewFeelingsButton();
            // Save everything to file
            saveFeelingsToFile();
        }
    }

    // Save our feelings
    private void saveFeelingsToFile() {
        try {
            // Convert java object to json for writing to json file
            Gson gson = new Gson();
            String jsonMyFeelings = gson.toJson(Common.myFeelings);
            // Create FileOutput stream and write json to file
            FileOutputStream fileOutputStream = new FileOutputStream(new File(getFilesDir(), FILENAME), false /*append*/);
            fileOutputStream.write(jsonMyFeelings.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Load our feelings
    private void loadSavedFeelingsFromFile() {
        try {
            FileInputStream fileInputStream = openFileInput(FILENAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String jsonMyFeelings = stringBuilder.toString();
            Gson gson = new Gson();
            Common.myFeelings = gson.fromJson(jsonMyFeelings,new TypeToken<ArrayList<Feeling>>() {}.getType());
        } catch (FileNotFoundException e) {
            // If there is no existing file to load from then populate myFeelings with new ArrayList
            Common.myFeelings = new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
