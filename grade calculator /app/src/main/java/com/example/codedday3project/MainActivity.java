package com.example.codedday3project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we are calling the edit text and buttons from xml to java so we could use it
        final EditText subname = findViewById(R.id.subname);
        final EditText homework = findViewById(R.id.hwnum);
        final EditText quizzes = findViewById(R.id.quiznum);
        final EditText finals = findViewById(R.id.finalnum);
        final EditText midterms = findViewById(R.id.midternum);
        final TextView totalgrades = findViewById(R.id.totalgrade);

        Button resets = findViewById(R.id.reset);
        Button calculate = findViewById(R.id.button);
        Button savedresults= findViewById(R.id.savedresult);
        Button settings = findViewById(R.id.settings);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write the calculations that the button will do when clicked here
                //"Double.parseDouble" is to tell java that it is a number and not a letter. we are now only changing the variable from a string to a double
                double hw= Double.parseDouble(homework.getText().toString());
                double quiz= Double.parseDouble(quizzes.getText().toString());
                double fnal= Double.parseDouble(finals.getText().toString());
                double mdtrm= Double.parseDouble(midterms.getText().toString());

                //know you can write the calculations once you changed it from strings to double
                double grade = (hw) +(quiz)+(fnal )+(mdtrm);
                char letter= letterGradeFunction(grade);
                totalgrades.setText(String.format("%.2f = %c", grade,letter));
                //Toast.makeText(MainActivity.this, "Your grade is:"+grade+"percent", Toast.LENGTH_LONG).show();

                 if (letter=='A')
                     totalgrades.setBackgroundColor(Color.BLUE);
                 else if (letter=='B')
                     totalgrades.setBackgroundColor(Color.GREEN);
                 else if (letter=='C')
                     totalgrades.setBackgroundColor(Color.YELLOW);
                 else if (letter=='D')
                     totalgrades.setBackgroundColor(Color.LTGRAY);
                 else
                    totalgrades.setBackgroundColor(Color.RED);

            }

            public char letterGradeFunction(double x)
            { if (x<60) {
                return 'F';
            }
            else if (x<70) {
                return 'D';
            }
            else if (x<80){
                return 'C';
            }
            else if (x<90){
                return 'B';
            }
            else{
                return 'A';
            }
            }
        });

        resets. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subname.setText(null);
                homework.setText(null);
                quizzes.setText(null);
                finals.setText(null);
                midterms.setText(null);
                totalgrades.setText(null);
                totalgrades.setBackgroundColor(Color.WHITE);

            }
        });


    savedresults.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, savedfiless.class));
        }
    });
    }
    }



