package com.reto.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.logging.Logger;

public class GetUserTo implements Task {
    private String path;
    private String appId;
    private static final Logger LOGGER = Logger.getLogger(GetUserTo.class.getName());

    public GetUserTo(String path, String appId) {
        this.path = path;
        this.appId = appId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Obteniendo todos los usuarios");
        actor.attemptsTo(
                Get.resource(path)
                        .with(requestSpecification -> requestSpecification.header("app-id", appId))
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
