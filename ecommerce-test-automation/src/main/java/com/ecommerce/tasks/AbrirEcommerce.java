package com.ecommerce.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirEcommerce implements Task {
    private final String url;
    EnvironmentVariables environmentVariables;

    public AbrirEcommerce(String url) {
        this.url = url;
    }

    public static Task loginPage() {
        String url = "ecommerce.page";
        return instrumented(AbrirEcommerce.class, url);
    }

    @Override
    @Step("{0} Inicia la página #url")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(url)));

        Serenity.setSessionVariable("ambiente").to(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("bpi.environment"));
    }
}
