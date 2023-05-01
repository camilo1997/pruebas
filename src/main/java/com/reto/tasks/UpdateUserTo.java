package com.reto.tasks;

import com.reto.models.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.logging.Logger;

import static com.reto.utils.Constant.APP_ID;
import static com.reto.utils.Constant.PATH_USER;

public class UpdateUserTo implements Task {
    private String idUser;
    private User user;

    private static final Logger LOGGER = Logger.getLogger(GetUserTo.class.getName());

    public UpdateUserTo(String idUser, User user) {
        this.idUser = idUser;
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Actualizando el usuario con id" + idUser);
        actor.attemptsTo(
                Put.to(PATH_USER.concat(idUser))
                        .with(requestSpecification -> requestSpecification
                                .header("app-id", APP_ID)
                                .body(user)
                                .relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
