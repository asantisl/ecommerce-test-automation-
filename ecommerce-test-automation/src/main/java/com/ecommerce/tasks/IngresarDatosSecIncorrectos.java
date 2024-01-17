package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosSecIncorrectos implements Task {
    private final String celular;
    private final String correo;
    private final String tipoCorreo;

    public IngresarDatosSecIncorrectos(String celular, String correo, String tipoCorreo) {
        this.celular = celular;
        this.correo = correo;
        this.tipoCorreo = tipoCorreo;
    }
    public static Performable withData(String celular, String correo, String tipoCorreo) {
        return instrumented(IngresarDatosSecIncorrectos.class, celular, correo, tipoCorreo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(INPUT_CELULAR, isVisible()).forNoMoreThan(40).seconds(),
                Enter.theValue(celular).into(INPUT_CELULAR),
                Enter.theValue(correo).into(INPUT_CORREO)
        );

        if (!(tipoCorreo.equals("gmail.com")||tipoCorreo.equals("hotmail.com")||tipoCorreo.equals("outlook.com")||tipoCorreo.equals("yahoo.com")||tipoCorreo.equals("icloud.com")) ){
            actor.attemptsTo(
                    Click.on(BTN_OPCIONES),
                    Click.on(BTN_OPCION_CORREO.of("Otro")),
                    Enter.theValue("@" + tipoCorreo).into(INPUT_OTRO_CORREO)
            );
        }else {
            actor.attemptsTo(
                    Click.on(BTN_OPCIONES),
                    Click.on(BTN_OPCION_CORREO.of("@" + tipoCorreo))
            );
        }
    }

}
