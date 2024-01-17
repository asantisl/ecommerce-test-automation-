package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import com.ecommerce.util.Commons;
import com.nttdata.tdm.model.Tarjetas;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;

import java.util.List;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPago implements Task {
    private final Tarjetas tarjeta;

    public RealizarPago(Tarjetas tarjeta) {
        this.tarjeta = tarjeta;
    }
    public static RealizarPago withData(List<Tarjetas> tarjeta) {

        return instrumented(RealizarPago.class, tarjeta.get(0));
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        String mensaje="";
        do{
            actor.attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!mensaje.contains("paso de empezar a ahorrar"));

        //TODO: VALIDAR QUE LA POLIZA ADQUIRIDA SEA LA MISMA A PAGAR
        Commons.RESUMEN_PAGO = LBL_RESUMEN_PAGO.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_PAGO_TOTAL = LBL_RESUMEN_TOTAL.resolveFor(actor).waitUntilVisible().getText();

//        Commons.RESUMEN_PAGO_TOTAL = resumen_pago_total.replace("S/\n ","").trim();

        Commons.RESUMEN_CELULAR = LBL_CELULAR.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_CORREO = LBL_CORREO.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_ANIOS_AHORRO = LBL_ANIOS_AHORRO.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_PORCENTAJE = LBL_PORCENTAJE.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_DEVOLUCION = LBL_DEVOLUCION.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_FRECUENCIA = LBL_FRECUENCIA.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_PESO = LBL_PESO.resolveFor(actor).waitUntilVisible().getText();
        Commons.RESUMEN_TALLA = LBL_TALLA.resolveFor(actor).waitUntilVisible().getText();

        String resumenPago = Commons.MONTO_PAGO.replace(",","");


        String primeros_tres = Commons.CORREO.substring(0, 3);
//        int arroba_index = Commons.CORREO.indexOf("@");
//        String despues_arroba = Commons.CORREO.substring(arroba_index);

        String formato_celular = Commons.CELULAR.substring(Commons.CELULAR.length()-4);


        Assert.assertTrue("Monto Pago inválido",Commons.RESUMEN_PAGO.contains(resumenPago));
        Assert.assertTrue("Monto Total Devolución inválido",Commons.RESUMEN_PAGO_TOTAL.contains(Commons.TOTAL_DEVOLUCION));

        Assert.assertTrue("Resumen Celular inválido",Commons.RESUMEN_CELULAR.contains(formato_celular));
        Assert.assertTrue("Resumen Correo inválido",Commons.RESUMEN_CORREO.contains(primeros_tres));
        Assert.assertTrue("Resumen Años de Ahorro inválido",Commons.RESUMEN_ANIOS_AHORRO.contains(Commons.ANIOS_AHORRO));
        Assert.assertTrue("Resumen Porcentaje inválido",Commons.RESUMEN_PORCENTAJE.contains(Commons.PORCENTAJE_DEVOLUCION));
        Assert.assertTrue("Resumen Devolución inválido",Commons.RESUMEN_DEVOLUCION.contains(Commons.MONTO_DEVOLUCION));
        Assert.assertTrue("Resumen Frecuencia inválido",Commons.RESUMEN_FRECUENCIA.contains(Commons.FRECUENCIA_PAGO));
        Assert.assertTrue("Resumen Peso inválido",Commons.RESUMEN_PESO.contains(String.valueOf(Commons.PESO)));
        Assert.assertTrue("Resumen Talla inválido",Commons.RESUMEN_TALLA.contains(String.valueOf(Commons.TALLA)));

                if (tarjeta.getMarca().toUpperCase().equals("VISA")) {
                    actor.attemptsTo(
                            WaitUntil.the(BTN_VISA, isVisible()).forNoMoreThan(40).seconds(),
                            Click.on(BTN_VISA));
                } else if (tarjeta.getMarca().toUpperCase().equals("MASTERCARD")) {
                    actor.attemptsTo(
                            WaitUntil.the(BTN_MASTERCARD, isVisible()).forNoMoreThan(20).seconds(),
                            Click.on(BTN_MASTERCARD));
                }

                /*TODO:SISTEMA EMBEBIDO DE NIUBIZ

                // Acceder al primer y segundo iframe
                for (int i = 1; i <= 3; i++) {

                    if (i == 1) {
                        WebElementFacade iframe = IFRAME.of(String.valueOf(i)).resolveFor(actor);

                        actor.attemptsTo(WaitUntil.the(IFRAME1, isVisible()).forNoMoreThan(60).seconds());

                        actor.attemptsTo(Switch.toFrame(iframe));

                        //INGRESA TARJETA
                        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(0, 4)).into(INPUT_TARJETA_N));
                        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(4, 8)).into(INPUT_TARJETA_N));
                        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(8, 12)).into(INPUT_TARJETA_N));
                        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(12, 16)).into(INPUT_TARJETA_N));

                        INPUT_TARJETA_N.resolveFor(actor).sendKeys(tarjeta.getNumero());

                        actor.attemptsTo(Switch.toDefaultContext());
                    }

                    if (i == 2) {
                        WebElementFacade iframe = IFRAME.of(String.valueOf(i)).resolveFor(actor);
                        actor.attemptsTo(Switch.toFrame(iframe));
                        //INGRESA FECHA DE VENCIMIENTO
                        actor.attemptsTo(SendKeys.of(tarjeta.getVencimiento().substring(0, 2)).into(INPUT_FECHA_EXPIRACION_N));
                        actor.attemptsTo(SendKeys.of(tarjeta.getVencimiento().substring(3, 7)).into(INPUT_FECHA_EXPIRACION_N));

                        actor.attemptsTo(Switch.toDefaultContext());
                    }

                    if (i == 3) {
                        WebElementFacade iframe = IFRAME.of(String.valueOf(i)).resolveFor(actor);
                        actor.attemptsTo(Switch.toFrame(iframe));
                        actor.attemptsTo(
                                Enter.theValue(tarjeta.getCvv()).into(INPUT_CCV_N));

                        actor.attemptsTo(Switch.toDefaultContext());
                    }
                } */


                //TODO: FIN SISTEMA EMBEBIDO DE NIUBIZ

                actor.attemptsTo(Click.on(BTN_NO_OBLIGACIONES));

                actor.attemptsTo(
                    Click.on(BTN_PAGAR_TARIFA));

                /*actor.attemptsTo(
                        Click.on(BTN_PAGAR_N));*/



        //TODO: PAGO CON MODAL DE NIUBIZ
        //Cambiar al marco que contiene el HTML
        actor.attemptsTo(Switch.toFrame("visaNetJS"));

        //TODO: INGRESA TARJETA
        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(0,4)).into(INPUT_TARJETA));
        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(4,8)).into(INPUT_TARJETA));
        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(8,12)).into(INPUT_TARJETA));
        actor.attemptsTo(SendKeys.of(tarjeta.getNumero().substring(12,16)).into(INPUT_TARJETA));

        //TODO: INGRESA FECHA DE VENCIMIENTO
        actor.attemptsTo(SendKeys.of(tarjeta.getVencimiento().substring(0,2)).into(INPUT_FECHA_EXPIRACION));
        actor.attemptsTo(SendKeys.of(tarjeta.getVencimiento().substring(3,7)).into(INPUT_FECHA_EXPIRACION));

        actor.attemptsTo(
                Enter.theValue(tarjeta.getCvv()).into(INPUT_CCV));


        actor.attemptsTo(
                Click.on(BTN_PAGAR)
        );

    }
}

