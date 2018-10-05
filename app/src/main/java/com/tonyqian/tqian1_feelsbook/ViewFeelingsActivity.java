package com.tonyqian.tqian1_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Collections;

/**
 ViewFeelingsActivity controls a RecyclerView used for displaying a log of feelings the user added.
 This activity is also responsible for editing and deleting the Feeling entries it displays.
*/
public class ViewFeelingsActivity extends AppCompatActivity {
    private RecyclerView viewFeelingRecyclerView;
    private RecyclerView.LayoutManager viewFeelingLayoutManager;
    private FeelingAdapter viewFeelingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feelings);

        // sort the myFeelings ArrayList by Date each time this activity is launched
        // so that they are always sorted when displayed
        Collections.sort(Common.myFeelings);

        // get our RecyclerView
        viewFeelingRecyclerView = findViewById(R.id.feelingRecyclerView);
        // create linear layout manager and use it
        viewFeelingLayoutManager = new LinearLayoutManager(this);
        viewFeelingRecyclerView.setLayoutManager(viewFeelingLayoutManager);
        // create custom adapter and use it
        viewFeelingAdapter = new FeelingAdapter(this );
        viewFeelingRecyclerView.setAdapter(viewFeelingAdapter);
    }

    // Callback when Edit button in FeelingRecyclerView is clicked
    // launch activity to edit the selected Feeling
    public void editFeeling(int position) {

    }

    // Callback when Delete button in FeelingRecyclerView is clicked
    // remove the deleted Feeling
    public void deleteFeeling(int position) {
        Common.myFeelings.remove(position);
    }
}
