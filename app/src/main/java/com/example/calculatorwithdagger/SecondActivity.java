package com.example.calculatorwithdagger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    TextView resultTextView;
    Button mulButton,divButton,backButton;
    @Inject
    Calculator calculator;
    Float result;
    Float num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTextView = findViewById(R.id.textView);
        mulButton = findViewById(R.id.button1);
        divButton = findViewById(R.id.button2);
        backButton = findViewById(R.id.button3);

        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null){
            num1 = intent.getFloatExtra("first_number",0.0f);
            num2 = intent.getFloatExtra("second_number",0.0f);
        } else {
            throw new ActivityNotFoundException("Insufficient Intent Extras for Second Activity.....");
        }

        CalculatorComponent calculatorComponent = ((CalculatorApplication) getApplication()).getCalculatorComponent();
        calculatorComponent.fieldInject(this);

        mulButton.setOnClickListener(this);
        divButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button1){
            result = calculator.multiplication(num1, num2);
            resultTextView.setText("Multiplication is: "+String.valueOf(result));

        } else if(view.getId() == R.id.button2){
            result = calculator.division(num1, num2);
            resultTextView.setText("Division is: "+String.valueOf(result));

        } else {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("first_number",num1);
            intent.putExtra("second_number",num2);
            startActivity(intent);
        }
    }
}