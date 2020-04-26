package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634project.Fragments.QuizFragment;
import com.example.a3634project.Models.QuizQuestion;

import java.util.ArrayList;

public class QuizResultActivity extends AppCompatActivity {
    private ArrayList<QuizQuestion> questionList;
    private int questionCountTotal;
    private double scorePercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        questionList = QuizQuestion.getQuestions();
        questionCountTotal = questionList.size();

        TextView messageTv = findViewById(R.id.messageTv);
        TextView resultTv = findViewById(R.id.resultTv);
        TextView highScoreTv = findViewById(R.id.highScoreTv);
        Button tryAgainBt = findViewById(R.id.tryAgainBt);

        int score = getIntent().getIntExtra("CORRECT_ANSWER_COUNT", 0);

        SharedPreferences settings = getSharedPreferences("quiz", Context.MODE_PRIVATE);
        int highScore = settings.getInt("highScore", 0);

        if(score > highScore){
            highScore = score;
        }

        scorePercentage = calculatePercentage(score, questionCountTotal);
        messageTv.setText(setMessage(scorePercentage));
        resultTv.setText("Your Score: " + score + " / " + questionCountTotal);
        highScoreTv.setText("High Score: " + highScore);

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("highScore", highScore);
        editor.commit();

        tryAgainBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchQuiz(v);
            }
        });
    }

    private String setMessage(double score){
        String message;
        if (score >= 85){
            message = "Well Done!";
        } else if (score >= 75){
            message = "Good Job!";
        } else if (score >= 50){
            message = "Not too bad!";
        } else {
            message = "It's OK, try again next time!";
        }
        return message;
    }

    private double calculatePercentage(int score, int fullScore){
        double scorePercentage = ((double) score / fullScore) * 100;
        return scorePercentage;
    }

    private void launchQuiz(View v){
        Intent intent = new Intent(v.getContext(), QuizActivity.class);
        startActivity(intent);
    }

}
