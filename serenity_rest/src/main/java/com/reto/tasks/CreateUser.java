package com.reto.tasks;

import com.reto.models.User;
import com.reto.utils.Generate;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.logging.Logger;

import static com.reto.utils.Constant.APP_ID;
import static com.reto.utils.Constant.PATH_USER_CREATE;

public class CreateUser implements Task {

    private User user;
    private static final Logger LOGGER = Logger.getLogger(GetUserTo.class.getName());

    public CreateUser(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Creando el usuario");

        actor.attemptsTo(Post.to(PATH_USER_CREATE).with(
                requestSpecification -> requestSpecification.header("","")
                        .body(user).relaxedHTTPSValidation()
        ));
        SerenityRest.lastResponse().prettyPrint();
    }

    public static CreateUser withData(User user) {
        return Tasks.instrumented(CreateUser.class, user);
    }
}
