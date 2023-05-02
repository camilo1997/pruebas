package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Generate {
    private static final Faker FAKER = new Faker(new Locale("es"));
    public static String firstName(){
        return FAKER.name().firstName();
    }
    public static String lastName(){
        return FAKER.name().lastName();
    }
    public static String email(){
        return FAKER.animal().name().concat(FAKER.bothify("####")).concat("@yopmail.com");
    }

    public static String emailIncorrect(){
        return FAKER.animal().name();
    }
    public static String idIncorrect(){
        return FAKER.bothify("#########");
    }
}
