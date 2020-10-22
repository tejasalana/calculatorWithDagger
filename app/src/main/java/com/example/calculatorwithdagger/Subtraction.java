package com.example.calculatorwithdagger;

import android.util.Log;

//third party class (means non-editable class)
public class Subtraction {
    private static final String TAG = "teja";
    public Subtraction() {

    }

    public Float getSubtraction(Float operand1, Float operand2){
        Log.d(TAG, "getSubtraction: " + this.hashCode());
        return operand1 - operand2;
    }
}
