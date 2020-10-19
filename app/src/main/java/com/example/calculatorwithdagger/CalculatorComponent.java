package com.example.calculatorwithdagger;

import javax.inject.Singleton;

import dagger.Component;

@Component (modules = { AdditionModule.class, SubtractionModule.class, MultiplicationModule.class, DivisionModule.class} )
@Singleton
public interface CalculatorComponent {

    void fieldInject(MainActivity mainActivity);

}
