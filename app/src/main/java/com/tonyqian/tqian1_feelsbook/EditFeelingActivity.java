package com.tonyqian.tqian1_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 EditFeelingActivity controls a view used to edit the Date and Comment of a recorded feeling/emotion
 */
public class EditFeelingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeling);

        // Gets our intent - the position of the feeling
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        // Fetches the feeling we are editing
        Feeling feeling = Common.myFeelings.get(position);

        // Declare and reference elements in view
        EditText editDate = findViewById(R.id.editDate);
        EditText editComment = findViewById(R.id.editComment);
        Button saveButton = findViewById(R.id.saveButton);

        // sets the date
        editDate.setText(feeling.getDate().toString());
        // sets the comment
        editComment.setText(feeling.getComment());
    }
}
