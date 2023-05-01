package com.reto.utils;

import com.github.javafaker.Faker;
import com.reto.models.User;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Generate {
    private static final Faker FAKER = new Faker(new Locale("es"));
    public static String appIdIncorrect(){
        return FAKER.bothify("99#####1");
    }

    public static String userIdIncorrect(){
        return FAKER.bothify("#########");
    }

    public static User user(){
        String email = FAKER.animal().name().trim().concat(FAKER.bothify("####"))+"@gmail.com";
        return new User(FAKER.name().firstName(), FAKER.name().lastName(), email.replaceAll("\\s",""));
    }

    public static User userWithoutEmail(){
        return new User(FAKER.name().firstName(), FAKER.name().lastName());
    }

    public static User userWithEmailIncorrect(){
        return new User(FAKER.name().firstName(), FAKER.name().lastName(), FAKER.bothify("#######"));
    }

    public static String idRandom(int id){
        Map<Integer, String> ids = new HashMap<>();
        ids.put(1,"60d0fe4f5311236168a109ca");
        ids.put(2,"60d0fe4f5311236168a109cb");
        ids.put(3,"60d0fe4f5311236168a109cc");
        ids.put(4,"60d0fe4f5311236168a109cd");
        return ids.get(id);
    }

    public static int generateNumRandom(){
        Random rand = new Random();
        int num = rand.nextInt((4 - 1) + 1) + 1;
        return num ;
    }
}
