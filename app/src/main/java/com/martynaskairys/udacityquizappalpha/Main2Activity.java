package com.martynaskairys.udacityquizappalpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.martynaskairys.udacityquizappalpha.R.id.score2;
import static com.martynaskairys.udacityquizappalpha.R.id.showHome;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int score = extras.getInt("SCORE");
            //The key argument here must match that used in the other activity

            if(score>2)

            {

                Toast.makeText(this, R.string.quiz_completion_greeting, Toast.LENGTH_SHORT).show();
            }

            TextView scoreView = (TextView) findViewById(score2);
            scoreView.setText(String.valueOf(score));
        }
    }


public void restart (View view){

  /*  Intent i = getBaseContext().getPackageManager()
            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(i);*/

  Intent i = new Intent(Main2Activity.this, MainActivity.class);
    startActivity(i);

}





}
