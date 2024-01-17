Feature: Compra de seguro por un cliente pacífico - unhappy


  @ESC01_CLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa numero de celular invalido para adquirir una poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del cliente con el numero de celular o correo invalido <celular>, <correo>
    Then se muestra el mensaje de error 'El número debe iniciar con 9 y tener 9 dígitos'

    Examples:
      | tipoDoc | celular   | correo                 | requiereUbigeo | requiereConsentimiento |
      | DNI     | 999999999 | testpacifico@gmail.com | No             | No                     |


  @ESC02_CLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa un correo invalido para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del cliente con el numero de celular o correo invalido <celular>, <correo>
    Then se muestra el mensaje de error 'El correo debe tener un formato válido'

    Examples:
      | tipoDoc | celular   | correo                  | requiereUbigeo | requiereConsentimiento |
      | CE      | 996848620 | testpacifico:@gmail.com | Si             | No                     |


  @ESC03_CLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una relación de Peso y Talla fuera de rango para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 50%, <frecuenciaPago>, donde la Relación PesoTalla es invalida <RelacionPesoTalla>
    Then se muestra el mensaje de error 'verifique que su peso y talla sean correctos'

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla        | requiereUbigeo | requiereConsentimiento |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_FUERA_RANGO_INFERIOR | Si             | Si                     |


  @ESC04_CLIENTE_ @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una tarjeta con problemas de Operación no permitida para esta tarjeta para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 7 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error No pudimos realizar el cobro
    #No pudimos realizar el cobro
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | Si                     | TC          | VISA         | 4916122919724598 |


  @ESC05_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta vencida para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Tarjeta vencida
    #Mensaje se queda tal y como esta
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | No                     | TC          | MASTERCARD   | 5455450920104193 |


  @ESC06_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una tarjeta con Fondos insuficientes para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 12 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Cobro no realizado por falta de fondos

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta     | numTarjeta      |
      | DNI      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | Si                     | TC          | AMERICAN EXPRESS | 371327381068590 |


  @ESC07_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta inválida para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 15 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Parece que la tarjeta ingresada no es válida

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | No                     | TC          | DINNERS CLUB   | 30042507084040 |


  @ESC08_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta no operativa para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 20 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Tarjeta no operativa
    #Sucedió algo inesperado
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | Si                     | TC          | UNION PAY    | 6210946888080006 |


  @ESC09_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta perdida para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 5 años
    And ingreso los datos del cliente <celular>, <correo>, 50%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Contactar con entidad emisora

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | No                     | TC          | VISA   | 4557885040264791 |


  @ESC10_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta robada para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 7 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Tarjeta robada

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | DNI      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | si                     | TC          | MASTERCARD   | 5105291169837406 |


  @ESC11_CLIENTE @UNHAPPY1
  Scenario Outline: Validar mensaje de error cuando un CLIENTE, ingresa una Tarjeta con Problemas de comunicación para adquirir su poliza
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Problemas de comunicación

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | requiereUbigeo | requiereConsentimiento | tipoTarjeta | marcaTarjeta     | numTarjeta      |
      | DNI     | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | Si             | no                     | TC          | AMERICAN EXPRESS | 349999481735341 |
