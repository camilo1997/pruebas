package com.reto.stepdefinitions;

import com.reto.models.User;
import com.reto.questions.GetLastResponse;
import com.reto.tasks.CreateUser;
import com.reto.utils.Generate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CreateUserStep {
    private User user;
    @When("I create user with data ok")
    public void iCreateUserWithDataOk() {
        user = Generate.user();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(user));
    }

    @Then("I see user data")
    public void iSeeUserData() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString(user.getEmail()),
                Matchers.containsString(user.getFirstName()),
                Matchers.containsString(user.getLastName())
        )));
    }
}
