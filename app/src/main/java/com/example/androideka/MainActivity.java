package com.example.androideka;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editFirstNumber, editSecondNumber;

    private Button plusButton, minusButton, multiplyButton, divideButton;
    private TextView textSeeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFirstNumber = findViewById(R.id.editFirstNumber);
        editSecondNumber = findViewById(R.id.editSecondNumber);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        textSeeResult = findViewById(R.id.textSeeResult);

        plusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateResult('+');
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateResult('-');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateResult('/');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateResult('X');
            }
        });
    }

    private void calculateResult(char operator) {
        double num1 = Double.parseDouble(editFirstNumber.getText().toString());
        double num2 = Double.parseDouble(editSecondNumber.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case 'X':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textSeeResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        textSeeResult.setText(String.valueOf(result));
    }
}