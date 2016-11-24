package com.caqmei.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void checkNumber(View view) {
        EditText numberEntered = (EditText) findViewById(R.id.number);
        if(numberEntered.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_LONG).show();
        }
        try {
            int number = Integer.parseInt(numberEntered.getText().toString());
            if(isTriangularNumber(number) && isSqureNumber(number)) {
                Toast.makeText(getApplicationContext(), numberEntered.getText().toString() +
                " is both square number and triangular number", Toast.LENGTH_LONG).show();
            } else if(isTriangularNumber(number) && !isSqureNumber(number)){
                Toast.makeText(getApplicationContext(), numberEntered.getText().toString() +
                        " is a triangular number", Toast.LENGTH_LONG).show();
            } else if(!isTriangularNumber(number) && isSqureNumber(number)) {
                Toast.makeText(getApplicationContext(), numberEntered.getText().toString() +
                        " is a square number", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), numberEntered.getText().toString() +
                        " is neither square number or triangular number", Toast.LENGTH_LONG).show();
            }

        } catch (NumberFormatException e) {
             e.getMessage();
        }
    }

    private boolean isTriangularNumber(int num) {
        int cal_num = 8 *num +1;
        int t = (int) Math.sqrt(cal_num);
        if(t*t == cal_num){
            return true;
        }
        return false;
    }
    private boolean isSqureNumber(int num) {
        int sqrt = (int) Math.sqrt(num);
        if(sqrt * sqrt == num) {
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
