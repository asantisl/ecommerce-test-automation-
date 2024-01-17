package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPagoOtraTarjeta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String mensaje="";
        do{
            actor.attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!mensaje.contains("paso de empezar a ahorrar"));

        actor.attemptsTo(
                WaitUntil.the(BTN_OTRA_TARJETA, isVisible()).forNoMoreThan(40).seconds(),
                Click.on(BTN_OTRA_TARJETA)
                //WaitImplicitly.withSeconds(2)
        );

    }
}
