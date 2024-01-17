package com.ecommerce.stepDefinitions;

import com.ecommerce.questions.SeguroResult;
import com.ecommerce.tasks.*;
import com.ecommerce.util.Commons;
import com.nttdata.tdm.Do;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.anyOf;

public class EcommerceUnhappyStepdefs {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^intento ingresar mi numero de documento incompleto$")
    public void intentoIngresarMiNumeroDeDocumentoIncompleto() {

        String numIncorrecto = Commons.customer2.getNumDoc().substring(0,7);

        theActorInTheSpotlight().wasAbleTo(
                IngresarDatos.withData(Commons.TIPO_DOC, numIncorrecto));
    }

    @Then("^se muestra el mensaje de error 'Documento no es valido'$")
    public void seMuestraElMensajeDeError() {

        theActorInTheSpotlight().should(
                seeThat(SeguroResult.documentoIncorrecto(), equalTo("Documento no es valido")));
    }

    @And("^ingreso los siguientes datos del cliente con el numero de celular o correo invalido (.*), (.*)$")
    public void ingresoElSiguienteNúmeroDeCelularInvalidoCelular(String celular, String correo) {
        String[] parts = correo.split("@");

        String mensaje="";
        do{
            try {
                theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
                mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
                System.out.println("soy:" + mensaje);
                System.out.println("entre");
            }catch (Throwable e){
                mensaje="";
            }

        }while(!(mensaje.contains("cuéntanos de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        if (mensaje.contains("Vamos a diseñar tu plan")) {
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR));
        }
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSecIncorrectos.withData(celular, parts[0], parts[1]));
    }

    @Then("^se muestra el mensaje de error 'El número debe iniciar con 9 y tener 9 dígitos'$")
    public void seMuestraElMensajeDeErrorElNúmeroDebeIniciarConYTenerDígitos() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LBL_CELULAR_INVALIDO, isVisible()).forNoMoreThan(40).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat(SeguroResult.celularIncorrecto(), equalTo("El número debe iniciar con 9 y tener 9 dígitos")));
    }

    @Then("^se muestra el mensaje de error 'El correo debe tener un formato válido'$")
    public void seMuestraElMensajeDeErrorElCorreoDebeTenerUnFormatoVálido() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LBL_CORREO_INVALIDO, isVisible()).forNoMoreThan(40).seconds()
        );
        theActorInTheSpotlight().should(
                seeThat(SeguroResult.correoIncorrecto(),containsString("El correo debe tener un formato válido")));
    }

    @And("^ingreso los siguientes datos del cliente (.*), (.*), (.*), (.*), donde la Relación PesoTalla es invalida (.*)$")
    public void ingresoLosSiguientesDatosDelCliente(String celular, String correo, String porcentajeDevolucion, String frecuenciaPago, String pesoTalla) {
        String[] parts = correo.split("@");
        String[] frecs = frecuenciaPago.split(" - opc ");
        String frecuencia = frecs[0].substring(0, 1).toUpperCase() + frecs[0].substring(1).toLowerCase();

        //Thread.sleep(3000);

        String mensaje="";
        do{
            try {
                theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
                mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
                System.out.println("soy:" + mensaje);
                System.out.println("entre");
            }catch (Throwable e){
                mensaje="";
            }

        }while(!(mensaje.contains("cuéntanos de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("cuéntanos de ti")) {
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));
        }

        if (mensaje.contains("Vamos a diseñar tu plan")) {
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR),
                    IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));
        }

        //TODO: Paso 2
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosAhorro.withData(Commons.ANIOS_AHORRO, porcentajeDevolucion, frecuencia, frecs[1]));

        //TODO: Paso 3
        //TODO: Obtengo información de peso y talla de TDM
        Commons.pesoTalla = Do.spGetPesosTallas(pesoTalla);
        Commons.PESO = Commons.pesoTalla.get(0).getPeso();
        Commons.TALLA = Commons.pesoTalla.get(0).getTalla();
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSalud.withData(String.valueOf(Commons.PESO), String.valueOf(Commons.TALLA)));
    }

    @Then("^se muestra el mensaje de error 'verifique que su peso y talla sean correctos'$")
    public void seMuestraElMensajeDeErrorVerifiqueQueSuPesoYTallaSeanCorrectos() {
        for (String winHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandle);
        }
        theActorInTheSpotlight().should(seeThat(SeguroResult.pesoTallaIncorrecto(), containsString("verifique que su peso y talla sean correctos")));
    }

    @And("^ingreso los datos del cliente (.*), (.*), (.*), (.*), (.*), (.*), (.*), con número de Tarjeta (.*)$")
    public void ingresoLosSiguientesDatosDelClientesConNumeroTarjeta(String celular, String correo, String porcentajeDevolucion, String frecuenciaPago, String pesoTalla, String tipoTarjeta, String marcaTarjeta, String numTarjeta) {

        assert marcaTarjeta.equals("VISA")||marcaTarjeta.equals("MASTERCARD")||marcaTarjeta.equals("AMERICAN EXPRESS")||marcaTarjeta.equals("DINNERS CLUB")||marcaTarjeta.equals("UNION PAY"):
                "La marca ingresada no es permitida. Las marcas permitidas son: VISA, MASTERCARD, AMERICAN EXPRESS, DINNERS CLUB Y UNION PAY";

        Commons.CELULAR = celular;
        Commons.CORREO = correo;
        Commons.PORCENTAJE_DEVOLUCION = porcentajeDevolucion;
        Commons.marcaTarjeta = marcaTarjeta;


        String[] parts = correo.split("@");
        String[] frecs = frecuenciaPago.split(" - opc ");
        Commons.FRECUENCIA_PAGO = frecs[0].substring(0, 1).toUpperCase() + frecs[0].substring(1).toLowerCase();

        //Thread.sleep(3000);

        String mensaje="";
        do{
            try {
                theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
                mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
                System.out.println("soy:" + mensaje);
                System.out.println("entre");
            }catch (Throwable e){
                mensaje="";
            }

        }while(!(mensaje.contains("cuéntanos de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("Vamos a diseñar tu plan")){
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR)
            );
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));
        }

        if (mensaje.contains("cuéntanos de ti")) {
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));
        }
        //TODO: Paso 2
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosAhorro.withData(Commons.ANIOS_AHORRO, porcentajeDevolucion, Commons.FRECUENCIA_PAGO, frecs[1]));

        //TODO: Paso 3
        //TODO: Obtengo información de peso y talla de TDM
        Commons.pesoTalla = Do.spGetPesosTallas(pesoTalla);
        Commons.PESO = Commons.pesoTalla.get(0).getPeso();
        Commons.TALLA = Commons.pesoTalla.get(0).getTalla();
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSalud.withData(String.valueOf(Commons.PESO), String.valueOf(Commons.TALLA)));


        //TODO: Paso 3.1
        if (Commons.UBIGEO == false) {
            if (LBL_DIRECCION.isVisibleFor(theActorInTheSpotlight())) {
                Commons.ubigeo = Do.spGetUbigeos();
                String calle = "Calle los girasoles 251";
                theActorInTheSpotlight().wasAbleTo(
                        IngresarUbigeo.withData(Commons.ubigeo.get(0).getCiudad().trim(), calle));
            }
        }

        //TODO: Paso 4
        //TODO: Obtengo una TARJETA
        String fecha_expedicion= "";
        String ccv = "";

        switch (Commons.marcaTarjeta) {
            case "VISA":
            case "MASTERCARD":
                    fecha_expedicion= "03/2028";
                    ccv = "111";
                    theActorInTheSpotlight().wasAbleTo(
                            RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                //}
                break;
            case "AMERICAN EXPRESS":
                fecha_expedicion= "01/2024";
                ccv = "111";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
            case "DINNERS CLUB":
                fecha_expedicion= "05/2024";
                ccv = "111";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
            case "UNION PAY":
                fecha_expedicion= "10/2030";
                ccv = "123";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
        }

    }

    @Then("^se muestra el siguiente mensaje de error (.*)$")
    public void seMuestraElMensajeDeErrorOperaciónNoPermitidaParaEstaTarjeta(String mensajeError) {

        Serenity.setSessionVariable("MsjTarjetaVencida").to(mensajeError);

        if (mensajeError.equals("Tarjeta Vencida")){
            theActorInTheSpotlight().should(
                    seeThat(SeguroResult.vecimientoInvalido(),containsString("El vencimiento de su tarjeta")));
        } else {
            theActorInTheSpotlight().attemptsTo(
                    WaitUntil.the(LBL_MENSAJE_ERROR, isVisible()).forNoMoreThan(40).seconds()
            );
            theActorInTheSpotlight().should(
                    seeThat(SeguroResult.mensajePagoError(), anyOf(containsString(mensajeError), containsString("sucedió algo inesperado")) ));
        }

    }

    //TODO: STEPDEFINITIONS PARA NO CLIENTE
    @And("^ingreso los siguientes datos del no cliente con el numero de celular o correo invalido (.*), (.*), (.*), (.*), (.*)$")
    public void ingresoUnNúmeroDeCelularInvalidoNombresFechacumpleañosSexoCelularCorreo(String nombres, int edad, String sexo, String celular, String correo) {
        String[] names = nombres.split(" ");
        String genero = sexo.substring(0, 1).toUpperCase() + sexo.substring(1).toLowerCase();

        //TODO: Obtener fecha de Nacimiento
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = fechaActual.minusYears(edad);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = fechaNac.format(formatter);

        String[] parts = correo.split("@");

        String mensaje="";
        do{
            theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!(mensaje.contains("Cuéntanos de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("Cuéntanos de ti")){
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosPrincipales.withData(names[0], names[1], names[2], fechaNacimiento, genero));
        }

        if (mensaje.contains("Vamos a diseñar tu plan")) {
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR));
        }
        //TODO: Paso 1.1
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSecIncorrectos.withData(celular, parts[0], parts[1]));
    }

    @And("^ingreso los siguientes datos del no cliente (.*), (.*), (.*), (.*), (.*), (.*), (.*), con relación PesoTalla invalido (.*)$")
    public void ingresoLosSiguientesDatosDelNoClienteConRelaciónPesoTallaInvalido(String nombres, int edad, String sexo, String celular, String correo, String porcentajeDevolucion, String frecuenciaPago, String pesoTalla) {
        String[] names = nombres.split(" ");
        String[] frecs = frecuenciaPago.split(" - opc ");
        String frecuencia = frecs[0].substring(0, 1).toUpperCase() + frecs[0].substring(1).toLowerCase();
        String genero = sexo.substring(0, 1).toUpperCase() + sexo.substring(1).toLowerCase();

        //TODO: Obtener fecha de Nacimiento
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = fechaActual.minusYears(edad);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = fechaNac.format(formatter);

        String[] parts = correo.split("@");

        String mensaje="";
        do{
            theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!(mensaje.contains("de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("Cuéntanos de ti")){
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosPrincipales.withData(names[0], names[1], names[2], fechaNacimiento, genero));
        }

        if (mensaje.contains("Vamos a diseñar tu plan")) {
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR));
        }
        //TODO: Paso 1.1
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));

        //TODO: Paso 2
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosAhorro.withData(Commons.ANIOS_AHORRO, porcentajeDevolucion, frecuencia, frecs[1]));

        //TODO: Paso 3
        //TODO: Obtengo información de peso y talla de TDM
        Commons.pesoTalla = Do.spGetPesosTallas(pesoTalla);
        Commons.PESO = Commons.pesoTalla.get(0).getPeso();
        Commons.TALLA = Commons.pesoTalla.get(0).getTalla();
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSalud.withData(String.valueOf(Commons.PESO), String.valueOf(Commons.TALLA)));
    }

    @And("^ingreso los datos del no cliente (.*), (.*), (.*), (.*), (.*), (.*), (.*), con número de Tarjeta (.*)$")
    public void ingresoLosDatosDelNoClienteConNúmeroDeTarjetaNumTarjeta(String celular, String correo, String porcentaje, String frecuenciaPago, String pesoTalla, String tipoTarjeta, String marcaTarjeta, String numTarjeta) {

        assert marcaTarjeta.equals("VISA")||marcaTarjeta.equals("MASTERCARD")||marcaTarjeta.equals("AMERICAN EXPRESS")||marcaTarjeta.equals("DINNERS CLUB")||marcaTarjeta.equals("UNION PAY"):
                "La marca ingresada no es permitida. Las marcas permitidas son: VISA, MASTERCARD, AMERICAN EXPRESS, DINNERS CLUB Y UNION PAY";

        String nombres = "Alejandra Ramos Souza";
        int edad = 20;
        String sexo = "femenino";

        Commons.CELULAR = celular;
        Commons.CORREO = correo;
        Commons.PORCENTAJE_DEVOLUCION = porcentaje;

        String[] names = nombres.split(" ");
        String genero = sexo.substring(0, 1).toUpperCase() + sexo.substring(1).toLowerCase();

        //TODO: Obtener fecha de Nacimiento
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = fechaActual.minusYears(edad);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = fechaNac.format(formatter);

        String[] parts = correo.split("@");

        String[] frecs = frecuenciaPago.split(" - opc ");
        Commons.FRECUENCIA_PAGO = frecs[0].substring(0, 1).toUpperCase() + frecs[0].substring(1).toLowerCase();

        String mensaje="";
        do{
            theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!(mensaje.contains("de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("Cuéntanos de ti")){
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosPrincipales.withData(names[0], names[1], names[2], fechaNacimiento, genero));
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(Commons.CELULAR, parts[0], parts[1]));
        }
        //TODO: Paso 1.1

        if (mensaje.contains("cuéntanos de ti")) {
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(Commons.CELULAR, parts[0], parts[1]));
        }

        if (mensaje.contains("Vamos a diseñar tu plan")){
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR)
            );
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosSecundarios.withData(celular, parts[0], parts[1]));
        }

        //TODO: Paso 2
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosAhorro.withData(Commons.ANIOS_AHORRO, Commons.PORCENTAJE_DEVOLUCION, Commons.FRECUENCIA_PAGO, frecs[1]));

        //TODO: Paso 3
        //TODO: Obtengo información de peso y talla de TDM
        Commons.pesoTalla = Do.spGetPesosTallas(pesoTalla);
        Commons.PESO = Commons.pesoTalla.get(0).getPeso();
        Commons.TALLA = Commons.pesoTalla.get(0).getTalla();
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatosSalud.withData(String.valueOf(Commons.PESO), String.valueOf(Commons.TALLA)));


        //TODO: Paso 3.1
        if (Commons.UBIGEO == false) {
            if (LBL_DIRECCION.isVisibleFor(theActorInTheSpotlight())) {
                Commons.ubigeo = Do.spGetUbigeos();
                String calle = "Calle los girasoles 251";
                theActorInTheSpotlight().wasAbleTo(
                        IngresarUbigeo.withData(Commons.ubigeo.get(0).getCiudad().trim(), calle));
            }
        }

        //TODO: Paso 4
        //TODO: Obtengo una TARJETA
        String fecha_expedicion= "";
        String ccv = "";
        Commons.marcaTarjeta = marcaTarjeta;

        switch (Commons.marcaTarjeta) {
            case "VISA":
            case "MASTERCARD":
                fecha_expedicion= "03/2028";
                ccv = "111";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
            case "AMERICAN EXPRESS":
                fecha_expedicion= "01/2024";
                ccv = "111";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
            case "DINNERS CLUB":
                fecha_expedicion= "05/2024";
                ccv = "111";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
            case "UNION PAY":
                fecha_expedicion= "10/2030";
                ccv = "123";
                theActorInTheSpotlight().wasAbleTo(
                        RealizarPagoErroneo.withData(numTarjeta, fecha_expedicion, ccv));
                break;
        }

    }

    @Then("^se muestra el mensaje de error 'Edad inválida o fuera de rango'$")
    public void seMuestraElMensajeDeErrorEdadInválidaOFueraDeRango() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LBL_EDAD_INVALIDA, isVisible()).forNoMoreThan(40).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(SeguroResult.edadIncorrecta(),containsString("Edad inválida o fuera de rango")));
    }

    @And("^ingreso los siguientes datos del no cliente (.*), con una edad fuera de rango (.*), (.*)$")
    public void ingresoLosSiguientesDatosDelNoClienteNombresConUnaEdadFueraDeRangoEdadSexo(String nombres, int edad, String sexo) {
        String[] names = nombres.split(" ");
        String genero = sexo.substring(0, 1).toUpperCase() + sexo.substring(1).toLowerCase();

        //TODO: Obtener fecha de Nacimiento
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNac = fechaActual.minusYears(edad);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimiento = fechaNac.format(formatter);

        String mensaje="";
        do{
            theActorInTheSpotlight().attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");

        }while(!(mensaje.contains("Cuéntanos de ti") || mensaje.equals("Vamos a diseñar tu plan")));

        //TODO: Paso 1
        if (mensaje.contains("Cuéntanos de ti")){
            theActorInTheSpotlight().wasAbleTo(
                   IngresarDatosPrincipales.withData(names[0], names[1], names[2], fechaNacimiento, genero));
        }

        if (mensaje.contains("Vamos a diseñar tu plan")) {
            theActorInTheSpotlight().wasAbleTo(
                    Click.on(BTN_REGRESAR));
            theActorInTheSpotlight().wasAbleTo(
                    WaitUntil.the(BTN_REGRESAR, isVisible()).forNoMoreThan(40).seconds(),
                    Click.on(BTN_REGRESAR));
            theActorInTheSpotlight().wasAbleTo(
                    IngresarDatosPrincipales.withData(names[0], names[1], names[2], fechaNacimiento, genero));
        }


    }
}
