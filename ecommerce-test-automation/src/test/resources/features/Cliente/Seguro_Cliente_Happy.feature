@CLIENTES_HAPPY
Feature: Compra de seguro por un cliente pacífico


  @ESC01_CLIENTE_ @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 5 años y 50% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 50%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                   | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | requiereUbigeo | requiereConsentimiento | comentario                                  |
#      | DNI     | 996848620 | testPacifico@gmail.com   | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA             | No             | Si                     | Seguro de 5 años - 50% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@hotmail.com | semestral - opc 1 | IMC_INTERMEDIO    | TC          | MASTERCARD       | No             | No                  | Seguro de 5 años - 50% - Semestral - opción 1 |
      | DNI     | 996848620 | testPacifico@outlook.com | Anual - opc 1   | IMC_INTERMEDIO    | TC          | OTRO | Si             | Si                     | Seguro de 5 años - 50% - Anual - opción 1   |


  @ESC02_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 7 años y 100% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 7 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                     |
#      | CE      | 996848620 | testPacifico@yahoo.com  | Mensual - opc 1   | IMC_INTERMEDIO      | TC          | VISA         | No             | No            | Seguro de 7 años - 100% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_SUPERIOR | TC          | MASTERCARD         | No             | Si                     | Seguro de 7 años - 100% - Semestral - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | Anual - opc 1     | IMC_INTERMEDIO      | TC          | OTRO         | Si             | No                    | Seguro de 7 años - 100% - Anual - opción 1|


  @ESC03_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 10 años y 100% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                   | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@gmail.com   | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA             | No             | Si                     | Seguro de 10 años - 100% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@hotmail.com | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | No             | No                    | Seguro de 10 años - 100% - Semestral - opción 1|
      | DNI     | 996848620 | testPacifico@outlook.com | anual - opc 1   | IMC_INTERMEDIO    | TC          | OTRO | Si             | Si                     | Seguro de 10 años - 100% - Anual - opción 1   |


  @ESC04_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 10 años y 120% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                      |
#      | CE      | 996848620 | testPacifico@yahoo.com  | mensual - opc 1   | IMC_INTERMEDIO      | TC          | VISA         | No             | No            | Seguro de 10 años - 120% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_SUPERIOR | TC          | MASTERCARD         | No             | Si                     | Seguro de 10 años - 120% - Semestral - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | anual - opc 1     | IMC_INTERMEDIO      | TC          | OTRO         | Si             | No                    | Seguro de 10 años - 120% - Anual - opción 1 |


  @ESC05_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 10 años y 150% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA   | No             | Si                     | Seguro de 10 años - 150% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@yahoo.com  | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | No             | No          | Seguro de 10 años - 150% - Semestral - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | anual - opc 1   | IMC_INTERMEDIO    | TC          | OTRO | Si             | Si                     | Seguro de 10 años - 150% - Anual - opción 1   |


  @ESC06_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 12 años y 100% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 12 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                      |
#      | CE      | 996848620 | testPacifico@yahoo.com  | mensual - opc 1   | IMC_INTERMEDIO      | TC          | VISA         | No             | No              | Seguro de 12 años - 100% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_SUPERIOR | TC          | MASTERCARD         | No             | Si                     | Seguro de 12 años - 100% - Semestral - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | anual - opc 1     | IMC_INTERMEDIO      | TC          | OTRO         | Si             | No            | Seguro de 12 años - 100% - Anual - opción 1 |


  @ESC07_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 12 años y 120% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA | No             | Si                     | Seguro de 12 años - 120% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@yahoo.com  | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | No             | No                 | Seguro de 12 años - 120% - Semestral - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | anual - opc 1   | IMC_INTERMEDIO    | TC          | OTRO             | Si             | Si                     | Seguro de 12 años - 120% - Anual - opción 1   |


  @ESC08_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 12 años y 150% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 12 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular | correo | frecuenciaPago | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario |
#      | CE      | 996848620 | testPacifico@yahoo.com | mensual - opc 1 | IMC_LIMITE_INFERIOR | TC          | VISA         | No             | No                     | Seguro de 12 años - 150% - Mensual - opción 1 |


  @ESC09_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 15 años y 100% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | mensual - opc 1 | IMC_INTERMEDIO    | TC          | MASTERCARD   | No             | Si                     | Seguro de 15 años - 100% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@yahoo.com  | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | OTRO         | No             | No       | Seguro de 15 años - 100% - Semestral - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | anual - opc 1   | IMC_INTERMEDIO    | TC          | VISA | Si             | Si                     | Seguro de 15 años - 100% - Anual - opción 1   |


  @ESC10_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 15 años y 120% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                      |
#      | CE      | 996848620 | testPacifico@yahoo.com  | mensual - opc 1   | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | No             | No                     | Seguro de 15 años - 120% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_SUPERIOR | TC          | OTRO         | No             | Si                     | Seguro de 15 años - 120% - Semestral - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | anual - opc 1     | IMC_LIMITE_INFERIOR | TC          | VISA         | Si             | No             | Seguro de 15 años - 120% - Anual - opción 1 |


  @ESC11_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 15 años y 150% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | MASTERCARD | No             | Si                     | Seguro de 15 años - 150% - Mensual - opción 1 |


  @ESC12_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 20 años y 100% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                      |
#      | CE      | 996848620 | testPacifico@yahoo.com  | mensual - opc 1   | IMC_LIMITE_INFERIOR | TC          | OTRO         | No             | No           | Seguro de 20 años - 100% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | VISA         | No             | Si                     | Seguro de 20 años - 100% - Semestral - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | anual - opc 1     | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | Si             | No                     | Seguro de 20 años - 100% - Anual - opción 1 |


  @ESC13_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 20 años y 120% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | mensual - opc 1 | IMC_INTERMEDIO    | TC          | OTRO   | No             | Si                     | Seguro de 20 años - 120% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@yahoo.com  | Semestral - opc 1 | IMC_LIMITE_INFERIOR | TC          | VISA         | No             | No                     | Seguro de 20 años - 120% - Semestral - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | anual - opc 1   | IMC_INTERMEDIO    | TC          | MASTERCARD | No             | Si                     | Seguro de 20 años - 120% - Anual - opción 1   |


  @ESC14_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 20 años y 150% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla   | tipoTarjeta | marcaTarjeta | requiereUbigeo | requiereConsentimiento | comentario                                    |
#      | CE      | 996848620 | testPacifico@yahoo.com  | mensual - opc 1   | IMC_LIMITE_INFERIOR | TC          | OTRO         | No             | No                     | Seguro de 20 años - 150% - Mensual - opción 1 |
      | DNI     | 996848620 | testPacifico@icloud.com | Semestral - opc 1 | IMC_LIMITE_SUPERIOR | TC          | VISA         | No             | Si                     | Seguro de 20 años - 150% - Mensual - opción 1 |
#      | CE      | 996848620 | testPacifico@zohoo.com  | anual - opc 1     | IMC_LIMITE_INFERIOR | TC          | MASTERCARD   | Si             | No                     | Seguro de 20 años - 150% - Mensual - opción 1 |


  @ESC15_CLIENTE @HAPPY1
  Scenario Outline: Validar que un CLIENTE pueda adquirir un seguro, a 20 años y 200% de devolución
    Given que soy un CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo <requiereUbigeo>, requiere consentimiento <requiereConsentimiento>
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del cliente <celular>, <correo>, 200%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | celular   | correo                  | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | requiereUbigeo | requiereConsentimiento | comentario                                    |
      | DNI     | 996848620 | testPacifico@icloud.com | mensual - opc 1 | IMC_INTERMEDIO    | TC          | OTRO | No             | Si                     | Seguro de 20 años - 200% - Mensual - opción 1 |
