package com.example.calculatorwithdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DivisionModule {

    @Singleton
    @Provides
    Division provideDivision(){
        return new Division();
    }
}
