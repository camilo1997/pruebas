package com.reto.stepdefinitions;

import com.reto.questions.GetFirstId;
import com.reto.questions.GetLastResponse;
import com.reto.questions.GetStatusCode;
import com.reto.tasks.builder.GetUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static com.reto.utils.Constant.*;
import static com.reto.utils.Generate.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GetUserStep {

    private String path = "";

    @Given("I have acces to the service")
    public void iHaveAccesToTheService() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").whoCan(CallAnApi.at(URL));
    }

    @When("I get all users")
    public void iGetAllUsers() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER).andAppId(APP_ID));
    }

    @When("I get all users with appid incorrect")
    public void iGetAllUsersWithAppidIncorrect() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER).andAppId(appIdIncorrect()));
    }

    @When("I get user by id")
    public void iGetUserById() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER).andAppId(APP_ID));
        String idUser = OnStage.theActorInTheSpotlight().asksFor(GetFirstId.toAllUsers());
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath(PATH_USER.concat(idUser)).andAppId(APP_ID));
    }

    @When("I get user by id incorrect")
    public void iGetUserByIdIncorrect() {
        path = PATH_USER.concat(userIdIncorrect());
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath(path).andAppId(APP_ID));
    }

    @When("I get all users with path incorrect")
    public void iGetAllUsersWithPathIncorrect() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.withPath("users").andAppId(APP_ID));
    }

    @Then("I see the response code {int}")
    public void iSeeTheResponseCode(Integer response) {
        OnStage.theActorInTheSpotlight().should(seeThat(GetStatusCode.response(), Matchers.equalTo(response)));
    }

    @Then("I see that the answer is not empty")
    public void iSeeThatTheAnswerIsNotEmpty() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.containsString("id")));
    }

    @Then("I see that message error id not exist")
    public void iSeeThatMessageErrorIdNotExist() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.containsString("APP_ID_NOT_EXIST")));
    }

    @Then("I see that message params not valid")
    public void iSeeThatMessageParamsNotValid() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.containsString("PARAMS_NOT_VALID")));
    }
    @Then("I see that message error path not found")
    public void iSeeThatMessageErrorPathNotFound() {
        OnStage.theActorInTheSpotlight().should(seeThat(GetLastResponse.ofResponse(), Matchers.containsString("PATH_NOT_FOUND")));
    }
}
