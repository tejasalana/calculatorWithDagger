package com.example.calculatorwithdagger;

import android.util.Log;

//third party class (means non-editable class)
public class Multiplication {
    private static final String TAG = "teja";
    public Multiplication() {

    }

    public Float getMultiplication(Float operand1, Float operand2){
        Log.d(TAG, "getMultiplication: "+ this.hashCode());
        return operand1 * operand2;
    }
}
