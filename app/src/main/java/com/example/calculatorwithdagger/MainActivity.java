package com.example.calculatorwithdagger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView resultTextView;
    EditText editText1,editText2;
    Button addButton,subButton,mulButton,divButton;
    @Inject Calculator calculator;
    Float result;
    Float defaultValue = 1.0f;
    Float num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        addButton = findViewById(R.id.button1);
        subButton = findViewById(R.id.button2);
        mulButton = findViewById(R.id.button3);
        divButton = findViewById(R.id.button4);

        //Calculator cal = new Calculator(new Addition(), new Subtraction(), new Multiplication(), new Division());
        CalculatorComponent calculatorComponent = DaggerCalculatorComponent.create();
        calculatorComponent.fieldInject(this);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(editText1.getText().toString().equals("")){
            num1 = defaultValue;
        } else{
            num1 = Float.parseFloat(editText1.getText().toString());
        }

        if(editText2.getText().toString().equals("")){
            num2 = defaultValue;
        } else{
            num2 = Float.parseFloat(editText2.getText().toString());
        }

        if(view.getId() == R.id.button1){
            //result = cal.addition();
            result = calculator.addition(num1, num2);
            resultTextView.setText(String.valueOf(result));

        } else if(view.getId() == R.id.button2){
            //result = cal.subtraction();
            result = calculator.subtraction(num1, num2);
            resultTextView.setText(String.valueOf(result));

        } else if(view.getId() == R.id.button3){
            //result = cal.multiplication();
            result = calculator.multiplication(num1, num2);
            resultTextView.setText(String.valueOf(result));

        } else {
            //result = cal.division();
            result = calculator.division(num1, num2);
            resultTextView.setText(String.valueOf(result));

        }
    }
}