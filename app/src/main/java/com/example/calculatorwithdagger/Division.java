package com.example.calculatorwithdagger;

import android.util.Log;

//third party class (means non-editable class)
public class Division {
    private static final String TAG = "teja";
    public Division() {

    }

    public Float getDivision(Float operand1, Float operand2){
        Log.d(TAG, "getDivision: " + this.hashCode());
        if(operand2 == 0){
            return 0.0f;
        } else {
            return operand1 / operand2;
        }
    }
}
