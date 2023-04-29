package com.reto.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Generate {
    private static final Faker FAKER = new Faker(new Locale("es"));
    public static String appIdIncorrect(){
        return FAKER.bothify("99#####1");
    }
}
