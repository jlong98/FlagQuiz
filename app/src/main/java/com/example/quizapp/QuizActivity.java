package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    public ImageView flag;
    public EditText answerText;
    public TextView scoreBox;
    public int score;
    public int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        score = 0;
        count=1;
        flag = findViewById(R.id.imageView);
        scoreBox = findViewById(R.id.scorebox);
        answerText = findViewById(R.id.answerText);
        scoreBox.setText(score+"");
        flag.setImageDrawable(getResources().getDrawable(R.drawable.argentina));
        flag.setTag("argentina");
    }

    public void next(View v){
        if(count==0){
            Intent result = new Intent();
            result.putExtra("SCORE", score);
            setResult(RESULT_OK,result);
            finish();
        }else if(count==1) {
            flag.setImageDrawable(getResources().getDrawable(R.drawable.australia));
            flag.setTag("australia");
            count++;
        }else if(count==2){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.brazil));
            flag.setTag("brazil");
            count++;
        }else if(count==3){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.canada));
            flag.setTag("canada");
            count++;
        }else if(count==4){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.china));
            flag.setTag("china");
            count++;
        }else if(count==5){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.france));
            flag.setTag("france");
            count++;
        }else if(count==6){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.germany));
            flag.setTag("germany");
            count++;
        }else if(count==7){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.india));
            flag.setTag("india");
            count++;
        }else if(count==8){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.japan));
            flag.setTag("japan");
            count++;
        }else if(count==9){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.mexico));
            flag.setTag("mexico");
            count++;
        }else if(count==10){
            flag.setImageDrawable(getResources().getDrawable(R.drawable.usa));
            flag.setTag("united states");
            count=0;
        }
    }

    public void checkAnswer(View v){
        String answer = answerText.getText().toString();
        answer = answer.toLowerCase();
        if(answer.equals(flag.getTag().toString())) {
            score++;
            scoreBox.setText(score + "");
            answerText.setText("");
            next(v);
        }else{
            score--;
            if(count==1)
                Toast.makeText(this,"This country has a very famous soccer team",Toast.LENGTH_LONG).show();
            else if(count==2)
                Toast.makeText(this,"This country is an english speaking country in the southern Hemisphere",Toast.LENGTH_LONG).show();
            else if(count==3)
                Toast.makeText(this,"Only portuguese speaking country in it's area",Toast.LENGTH_LONG).show();
            else if(count==4)
                Toast.makeText(this,"Known for it's maple syrup",Toast.LENGTH_LONG).show();
            else if(count==5)
                Toast.makeText(this,"The most populated country",Toast.LENGTH_LONG).show();
            else if(count==6)
                Toast.makeText(this,"Known for it's tower",Toast.LENGTH_LONG).show();
            else if(count==7)
                Toast.makeText(this,"This country was involved in both World Wars",Toast.LENGTH_LONG).show();
            else if(count==8)
                Toast.makeText(this,"Known for the Taj Mahal",Toast.LENGTH_LONG).show();
            else if(count==9)
                Toast.makeText(this,"You have seen a car from this country",Toast.LENGTH_LONG).show();
            else if(count==10)
                Toast.makeText(this,"Known for it's beaches and drinks",Toast.LENGTH_LONG).show();
            else if(count==0)
                Toast.makeText(this,"Known as the melting pot of humanity",Toast.LENGTH_LONG).show();
            scoreBox.setText(score+"");
        }

    }


}
