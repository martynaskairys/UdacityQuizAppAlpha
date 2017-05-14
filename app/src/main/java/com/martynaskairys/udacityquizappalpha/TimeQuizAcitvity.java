package com.martynaskairys.udacityquizappalpha;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class TimeQuizAcitvity extends AppCompatActivity {

    String currentDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

    long startTime = System.nanoTime();

    SQLiteDatabase db;

    final int Q1_ANSWER = R.id.radioButton3Q1;
    final int Q2_ANSWER = R.id.radioButton1Q2;
    final int Q3_ANSWER = R.id.radioButton2Q3;
    final int Q4_ANSWER = R.id.radioButton1Q4;
    final int Q5_ANSWER = R.id.radioButton2Q5;
    final int Q6_ANSWER = R.id.radioButton3Q6;
    final int Q7_ANSWER = R.id.radioButton1Q7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_quiz);

        db = openOrCreateDatabase("QuizAndroidShortcuts", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS quizResults(date VARCHAR, seconds DOUBLE, totalAnswers INT);");
    }

    private boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1);
        {
            return (rg.getCheckedRadioButtonId() == Q1_ANSWER);
        }
    }

    private boolean checkQuestion2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2);
        {
            return (rg.getCheckedRadioButtonId() == Q2_ANSWER);
        }
    }

    private boolean checkQuestion3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_3);
        {
            return (rg.getCheckedRadioButtonId() == Q3_ANSWER);
        }
    }

    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4);
        {
            return (rg.getCheckedRadioButtonId() == Q4_ANSWER);
        }
    }

    private boolean checkQuestion5() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_5);
        {
            return (rg.getCheckedRadioButtonId() == Q5_ANSWER);
        }
    }

    private boolean checkQuestion6() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_6);
        {
            return (rg.getCheckedRadioButtonId() == Q6_ANSWER);
        }
    }

    private boolean checkQuestion7() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_7);
        {
            return (rg.getCheckedRadioButtonId() == Q7_ANSWER);
        }
    }

    public void submitAnswersAppleQuiz(View view) {

        double difference = System.nanoTime() - startTime;
        ArrayList<String> incorrectAnswersList = new ArrayList<>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 1");
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 2");
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 3");
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 4");
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 5");
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 6");
        }

        if (checkQuestion7()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add("Question 7");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }

        Double differenceInSeconds = difference/1000000000;
        String timeText = String.format(Locale.getDefault(), "%.2f", differenceInSeconds);

        db.execSQL("INSERT INTO quizResults VALUES('" +  currentDate + "','" +
                timeText + "','" + numberOfQuestionsCorrect + "');");

        Intent intent = new Intent(TimeQuizAcitvity.this, TimeQuizResultsActivity.class);
        intent.putExtra("SCORE", numberOfQuestionsCorrect);

        intent.putExtra("TimePassed", difference / 1000000000);
        startActivity(intent);
        finish();

    }

}
