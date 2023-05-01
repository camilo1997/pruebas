package com.reto.tasks.builder;

import com.reto.models.User;
import com.reto.tasks.UpdateUserTo;
import net.serenitybdd.screenplay.Tasks;

public class UpdateUser {
    private String idUser;

    public UpdateUser(String idUser) {
        this.idUser = idUser;
    }

    public static UpdateUser withId(String idUser) {
        return new UpdateUser(idUser);
    }

    public UpdateUserTo withData(User user) {
        return Tasks.instrumented(UpdateUserTo.class, idUser, user);
    }
}
