package com.example.calculatorwithdagger;

//User defined class (so we can add annotations)

import javax.inject.Inject;

public class Calculator {

    private Addition addition;
    private Subtraction subtraction;
    private Multiplication multiplication;
    private Division division;

    @Inject
    public Calculator(Addition addition, Subtraction subtraction, Multiplication multiplication, Division division) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
    }

    public float addition(Float operand1, Float operand2){
        return addition.getAddition(operand1,operand2);
    }

    public float subtraction(Float operand1, Float operand2){
        return subtraction.getSubtraction(operand1,operand2);
    }

    public float multiplication(Float operand1, Float operand2){
        return multiplication.getMultiplication(operand1,operand2);
    }

    public float division(Float operand1, Float operand2){
        return division.getDivision(operand1,operand2);
    }

}
