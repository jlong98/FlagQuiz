package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {
    public ScrollView scrollView;
    public ArrayList<Integer> list = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scrollView = findViewById(R.id.scrollView);
        scrollView.removeAllViewsInLayout();
        Intent i = getIntent();
        list = i.getIntegerArrayListExtra("LIST");
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());
        for(int j=0;j<list.size();j++){
            TextView text = new TextView(this);
            double percent = Math.round((list.get(j)/11.0)*100.0);
            text.setText(percent+"%");
            text.setTextSize(40);
            grid.addView(text);
        }
        scrollView.addView(grid);


    }

}
