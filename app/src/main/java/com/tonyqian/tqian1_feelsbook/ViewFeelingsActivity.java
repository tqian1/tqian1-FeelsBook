package com.tonyqian.tqian1_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewFeelingsActivity extends AppCompatActivity {
    private RecyclerView viewFeelingRecyclerView;
    private RecyclerView.LayoutManager viewFeelingLayoutManager;
    private FeelingAdapter viewFeelingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feelings);

        // get our RecyclerView
        viewFeelingRecyclerView = findViewById(R.id.feelingRecyclerView);
        // create linear layout manager and use it
        viewFeelingLayoutManager = new LinearLayoutManager(this);
        viewFeelingRecyclerView.setLayoutManager(viewFeelingLayoutManager);
        // create custom adapter and use it
        viewFeelingAdapter = new FeelingAdapter(this );
        viewFeelingRecyclerView.setAdapter(viewFeelingAdapter);
    }

    // Callback when unit in FeelingRecyclerView is clicked
    public void editFeeling(Feeling feeling) {

    }
}
