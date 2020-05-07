package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Integer> scores = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startQuiz(View v){
        Intent i = new Intent(this, QuizActivity.class);
        startActivityForResult(i,1);

    }
    public void showScore(View v){
        Intent i = new Intent(this,ScoreActivity.class);
        i.putIntegerArrayListExtra("LIST",scores);
        startActivity(i);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra("SCORE",0);
                scores.add(score);
                Toast.makeText(this,"Score: "+score+" out of 11",Toast.LENGTH_LONG).show();
            }
        }
    }


}
