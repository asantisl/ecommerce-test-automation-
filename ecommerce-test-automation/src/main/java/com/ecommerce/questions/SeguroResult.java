package com.ecommerce.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


import static com.ecommerce.userInterfaces.HomeEcommerce.*;

public class SeguroResult {
    public static Question<String> resultText() {

        return actor -> Text.of(RESULT_MENSAJE).answeredBy(actor);
    }

    public static Question<String> mensaje() {
        return actor -> TextContent.of(LBL_MENSAJE).answeredBy(actor);
    }
    public static Question<String> mensajeesperadoOtro() {

        return actor -> Text.of(LBL_OTRO_PAGO).answeredBy(actor);
    }

    public static Question<String> documentoIncorrecto() {

        return actor -> Text.of(LBL_DOCUMENTO_INVALIDO).answeredBy(actor);
    }
    public static Question<String> celularIncorrecto() {

        return actor -> Text.of(LBL_CELULAR_INVALIDO).answeredBy(actor);
    }
    public static Question<String> correoIncorrecto() {

        return actor -> Text.of(LBL_CORREO_INVALIDO).answeredBy(actor);
    }
    public static Question<String> pesoTallaIncorrecto() {

        return actor -> Text.of(LBL_PESOTALLA_INVALIDO).answeredBy(actor);
    }
    public static Question<String> edadIncorrecta() {

        return actor -> Text.of(LBL_EDAD_INVALIDA).answeredBy(actor);
    }
    public static Question<String> vecimientoInvalido() {

        return actor -> Text.of(LBL_VENCIMIENTO_INVALIDO).answeredBy(actor);
    }
    public static Question<String> mensajePagoError() {

        return actor -> Text.of(LBL_MENSAJE_ERROR).answeredBy(actor);
    }

}
