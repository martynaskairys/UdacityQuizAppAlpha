package com.martynaskairys.udacityquizappalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }
        });
    }

    public void addOne(View view) {

        score = score + 1;

    }

    public void addTwo(View view) {

        score = score + 2;

    }

    public void addThree(View view) {

        score = score + 3;

    }

    public void addFour(View view) {

        score = score + 1;

    }



}
