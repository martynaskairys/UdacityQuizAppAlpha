package com.martynaskairys.udacityquizappalpha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class TimeQuizResultsActivity extends AppCompatActivity {

    TextView scoreView;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_quiz_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int numberOfQuestionsCorrect = extras.getInt("SCORE");

            if (numberOfQuestionsCorrect >= 2)
            {
                Toast.makeText(this, R.string.quiz_completion_greeting, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.quiz_failure_greeting, Toast.LENGTH_SHORT).show();
            }

            scoreView = (TextView) findViewById(R.id.scoreApple);
            scoreView.setText(String.valueOf("You answered " + numberOfQuestionsCorrect + "/7 questions correctly"));
        }

        Double datas = getIntent().getDoubleExtra("TimePassed", 0);
        String timeText = String.format(Locale.getDefault(),"%.2f", datas);
        time = (TextView) findViewById(R.id.timePerQuiz);
        time.setText("Your time is " + timeText + " seconds");

        Button btn = (Button) findViewById(R.id.resultsButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TimeQuizResultsActivity.this, StartActivity.class);
                startActivity(i);
                finish();
            }
        });

    }


public void showHistory(View view){

    SQLiteDatabase db;
    db = openOrCreateDatabase("QuizAndroidShortcuts", Context.MODE_PRIVATE, null);

    Cursor c = db.rawQuery("SELECT * FROM quizResults", null);

    if (c.getCount() == 0) {
        showMessage("Error", "No records found");
        return;
    }

    StringBuffer buffer = new StringBuffer();
    while (c.moveToNext()) {
        buffer.append("Date: " + c.getString(0) + "\n");
        buffer.append("Seconds: " + c.getString(1) + "\n");
        buffer.append("Correct answers: " + c.getString(2) + "\n\n");
    }

    showMessage("Quiz results", buffer.toString());
}

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}



