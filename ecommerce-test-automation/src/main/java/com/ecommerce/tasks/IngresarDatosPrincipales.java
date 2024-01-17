package com.ecommerce.tasks;

import com.ecommerce.questions.SeguroResult;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.ecommerce.userInterfaces.HomeEcommerce.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarDatosPrincipales implements Task {
    private final String nombres;
    private final String apellidoPaterno;
    private final String apellidoMaterno;
    private final String fechaNacimiento;
    private final String sexo;

    public IngresarDatosPrincipales(String nombres, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public static IngresarDatosPrincipales withData(String nombres, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String sexo) {
        return instrumented(IngresarDatosPrincipales.class, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String mensaje="";
        do{
            actor.attemptsTo(WaitUntil.the(LBL_MENSAJE, isVisible()).forNoMoreThan(40).seconds());
            mensaje = SeguroResult.mensaje().answeredBy(theActorInTheSpotlight());
            System.out.println("soy:"+mensaje);
            System.out.println("entre");
        }while(!mensaje.equals("Cuéntanos de ti") );

        actor.attemptsTo(
                Enter.theValue(nombres).into(INPUT_NOMBRES),
                Enter.theValue(apellidoPaterno).into(INPUT_AP_PATERNO),
                Enter.theValue(apellidoMaterno).into(INPUT_AP_MATERNO),
                Enter.theValue(fechaNacimiento).into(INPUT_FECHA_NACIMIENTO),
                Click.on(BTN_OPCIONES),
                Click.on(BTN_OPCION_SEXO.of(sexo)),
                Click.on(BTN_SIGUIENTE));
    }
}
