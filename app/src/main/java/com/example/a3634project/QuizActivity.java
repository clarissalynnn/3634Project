package com.example.a3634project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a3634project.Models.QuizQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView mCount;
    private TextView mQuestion;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;
    Button confirmBt;

    private ArrayList<QuizQuestion> questionList;
    private int score = 0;
    private int questionCount = 0;
    private int questionCountTotal;
    private QuizQuestion currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mCount = (TextView) findViewById(R.id.countTv);
        mQuestion = (TextView) findViewById(R.id.questionTv);
        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.choice1Bt);
        rb2 = findViewById(R.id.choice2Bt);
        rb3 = findViewById(R.id.choice3Bt);
        rb4 = findViewById(R.id.choice4Bt);
        confirmBt = findViewById(R.id.confirmBt);

        questionList = QuizQuestion.getQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        confirmBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

    }

    private void showNextQuestion() {
        radioGroup.clearCheck();

        if(questionCount < questionCountTotal){
            currentQuestion = questionList.get(questionCount);

            mQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCount++;
            mCount.setText("Question " + questionCount + " of " + questionCountTotal);
        } else {
            finishQuiz();
        }

    }

    private void checkAnswer() {
        String alertTitle;
        String correctAnswer = "";

        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNr = radioGroup.indexOfChild(rbSelected) + 1;

        if(answerNr == currentQuestion.getAnswer()) {
            alertTitle = "Correct!";
            score++;
        } else {
            alertTitle = "Wrong!";
        }

        switch(currentQuestion.getAnswer()){
            case 1:
                correctAnswer = currentQuestion.getOption1();
                break;
            case 2:
                correctAnswer = currentQuestion.getOption2();
                break;
            case 3:
                correctAnswer = currentQuestion.getOption3();
                break;
            case 4:
                correctAnswer = currentQuestion.getOption4();
                break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer: " + correctAnswer + "\n\n" + currentQuestion.getExplanation());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showNextQuestion();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void finishQuiz() {
        Intent intent = new Intent(getApplicationContext(), QuizResultActivity.class);
        intent.putExtra("CORRECT_ANSWER_COUNT", score);
        startActivity(intent);
        finish();
    }
}
