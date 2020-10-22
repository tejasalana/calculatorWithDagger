package com.example.calculatorwithdagger;

import android.app.Application;

public class CalculatorApplication extends Application {

    CalculatorComponent calculatorComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        calculatorComponent = DaggerCalculatorComponent.create();
    }

    public CalculatorComponent getCalculatorComponent(){
        return calculatorComponent;
    }
}
