package com.martynaskairys.udacityquizappalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    final int Q1_ANSWER = R.id.question_1_third_logo;
    final int Q2_ANSWER = R.id.question_2_second_logo;
    final String Q4_ANSWER = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View v) {
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


        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("SCORE", numberOfQuestionsCorrect);
        startActivity(intent);

        /*Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/4 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/
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
        CheckBox c1 = (CheckBox) findViewById(R.id.question_3_first_checkbox);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_3_second_checkbox);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_3_third_checkbox);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_3_fourth_checkbox);

        {
            return (c1.isChecked() && !c2.isChecked() && c3.isChecked() && !c4.isChecked());
        }

    }

    private boolean checkQuestion4() {
        EditText et = (EditText) findViewById(R.id.question_4_edit_text);

        return et.getText().toString().equalsIgnoreCase(Q4_ANSWER);
    }


}
