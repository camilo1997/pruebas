package com.reto.stepdefinitions;

import com.reto.models.User;
import com.reto.questions.GetLastResponse;
import com.reto.questions.GetUserId;
import com.reto.tasks.CreateUser;
import com.reto.tasks.DeleteUser;
import com.reto.utils.Generate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class DeleteUserStep {
    @When("I delete user existing")
    public void iDeleteUserExisting() {
        User user = Generate.user();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(user));
        String idUser = OnStage.theActorInTheSpotlight().asksFor(GetUserId.ofLastResponse());
        OnStage.theActorInTheSpotlight().remember("idUser", idUser);
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.withIdUser(idUser));
    }

    @When("I delete user that not exist")
    public void iDeleteUserThatNotExist() {
        String idUser = Generate.userIdIncorrect();
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.withIdUser(idUser));
    }

    @Then("I see that id user")
    public void iSeeThatIdUser() {
        String idUser = OnStage.theActorInTheSpotlight().recall("idUser").toString();
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.containsString(idUser)));
    }
}
