package com.example.android.civilwarquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit(View view) {
        // onSubmit this will check question 2
        RadioGroup options = (RadioGroup) findViewById(R.id.radio);
        RadioButton question2 = (RadioButton) findViewById(options.getCheckedRadioButtonId());

        // onSubmit this will check question 4
        RadioGroup option = (RadioGroup) findViewById(R.id.radio2);
        RadioButton question4 = (RadioButton) findViewById(option.getCheckedRadioButtonId());

        int correctAnswer = 0;

        if (question2 == findViewById(R.id.america_radio_button)) correctAnswer++;

        if (question4 == findViewById(R.id.right_radio_button)) correctAnswer++;

        // onSubmit this will check question 3
        CheckBox correctA = (CheckBox) findViewById(R.id.pen);
        CheckBox correctB = (CheckBox) findViewById(R.id.tex);
        CheckBox correctC = (CheckBox) findViewById(R.id.newM);
        CheckBox correctD = (CheckBox) findViewById(R.id.britishC);

        if (correctA.isChecked() && correctB.isChecked() && correctC.isChecked() && !correctD.isChecked())
            correctAnswer++;

        // onSubmit this will check question 1
        EditText question = (EditText) findViewById(R.id.first);
        if (question.getText().toString().trim().equals("1861")) correctAnswer++;

        if(correctAnswer == 4) {
            Toast.makeText(this, "Good job Soldier! You've answered all the question correctly.", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Keep fighting you've almost got It! Your score is " + correctAnswer + " out of 4.", Toast.LENGTH_SHORT).show();
        }
    }

    // reset the score
    public void resetScore(View view) {
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.pen);
        checkBox1.setChecked(false);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.tex);
        checkBox2.setChecked(false);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.newM);
        checkBox3.setChecked(false);
        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.britishC);
        checkBox4.setChecked(false);
        final RadioGroup button1 = (RadioGroup) findViewById(R.id.radio);
        button1.clearCheck();
        final RadioGroup button2 = (RadioGroup) findViewById(R.id.radio2);
        button2.clearCheck();
        final EditText question1 = (EditText) findViewById(R.id.first);
        question1.setText("");
    }
}