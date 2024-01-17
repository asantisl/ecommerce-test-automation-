package com.ecommerce.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatos implements Task {
    private final String tipoDoc;
    private final String numDoc;


    public IngresarDatos(String tipoDoc, String numDoc) {
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
    }

    public static IngresarDatos withData(String tipoDoc, String numDoc) {
        return instrumented(IngresarDatos.class, tipoDoc, numDoc);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_ELEGIR, isVisible()).forNoMoreThan(40).seconds(),
                Click.on(BTN_ELEGIR),
                Click.on(BTN_OPCION_DOC.of(tipoDoc)),
                Enter.theValue(numDoc).into(INPUT_DOC)
        );

        actor.attemptsTo(
                Click.on(BTN_INICIAR));

    }

}
