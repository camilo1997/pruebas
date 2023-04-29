package com.reto.stepdefinitions;

import com.reto.models.User;
import com.reto.questions.GetLastResponse;
import com.reto.questions.GetUserId;
import com.reto.tasks.CreateUser;
import com.reto.tasks.builder.UpdateUser;
import com.reto.utils.Generate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class UpdateUserStep {
    private User newUser;
    @When("I update user existing")
    public void iUpdateUserExisting() {
        User user = Generate.user();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(user));
        newUser = Generate.user();
        String idUser = OnStage.theActorInTheSpotlight().asksFor(GetUserId.ofLastResponse());
        OnStage.theActorInTheSpotlight().remember("idUser", idUser);
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.withId(idUser).withData(newUser));
    }

    @When("I update user not existing")
    public void iUpdateUserNotExisting() {
        User user = Generate.user();
        OnStage.theActorInTheSpotlight().attemptsTo(UpdateUser.withId(Generate.userIdIncorrect()).withData(user));
    }
    @Then("I see new user data")
    public void iSeeNewUserData() {
        String idUser = OnStage.theActorInTheSpotlight().recall("idUser").toString();
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString(idUser),
                Matchers.containsString(newUser.getFirstName()),
                Matchers.containsString(newUser.getLastName())
        )));
    }
}
