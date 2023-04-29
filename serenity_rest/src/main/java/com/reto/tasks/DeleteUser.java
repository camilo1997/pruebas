package com.reto.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.logging.Logger;

import static com.reto.utils.Constant.*;

public class DeleteUser implements Task {
    private String idUser;
    private static final Logger LOGGER = Logger.getLogger(GetUserTo.class.getName());

    public DeleteUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Eliminando el usuario con id "+idUser);
        actor.attemptsTo(
                Delete.from(PATH_USER.concat(idUser)).with(
                        requestSpecification -> requestSpecification
                                .header("app-id", APP_ID)
                                .relaxedHTTPSValidation()
                )
        );
        SerenityRest.lastResponse().prettyPrint();
    }

    public static DeleteUser withIdUser(String idUser){
        return Tasks.instrumented(DeleteUser.class, idUser);
    }
}
