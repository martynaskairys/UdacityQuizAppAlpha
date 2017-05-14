package com.martynaskairys.udacityquizappalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.martynaskairys.udacityquizappalpha.R.id.score2;

public class QuizResultsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int numberOfQuestionsCorrect = extras.getInt("SCORE");

            if (numberOfQuestionsCorrect >= 2) {
                Toast.makeText(this, R.string.quiz_completion_greeting, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.quiz_failure_greeting, Toast.LENGTH_SHORT).show();
            }

            TextView scoreView = (TextView) findViewById(score2);
            scoreView.setText(String.valueOf(numberOfQuestionsCorrect));
        }
    }

    public void restart(View view) {
        Intent i = new Intent(QuizResultsActivity.this, StartActivity.class);
        startActivity(i);
        finish();
    }
}
