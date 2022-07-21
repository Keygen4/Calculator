package ru.gudkov.calculator.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ru.gudkov.calculator.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Boolean isNew = true;
    String firstNumber;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.answer);


    }

    public void clickNumber(View view) {
        if (isNew)
            textView.setText("");
        isNew = false;
        String number = textView.getText().toString();
        switch (view.getId()){

            case R.id.key_1: number = number + "1"; break;
            case R.id.key_2: number = number + "2"; break;
            case R.id.key_3: number = number + "3"; break;
            case R.id.key_4: number = number + "4"; break;
            case R.id.key_5: number = number + "5"; break;
            case R.id.key_6: number = number + "6"; break;
            case R.id.key_7: number = number + "7"; break;
            case R.id.key_8: number = number + "8"; break;
            case R.id.key_9: number = number + "9"; break;
            case R.id.key_0: number = number + "0"; break;
            case R.id.key_00: number = number + "00"; break;
            case R.id.key_dot: number = number + "."; break;
        }
        textView.setText(number);
    }

    public void clickAction(View view) {
        isNew = true;
         firstNumber = textView.getText().toString();
         String operation = textView.getText().toString();
        switch (view.getId()){
            case R.id.key_minus: operator = "-"; break;
            case R.id.key_plus: operator = "+" ; break;
            case R.id.key_dimention: operator = "/" ; break;
            case R.id.key_multiplication: operator = "*" ; break;
            case R.id.key_percent: operator = "%" ; break;
        }

    }

    public void clickEqual(View view) {
        String secondNumber = textView.getText().toString();
        Double answer = 0.0;
        switch (operator) {

            case "-": answer = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber); break;
            case "+": answer = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber); break;
            case "/": answer = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber); break;
            case "*": answer = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber); break;
            case "%": answer = (Double.parseDouble(firstNumber))/100 * (Double.parseDouble(secondNumber)); break;
        }

            textView.setText(answer + "");
    }

    public void clickClear(View view) {
        textView.setText(R.string.defaultAnswerValue);
        isNew = true;

    }
}