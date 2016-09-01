package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalScore = 0;
    final int MAX_SCORE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmitClicked(View view) {
        if (checkQuestion1()) {
            return;
        }
        if (checkQuestion2()) {
            return;
        }
        if (checkQuestion3()){
            return;
        }
        if(checkQuestion4()){
            return;
        }
        if(checkQuestion5()){
            return;
        }
        if (totalScore == MAX_SCORE) {
            Toast.makeText(this, "Excellent! Your score is: " + totalScore + " out of 5!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Your score is: " + totalScore, Toast.LENGTH_SHORT).show();
        }
        totalScore = 0;
    }

    /**
     * This checks
     */
    private boolean checkQuestion1() {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.question1_radioGroup);
        RadioButton question1Answer = (RadioButton) findViewById(R.id.question1_answer);
        if (question1RadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Question 1 is empty, please give an answer.", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            if (question1Answer.isChecked()) {
                totalScore++;
                Toast.makeText(MainActivity.this, "Question 1 is correct", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

    private boolean checkQuestion2() {
        RadioGroup question2RadioGroup = (RadioGroup) findViewById(R.id.question2_radioGroup);
        RadioButton question2Answer = (RadioButton) findViewById(R.id.question2_answer);
        if (question2RadioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(MainActivity.this, "Question 2 is empty, please give an answer.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            if (question2Answer.isChecked()) {
                totalScore++;
                Toast.makeText(MainActivity.this, "Question 2 is correct", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

    private boolean checkQuestion3() {
        RadioGroup question3RadioGroup = (RadioGroup) findViewById(R.id.question3_radioGroup);
        RadioButton question3Answer = (RadioButton) findViewById(R.id.question3_answer);
        if(question3RadioGroup.getCheckedRadioButtonId() == -1){
            Toast.makeText(MainActivity.this, "Question 3 is empty, please give an answer.", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            if (question3Answer.isChecked()) {
                totalScore++;
                Toast.makeText(MainActivity.this, "Question 3 is correct", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

    private boolean checkQuestion4() {
        CheckBox question4Opt1 = (CheckBox) findViewById(R.id.question4_opt1);
        CheckBox question4Opt2 = (CheckBox) findViewById(R.id.question4_opt2);
        CheckBox question4Opt3 = (CheckBox) findViewById(R.id.question4_opt3);
        if (!question4Opt1.isChecked() && question4Opt2.isChecked() && question4Opt3.isChecked()) {
            totalScore++;
            Toast.makeText(MainActivity.this, "Question 4 is correct", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(!question4Opt1.isChecked() && !question4Opt2.isChecked() && !question4Opt3.isChecked()){
            Toast.makeText(MainActivity.this, "Question 4 is empty, please give an answer.", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private boolean checkQuestion5() {
        EditText nameEditText = (EditText) findViewById(R.id.founder_name);
        String editTextContents = nameEditText.getText().toString().toUpperCase();
        if (editTextContents.equals("")) {
            Toast.makeText(MainActivity.this, "Question 5 is empty, please give an answer.", Toast.LENGTH_SHORT).show();
            return true;
        } else if (editTextContents.equals("SEBASTIAN THRUN")) {
            totalScore++;
            Toast.makeText(MainActivity.this, "Question 5 is correct", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}