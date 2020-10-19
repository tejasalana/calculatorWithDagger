package com.example.calculatorwithdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AdditionModule {

    @Provides
    @Singleton
    Addition provideAddition(){
        return new Addition();
    }
}
