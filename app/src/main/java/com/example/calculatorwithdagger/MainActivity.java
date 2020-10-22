package com.example.calculatorwithdagger;

import android.content.Intent;
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
    Button addButton,subButton,nextButton;
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
        nextButton = findViewById(R.id.button3);

        if(getIntent() != null && getIntent().getExtras() != null){
            num1 = getIntent().getFloatExtra("first_number",0.0f);
            num2 = getIntent().getFloatExtra("second_number",0.0f);
            editText1.setText(num1.toString());
            editText2.setText(num2.toString());
        }

        CalculatorComponent calculatorComponent = ((CalculatorApplication) getApplication()).getCalculatorComponent();
        calculatorComponent.fieldInject(this);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
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
            result = calculator.addition(num1, num2);
            resultTextView.setText("Addition is: "+String.valueOf(result));

        } else if(view.getId() == R.id.button2){
            result = calculator.subtraction(num1, num2);
            resultTextView.setText("Subtraction is: "+String.valueOf(result));

        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("first_number", num1);
            intent.putExtra("second_number",num2);
            startActivity(intent);
        }
    }
}