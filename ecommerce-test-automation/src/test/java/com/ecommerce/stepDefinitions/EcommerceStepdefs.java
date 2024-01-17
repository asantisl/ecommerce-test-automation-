package com.ecommerce.stepDefinitions;

import com.ecommerce.questions.SeguroResult;
import com.ecommerce.tasks.*;
import com.nttdata.tdm.Do;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import com.ecommerce.util.Commons;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EcommerceStepdefs {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^que soy un (CLIENTE|NO_CLIENTE) de Pacífico$")
    public void queSoyUnCLIENTEDePacífico(String tipoCliente) {
        Commons.TIPO_CLIENTE = tipoCliente;
        theActorCalled(tipoCliente).attemptsTo(AbrirEcommerce.loginPage());
    }

    @And("^obtengo data de TDM (.*), requiere ubigeo (.*), requiere consentimiento (.*)$")
    public void obtengoDataTDM(String tipoDoc, String ubigeo, String consentimiento) {
        Commons.TIPO_DOC = tipoDoc.toUpperCase().equals("CE") ? "C.E." : tipoDoc;

        Commons.UBIGEO = ubigeo.toUpperCase().equals("SI") ? false : true;
        Commons.REQUIERE_CONSENTIMIENTO = consentimiento.toUpperCase().equals("SI") ? false : true;

        //TODO: Obtengo una lista de clientes de TDM
        //Commons.customer = Do.spGetCustomerNotCustomerByTypeDocumentAndUbigeoAndConsentimiento(tipoDoc, Commons.TIPO_CLIENTE, Commons.UBIGEO, Commons.REQUIERE_CONSENTIMIENTO);
        //Commons.customer2 = Commons.customer.get(0);

        Commons.customer2.setNumDoc("campoDelExample_numDoc");
        Commons.customer2.setUbigeo("campoDelExample_ubigeo");





/*        //TODO: Comparo que la información esté actualizada, sean iguales
        for(int i=0; i < Commons.customer.size(); i++){
            //TODO: Obtengo la información del cliente a través del servicio
            Commons.customer2 = QueryService.getCustomer(Commons.TIPO_DOC, Commons.customer.get(i).getNumDoc());
            if((Commons.customer2.getUbigeo() == null ? 0 : 1) != (Commons.customer.get(i).getUbigeo() == null ? 0 : 1)){
                continue;
            }
            if(Commons.customer2.isFlagConsentimiento() != Commons.customer.get(i).isFlagConsentimiento()){
                continue;
            }
            if(Commons.customer2.isVerificado() != Commons.customer.get(i).isVerificado()){
                continue;
            }
            //TODO: Seteo la data que cumple con el escenario
            Commons.customer2 = Commons.customer.get(i);
            break;
        }*/
    }

    @When("^intento adquirir un seguro de (.*) años$")
    public void intentoAdquirirUnSeguroIngresandoMiDocumentoDeTipoYTengoLaEdadDeAños(String aniosAhorros) {

        assert aniosAhorros.equals("5")||aniosAhorros.equals("7")||aniosAhorros.equals("10")||aniosAhorros.equals("12")||aniosAhorros.equals("15")||aniosAhorros.equals("20") : "El valor ingresado no es permitido. Los años validos son: 5, 7, 10, 12, 15, 20";

        Commons.ANIOS_AHORRO = aniosAhorros;


        //Commons.customer2.getNumDoc()
        theActorInTheSpotlight().wasAbleTo(
                IngresarDatos.withData(Commons.TIPO_DOC, Commons.customer2.getNumDoc()));

    }

    @And("^ingreso los siguientes datos del cliente (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void ingresoLosSiguientesDatos(String celular, String correo, String porcentajeDevolucion, String frecuenciaPago, String pesoTalla, String tipoTarjeta, String marcaTarjeta, String comentario) {

        if(Commons.ANIOS_AHORRO.equals("5") && Commons.FRECUENCIA_PAGO.equals("50%")){
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        }

        if (Commons.ANIOS_AHORRO.equals("7") && Commons.FRECUENCIA_PAGO.equals("100%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        }

        if (Commons.ANIOS_AHORRO.equals("10") && Commons.FRECUENCIA_PAGO.equals("100%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("10") && Commons.FRECUENCIA_PAGO.equals("120%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("10") && Commons.FRECUENCIA_PAGO.equals("150%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        }

        if (Commons.ANIOS_AHORRO.equals("12") && Commons.FRECUENCIA_PAGO.equals("100%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("12") && Commons.FRECUENCIA_PAGO.equals("120%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("12") && Commons.FRECUENCIA_PAGO.equals("150%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") : "Para 12 años de ahorro con el 150% de devolución solo se permite la opción 'Mensual - opcion 1'";

        }

        if (Commons.ANIOS_AHORRO.equals("15") && Commons.FRECUENCIA_PAGO.equals("100%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("15") && Commons.FRECUENCIA_PAGO.equals("120%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("15") && Commons.FRECUENCIA_PAGO.equals("150%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") : "Para 12 años de ahorro con el 150% de devolución solo se permite la opción 'Mensual - opcion 1'";

        }

        if (Commons.ANIOS_AHORRO.equals("20") && Commons.FRECUENCIA_PAGO.equals("100%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("20") && Commons.FRECUENCIA_PAGO.equals("120%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";

        } else if (Commons.ANIOS_AHORRO.equals("20") && Commons.FRECUENCIA_PAGO.equals("150%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("ensual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Mensual - opcion 1', 'Mensual - opcion 2' y 'Mensual - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("emestral - opcion 1") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 2") || Commons.FRECUENCIA_PAGO.contains("emestral - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Semestral - opcion 1', 'Semestral - opcion 2' y 'Semestral - opcion 3' para frecuenciaPago";
            assert Commons.FRECUENCIA_PAGO.contains("nual - opcion 1") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 2") || Commons.FRECUENCIA_PAGO.contains("nual - opcion 3") : "Para 5 años de ahorro solo se permite al 50% con las opciones 'Anual - opcion 1', 'Anual - opcion 2' y 'Anual - opcion 3' para frecuenciaPago";
        } else if (Commons.ANIOS_AHORRO.equals("20") && Commons.FRECUENCIA_PAGO.equals("200%")) {
            assert Commons.FRECUENCIA_PAGO.contains("ensual - opcion 1") : "Para 12 años de ahorro con el 150% de devolución solo se permite la opción 'Mensual - opcion 1'";

        }


        assert marcaTarjeta.equals("VISA")||marcaTarjeta.equals("MASTERCARD")||marcaTarjeta.equals("OTRO"):
                "La marca ingresada no es permitida. Las marcas permitidas son: VISA, MASTERCARD, OTRO";

        Commons.CELULAR = celular;
        Commons.CORREO = correo;
        Commons.PORCENTAJE_DEVOLUCION = porcentajeDevolucion;


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
        Commons.tarjeta = Do.spGetTarjetasByTipoMarca(tipoTarjeta, marcaTarjeta);
        Commons.marcaTarjeta = Commons.tarjeta.get(0).getMarca();

        if ((Commons.marcaTarjeta.equals("VISA")) || (Commons.marcaTarjeta.equals("MASTERCARD"))) {
            theActorInTheSpotlight().wasAbleTo(
                    RealizarPago.withData(Commons.tarjeta));
        }else if (Commons.marcaTarjeta.equals("OTRO")) {
            theActorInTheSpotlight().wasAbleTo(new RealizarPagoOtraTarjeta());
        }
    }


    @And("^ingreso los siguientes datos del no cliente (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void ingresoLosSiguientesDatosNoCliente(String nombres, int edad, String sexo, String celular, String correo, String porcentajeDevolucion, String frecuenciaPago, String pesoTalla, String tipoTarjeta, String marcaTarjeta, String comentario) {

        /*assert marcaTarjeta.equals("VISA")||marcaTarjeta.equals("MASTERCARD")||marcaTarjeta.equals("AMERICAN EXPRESS")||marcaTarjeta.equals("DINNERS CLUB")||marcaTarjeta.equals("UNION PAY"):
                "La marca ingresada no es permitida. Las marcas permitidas son: VISA, MASTERCARD, AMERICAN EXPRESS, DINNERS CLUB Y UNION PAY";
        */

        assert marcaTarjeta.equals("VISA")||marcaTarjeta.equals("MASTERCARD")||marcaTarjeta.equals("OTRO"):
                "La marca ingresada no es permitida. Las marcas permitidas son: VISA, MASTERCARD, OTRO";

        Commons.CELULAR = celular;
        Commons.CORREO = correo;
        Commons.PORCENTAJE_DEVOLUCION = porcentajeDevolucion;

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
        Commons.tarjeta = Do.spGetTarjetasByTipoMarca(tipoTarjeta, marcaTarjeta);

        Commons.marcaTarjeta = Commons.tarjeta.get(0).getMarca();

        if ((Commons.marcaTarjeta.equals("VISA")) || (Commons.marcaTarjeta.equals("MASTERCARD"))) {
            theActorInTheSpotlight().wasAbleTo(
                    RealizarPago.withData(Commons.tarjeta));
        }else if (Commons.marcaTarjeta.equals("OTRO")) {
            theActorInTheSpotlight().wasAbleTo(new RealizarPagoOtraTarjeta());
        }
    }

    @Then("^la operación de compra es satisfactoria$")
    public void laOperaciónDeCompraEsSatisfactoria() {

        if ((Commons.marcaTarjeta.equals("VS")) || (Commons.marcaTarjeta.equals("MC"))) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RESULT_MENSAJE, isVisible()).forNoMoreThan(40).seconds()
        );

        if (RESULT_MENSAJE.isVisibleFor(theActorInTheSpotlight())) {
            theActorInTheSpotlight().should(
                  seeThat(SeguroResult.resultText(), containsString("ya estás asegurado!"))
            );
        }


        } else if (Commons.marcaTarjeta.equals("OTRO")) {
            for (String winHandle : getDriver().getWindowHandles()) {
                getDriver().switchTo().window(winHandle);
            }
            theActorInTheSpotlight().should(seeThat(SeguroResult.mensajeesperadoOtro(), containsString("Nos gustaría")));
            theActorInTheSpotlight().attemptsTo(
                    Click.on(BTN_ACEPTAR)
            );
            theActorInTheSpotlight().should(seeThat(SeguroResult.mensajeesperadoOtro(), equalTo("¡Gracias!")));
            theActorInTheSpotlight().attemptsTo(
                    Click.on(BTN_ACEPTAR)
            );
        }
    }

}


