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

    @When("I create user with email already used")
    public void iCreateUserWithEmailAlreadyUsed() {
        user = Generate.user();
        user.setEmail("test@test.com");
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(user));
    }

    @When("I create user without email")
    public void iCreateUserWithoutEmail() {
        user = Generate.userWithoutEmail();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUser.withData(user));
    }
    @When("I create user without email incorrect")
    public void iCreateUserWithoutEmailIncorrect() {
        user = Generate.userWithEmailIncorrect();
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

    @Then("I see that error message email already used")
    public void iSeeThatErrorMessageEmailAlreadyUsed() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString("BODY_NOT_VALID"),
                Matchers.containsString("Email already used")
        )));
    }

    @Then("I see that error message email is required")
    public void iSeeThatErrorMessageEmailIsRequired() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString("BODY_NOT_VALID"),
                Matchers.containsString("Path `email` is required")
        )));
    }

    @Then("I see that error message email is invalid")
    public void iSeeThatErrorMessageEmailIsInvalid() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.allOf(
                Matchers.containsString("BODY_NOT_VALID"),
                Matchers.containsString("Path `email` is invalid")
        )));
    }
}
