package com.ecommerce.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.Keys.ENTER;

public class IngresarUbigeo implements Task {
    private final String ciudad;
    private final String direccion;
    public IngresarUbigeo(String ciudad, String direccion) {
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
    public static Performable withData(String ciudad, String direccion) {
        return instrumented(IngresarUbigeo.class, ciudad, direccion);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        /*Set<String> currentHandle = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
        List<String> handles = new ArrayList<>(currentHandle);

        actor.attemptsTo(Switch.toWindow(handles.get(1)));*/

        /*for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }*/

        actor.attemptsTo(
                WaitUntil.the(INPUT_UBIGEO, isVisible()).forNoMoreThan(40).seconds(),
                WaitImplicitly.withSeconds(3),
                Enter.theValue(ciudad).into(INPUT_UBIGEO),
                Click.on(BTN_CIUDAD),
                Enter.theValue(direccion).into(INPUT_CALLE)
        );

        actor.attemptsTo(
                Click.on(BTN_CONTINUAR));
    }
}
