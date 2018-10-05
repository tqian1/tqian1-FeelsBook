package com.tonyqian.tqian1_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 EditFeelingActivity controls a view used to edit the Date and Comment of a recorded feeling/emotion
 */
public class EditFeelingActivity extends AppCompatActivity {
    // use iso8601 compliant DateTime format when editing Date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    Date date;
    Feeling feeling;
    EditText editDate;
    EditText editComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feeling);

        // Gets our intent - the position of the feeling
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        // Fetches the feeling we are editing
        feeling = Common.myFeelings.get(position);

        // Reference elements in view
        editDate = findViewById(R.id.editDate);
        editComment = findViewById(R.id.editComment);

        // make copy of the original date in case user input is incorrect and can't be parsed
        date = feeling.getDate();

        // formats and sets the date
        String dateText = sdf.format(date);
        editDate.setText(dateText);

        // sets the comment
        editComment.setText(feeling.getComment());
    }

    public void saveChanges(View view) {
        // try to parse the entered date, if it fails then original old date will be used
        try {
            date = sdf.parse(editDate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        feeling.setDate(date);
        String comment = editComment.getText().toString();
        feeling.setComment(comment);
        finish();
    }
}
