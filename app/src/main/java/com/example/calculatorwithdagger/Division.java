package com.example.calculatorwithdagger;

//third party class (means non-editable class)
public class Division {

    public Division() {

    }

    public Float getDivision(Float operand1, Float operand2){
        if(operand2 == 0){
            return 0.0f;
        } else {
            return operand1 / operand2;
        }
    }
}
