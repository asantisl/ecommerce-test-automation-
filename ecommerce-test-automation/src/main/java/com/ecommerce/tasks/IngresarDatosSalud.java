package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosSalud implements Task {
    private final String peso;
    private final String talla;

    public IngresarDatosSalud(String peso, String talla) {
        this.peso = peso;
        this.talla = talla;
    }
    public static Performable withData(String peso, String talla) {
        return instrumented(IngresarDatosSalud.class, peso, talla);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        String mensaje = "";
        do {
            actor.attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:" + mensaje);
            System.out.println("entre");
        } while (!mensaje.contains("cuéntanos de ti"));


        actor.attemptsTo(
                WaitUntil.the(INPUT_PESO, isVisible()).forNoMoreThan(40).seconds()
                );

        INPUT_PESO.resolveFor(actor).clear();
        INPUT_PESO.resolveFor(actor).sendKeys(peso);
        INPUT_TALLA.resolveFor(actor).sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,Keys.ARROW_LEFT));
        WaitImplicitly.withSeconds(3);
        INPUT_TALLA.resolveFor(actor).sendKeys(talla);

        actor.attemptsTo(
                Click.on(BTN_SIGUIENTE)
        );
    }
}
