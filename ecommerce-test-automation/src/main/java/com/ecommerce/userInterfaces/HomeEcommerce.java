package com.ecommerce.userInterfaces;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeEcommerce extends PageObject {

    /* #########Pagina de Inicio######## */
    public static final Target BTN_OPCION_DOC = Target.the("Boton Selecionar una Opcion")
            .locatedBy("//li/button[text()='{0}']");

    public static final Target BTN_ELEGIR = Target.the("Tipo Documento")
            .located(By.xpath("//button[@class='banner__form__dropdown__btn']"));
    public static final Target INPUT_DOC = Target.the("Numero Documento")
            .located(By.xpath("//input[@id='documentId']"));
    public static final Target BTN_INICIAR = Target.the("Btn Elegir mi Seguro")
            .located(By.xpath("//button[@id='quoteBtn']"));

    /* #########1ra Pagina de Datos Personales######## */
    public static final Target INPUT_NOMBRES = Target.the("Nombres")
            .located(By.xpath("//input[@id='names']"));
    public static final Target INPUT_AP_PATERNO = Target.the("Apellido Paterno")
            .located(By.xpath("//input[@id='firstSurname']"));
    public static final Target INPUT_AP_MATERNO = Target.the("Apellido Materno")
            .located(By.xpath("//input[@id='lastSurname']"));
    public static final Target INPUT_FECHA_NACIMIENTO = Target.the("Fecha de Nacimiento")
            .located(By.xpath("//input[@placeholder='dd/mm/yyyy']"));
    public static final Target BTN_OPCION_SEXO = Target.the("Boton Selecionar Tipo Sexo")
            .locatedBy("//*[text()='{0}']");

    /* #########2da Pagina de Datos Personales######## */
    public static final Target LBL_MENSAJE = Target.the("Mensaje Esperado Datos Sec")
            .located(By.xpath("(//h3)[1]"));
    public static final Target INPUT_CELULAR = Target.the("Numero Celular")
            .located(By.xpath("//input[@id='cel']"));
    public static final Target INPUT_CORREO = Target.the("Correo")
            .located(By.xpath("//input[@id='emailUser']"));
    public static final Target BTN_OPCIONES = Target.the("Btn Elegir tipo de Sexo/Correo")
            .located(By.xpath("//*[@data-testid='chevron']"));
    public static final Target BTN_OPCION_CORREO = Target.the("Boton Selecionar una Opcion")
            .locatedBy("//li[text()='{0}']");
    public static final Target INPUT_OTRO_CORREO = Target.the("Input de otro Servicio Correo")
            .located(By.xpath("//input[@id='emailDomain']"));
    public static final Target BTN_SIGUIENTE = Target.the("Boton Siguiente")
            .located(By.xpath("//button[text()='Siguiente']"));
    public static final Target BTN_AUTORIZO_DATOS = Target.the("Boton Autorizo Uso de Datos")
            .located(By.xpath("//label[@for='acceptData']"));

    /* ###### Pagina Calculo de Ahorro ################### */
    //public static final Target BTN_ANO_AHORRO = Target.the("Boton Años de Ahorro")
    //        .located(By.xpath("//input[@id='period-years']"));
    public static final Target BTN_ANOS_AHORROS= Target.the("Boton Años de Ahorro")
            .locatedBy("//*[@class='period-numbers']/p[text()='{0}']");
    public static final Target BTN_PORCENTAJE = Target.the("Boton Porcentaje de Ahorro")
            .locatedBy("//label[text()='{0}']");
    public static final Target BTN_FRECUENCIA = Target.the("Boton Frecuencia de Ahorro")
            .locatedBy("//input[@value='{0}']");
    public static final Target BTN_TARIFA = Target.the("Boton Tarifa de Ahorro")
            .locatedBy("(//div[@class='card-plan'])[{0}]");

    /* ###### Pagina Sobre tu Salud ################### */
    public static final Target INPUT_PESO = Target.the("Correo")
            .located(By.xpath("//input[@id='weight']"));
    public static final Target INPUT_TALLA = Target.the("Correo")
            .located(By.xpath("//input[@id='height']"));

    /* ###### Pagina Sobre tu Direccion ################### */
    public static final Target LBL_DIRECCION = Target.the("Mensaje de Dirección")
            .located(By.xpath("//h3[@class='addressModal__title']"));
    public static final Target INPUT_UBIGEO = Target.the("Ubigeo")
            .located(By.xpath("//input[@id='ubigeo']"));
    public static final Target BTN_CIUDAD = Target.the("Ciudad")
            .located(By.xpath("(//li[@data-testid='option'])[1]"));

    public static final Target INPUT_CALLE = Target.the("Dirección")
            .located(By.xpath("//input[@id='address']"));
    public static final Target BTN_CONTINUAR = Target.the("Boton de Continuar")
            .located(By.xpath("//button[text()='Continuar']"));


    /* ###### Pagina de Pago ################### */

    public static final Target BTN_VISA = Target.the("Boton Tarjeta Visa")
            .located(By.xpath("//label[@for='payment-method-0']"));
    public static final Target BTN_MASTERCARD = Target.the("Boton Tarjeta Mastercard")
            .located(By.xpath("//label[@for='payment-method-1']"));
    public static final Target BTN_OTRA_TARJETA = Target.the("Boton Tarjeta Otra")
            .located(By.xpath("//label[@for='payment-method-2']"));
    public static final Target BTN_PAGAR_TARIFA = Target.the("Boton Pagar Tarifa")
            .located(By.xpath("//button[@type='submit']"));
    public static final Target BTN_NO_OBLIGACIONES = Target.the("Boton No Obligaciones")
            .located(By.xpath("//label[@for='obligations-0']"));
    public static final Target LBL_OTRO_PAGO = Target.the("Mensaje Esperado por Otro Pago")
            .located(By.xpath("//h3[@class='title']"));
    public static final Target BTN_ACEPTAR = Target.the("Boton de Aceptar Otro Pago")
            .located(By.xpath("//button[text()='Aceptar']"));


    /* ###### PAGINA DE INGRESO DE TARJETA SISTEMA NO EMBEBIDO################### */
    public static final Target INPUT_TARJETA = Target.the("Tarjeta de Pago")
            .located(By.xpath("//input[@id='number']"));
    public static final Target INPUT_FECHA_EXPIRACION = Target.the("Fecha de Expiración")
            .located(By.xpath("//input[@id='expiry']"));
    public static final Target INPUT_CCV = Target.the("CVV")
            .located(By.xpath("//input[@id='cvc']"));
    public static final Target BTN_PAGAR = Target.the("Boton Pagar")
            .located(By.xpath("//button[text()='Pagar']"));

    /* ###### PAGINA DE INGRESO DE TARJETA SISTEMA EMBEBIDO NIUBIZ################### */
    public static final Target INPUT_TARJETA_N = Target.the("Tarjeta de Pago")
            .located(By.xpath("//input[@id='cc-number']"));
    public static final Target INPUT_FECHA_EXPIRACION_N = Target.the("Fecha de Expiración")
            .located(By.xpath("//input[@id='cc-exp']"));
    public static final Target INPUT_CCV_N = Target.the("CVV")
            .located(By.xpath("//input[@id='cc-cvc']"));
    public static final Target BTN_PAGAR_N = Target.the("Boton Pagar")
            .located(By.xpath("//button[@type='button']"));

    public static final Target IFRAME = Target.the("Seleccionar Iframe")
            .locatedBy("(//iframe[@name='card'])[{0}]");
    public static final Target IFRAME1 = Target.the("Seleccionar Iframe")
            .locatedBy("(//iframe[@name='card'])[1]");

    /*################MENSAJES ESPERADOS###############*/
    public static final Target RESULT_MENSAJE = Target.the("Mensaje de Validacion")
            .located(By.xpath("//h4/strong"));

    public static final Target LBL_MONTO_PRIMA = Target.the("Monto prima seleccionada")
            .locatedBy("(//h3[@class='amount'])[{0}]");

    public static final Target LBL_TOTAL_PRIMA = Target.the("Monto total de devolucion")
            .locatedBy("(//p[@Class='devolution'])[{0}]");
    public static final Target LBL_MONTO_DEVOLUCION = Target.the("Monto devolucion")
            .locatedBy("(//div[@class='ui-radio-buttom'])[{0}]");
    public static final Target LBL_RESUMEN_PAGO = Target.the("Resumen de Monto Prima")
            .located(By.xpath("//span[@class='summary-card__content-devolution__value']"));
    public static final Target LBL_RESUMEN_TOTAL = Target.the("Resumen del Monto total de devolucion")
            .located(By.xpath("//span[@class='summary-card__content-amount']"));
    public static final Target LBL_CELULAR = Target.the("Resumen de celular")
            .located(By.xpath("//div[@class='summary-content__data']/ul[1]/li[1]"));
    public static final Target LBL_CORREO = Target.the("Resumen de  Correo")
            .located(By.xpath("//div[@class='summary-content__data']/ul[1]/li[2]"));
    public static final Target LBL_ANIOS_AHORRO = Target.the("Resumen de Años de Ahorro")
            .located(By.xpath("//div[@class='summary-content__data']/ul[2]/li[1]"));
    public static final Target LBL_PORCENTAJE = Target.the("Resumen de porcentaje de Ahorro")
            .located(By.xpath("//div[@class='summary-content__data']/ul[2]/li[2]"));
    public static final Target LBL_DEVOLUCION = Target.the("Resumen del Monto de devolucion")
            .located(By.xpath("//div[@class='summary-content__data']/ul[2]/li[3]"));
    public static final Target LBL_FRECUENCIA = Target.the("Resumen de Frecuencia")
            .located(By.xpath("//div[@class='summary-content__data']/ul[2]/li[4]"));
    public static final Target LBL_PESO = Target.the("Resumen del Peso")
            .located(By.xpath("//div[@class='summary-content__data']/ul[3]/li[1]"));
    public static final Target LBL_TALLA = Target.the("Resumen de la Talla")
            .located(By.xpath("//div[@class='summary-content__data']/ul[3]/li[2]"));


    //################### CASOS UNHAPPY ###################
    public static final Target LBL_DOCUMENTO_INVALIDO = Target.the("Documento invalido")
            .located(By.xpath("//p[@class='error-document']"));

    public static final Target LBL_CELULAR_INVALIDO = Target.the("Celular invalido")
            .located(By.xpath("(//div[@class='ui-input__error'])[1]"));
    public static final Target LBL_CORREO_INVALIDO = Target.the("Correo invalido")
            .located(By.xpath("(//div[@class='ui-input__error'])[3]"));
    public static final Target LBL_PESOTALLA_INVALIDO = Target.the("Relacion Peso y Talla invalido")
            .located(By.xpath("//p[@class='modal-info__title']"));
    public static final Target LBL_EDAD_INVALIDA = Target.the("Edad invalido")
            .located(By.xpath("//span[@class='error-message']"));
    public static final Target BTN_REGRESAR = Target.the("Boton Regresar")
            .located(By.xpath("//button[@class='button-up button-active']"));
    public static final Target LBL_VENCIMIENTO_INVALIDO = Target.the("Vencimiento de Tarjeta inválida")
            .located(By.xpath("//small[normalize-space()='El vencimiento de su tarjeta no es válido.']"));
    public static final Target LBL_MENSAJE_ERROR = Target.the("Mensaje de Error de Compra")
            .located(By.xpath("//h5[@class='state-page__title']"));
}


