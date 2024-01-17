package com.ecommerce.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DarConsentimiento implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_AUTORIZO_DATOS, isVisible()).forNoMoreThan(150).seconds(),
                Click.on(BTN_AUTORIZO_DATOS)
        );
    }
}
