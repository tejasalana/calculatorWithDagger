package com.example.calculatorwithdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SubtractionModule {

    @Singleton
    @Provides
    Subtraction provideSubtraction(){
        return new Subtraction();
    }
}
