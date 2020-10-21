package com.example.calculatorwithdagger;

import android.util.Log;

//third party class (means non-editable class)
public class Addition {
    private static final String TAG = "teja";
    public Addition() {

    }

    public Float getAddition(Float operand1, Float operand2){
        Log.d(TAG, "getAddition: "+this.hashCode());
        return operand1 + operand2;
    }
}
