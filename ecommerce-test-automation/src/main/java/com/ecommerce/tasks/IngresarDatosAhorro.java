package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import com.ecommerce.userInterfaces.HomeEcommerce;
import com.ecommerce.util.Commons;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosAhorro implements Task {
    private final String añosAhorros;
    private final String porcentajeDevolucion;
    private final String frecuenciaPago;
    private final String opcionTarifa;


    public IngresarDatosAhorro(String aniosAhorros, String porcentajeDevolucion, String frecuenciaPago, String opcionTarifa) {
        this.añosAhorros = aniosAhorros;
        this.porcentajeDevolucion = porcentajeDevolucion;
        this.frecuenciaPago = frecuenciaPago;
        this.opcionTarifa = opcionTarifa;
    }
    public static IngresarDatosAhorro withData(String aniosAhorros, String porcentajeDevolucion, String frecuenciaPago, String opcionTarifa) {
        return instrumented(IngresarDatosAhorro.class, aniosAhorros, porcentajeDevolucion, frecuenciaPago, opcionTarifa);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String mensaje="";
        do{
            try {
                actor.attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
                mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
                System.out.println("soy:" + mensaje);
                System.out.println("entre");
            }catch (Throwable e){
                mensaje="";
            }
        }while(!mensaje.equals("Vamos a diseñar tu plan"));

        Actions actions = new Actions(BrowseTheWeb.as(actor).getDriver());
        actions.moveToElement(BTN_ANOS_AHORROS.of(añosAhorros).resolveFor(actor)).moveByOffset(5, -30).click().build().perform();
        actor.attemptsTo(
                Click.on(BTN_PORCENTAJE.of(porcentajeDevolucion)),
                Click.on(BTN_FRECUENCIA.of(frecuenciaPago)),
                Click.on(BTN_TARIFA.of(opcionTarifa)));

        WebElementFacade element1 = LBL_MONTO_PRIMA.of(opcionTarifa).resolveFor(actor);
        WebElementFacade element2 = LBL_TOTAL_PRIMA.of(opcionTarifa).resolveFor(actor);
        WebElementFacade element3 = LBL_MONTO_DEVOLUCION.of(opcionTarifa).resolveFor(actor);


        String monto_pago = element1.waitUntilVisible().getText();
        String total_devolucion = element2.waitUntilVisible().getText();
        String monto_devolucion = element3.waitUntilVisible().getText();

        if(Commons.FRECUENCIA_PAGO.toUpperCase().contains("MENSUAL")) Commons.MONTO_PAGO = monto_pago.replace("\nPago mensual","").trim();
        if(Commons.FRECUENCIA_PAGO.toUpperCase().contains("SEMESTRAL")) Commons.MONTO_PAGO = monto_pago.replace("\nPago semestral","").trim();
        if(Commons.FRECUENCIA_PAGO.toUpperCase().contains("ANUAL")) Commons.MONTO_PAGO = monto_pago.replace("\nPago anual","").trim();

        Commons.TOTAL_DEVOLUCION = total_devolucion.replace("Te devolveremos s/","").trim(); //1950
        Commons.MONTO_DEVOLUCION = monto_devolucion.replace("Protegerás a tu familia por: s/","").trim(); //100,000


        //System.out.println("monto prima:" + Commons.MONTO_PAGO);
        //System.out.println("Total prima:"+ Commons.TOTAL_DEVOLUCION);

        actor.attemptsTo(
                Click.on(BTN_SIGUIENTE)
        );
    }
}
