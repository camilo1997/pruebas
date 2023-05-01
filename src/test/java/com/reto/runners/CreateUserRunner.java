package com.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.concurrency.Concurrency;
import net.thucydides.core.annotations.concurrency.ThreadCount;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_user.feature",
        glue = "com.reto.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreateUserRunner {
}
