package com.martynaskairys.udacityquizappalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button btnQuiz;
    Button btnTimeQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnQuiz = (Button) findViewById(R.id.buttonQuiz);
        btnTimeQuiz = (Button) findViewById(R.id.buttonTimeBattle);

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, QuizActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnTimeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, TimeQuizAcitvity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
