package com.example.calculatorwithdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MultiplicationModule {

    @Singleton
    @Provides
    Multiplication provideMultiplication(){
        return new Multiplication();
    }
}
