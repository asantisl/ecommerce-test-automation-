Feature: Compra de seguro por un No cliente pacífico

  @ESC16_NOCLIENTE_
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 29-33, a 5 años y 50% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del no cliente <nombres>, <edad>, <sexo>, <celular>, <correo>, 50%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | edad | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                  |
      | CE      | Victor Rosales Gomez  | 30   | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA         | Seguro de 5 años - 50% - Mensual - opción 2 |
      | DNI     | Carmen Aguirre Huaman | 31   | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD         | Seguro de 5 años - 50% - Semestral - opción 2 |
      | CE      | Rosa Souza Venegas    | 32   | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO   | Seguro de 5 años - 50% - Anual - opción 2 |


  @ESC17_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 34-38, a 7 años y 100% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 7 años
    And ingreso los siguientes datos del no cliente <nombres>, <edad>, <sexo>, <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | edad | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                   |
      | DNI     | Carmen Aguirre Huaman | 35   | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA | Seguro de 7 años - 100% - Mensual - opción 1 |
      | CE      | Victor Aguirre Huaman | 36   | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD     | Seguro de 7 años - 100% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 37   | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO             | Seguro de 7 años - 100% - Anual - opción 1 |


  @ESC18_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 39-43, a 10 años y 100% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                    |
      | CE      | Victor Rosales Gomez  | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA             | Seguro de 10 años - 100% - Mensual - opción 1 |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD       | Seguro de 10 años - 100% - Semestral - opción 1 |
      | CE      | Rosa Souza Venegas    | 10/06/2000      | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          |OTRO | Seguro de 10 años - 100% - Anual - opción 1 |


  @ESC19_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 44-48, a 10 años y 120% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                    |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA | Seguro de 10 años - 120% - Mensual - opción 1 |
      | CE      | Victor Aguirre Huaman | 10/06/2000      | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD         | Seguro de 10 años - 120% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 11/07/2000      | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO         | Seguro de 10 años - 120% - Anual - opción 1 |


  @ESC20_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 49-53, a 10 años y 150% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                    |
      | CE      | Victor Rosales Gomez  | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA       | Seguro de 10 años - 150% - Mensual - opción 1 |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD | Seguro de 10 años - 150% - Semestral - opción 1 |
      | CE      | Rosa Souza Venegas    | 10/06/2000      | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO     | Seguro de 10 años - 150% - Anual - opción 1 |


  @ESC21_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 54-58, a 12 años y 100% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 10 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                    |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA         | Seguro de 12 años - 100% - Mensual - opción 1 |
      | CE      | Victor Aguirre Huaman | 10/06/2000      | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD         | Seguro de 12 años - 100% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 11/07/2000      | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO   | Seguro de 12 años - 100% - Anual - opción 1 |


  @ESC22_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 18-28, a 12 años y 120% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 12 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                      |
      | CE      | Victor Rosales Gomez  | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | VISA | Seguro de 12 años - 120% - Mensual - opción 1   |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD     | Seguro de 12 años - 120% - Semestral - opción 1 |
      | CE      | Rosa Souza Venegas    | 10/06/2000      | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          | OTRO             | Seguro de 12 años - 120% - Mensual - opción 1   |


  @ESC23_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 29-33, a 12 años y 150% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 12 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo     | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                    |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino | 996848620 | testPacifico@gmail.com | mensual - opc 2 | IMC_INTERMEDIO    | TC          | VISA         | Seguro de 12 años - 150% - Mensual - opción 1 |


  @ESC24_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 34-38, a 15 años y 100% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                      |
      | CE      | Victor Rosales Gomez  | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | MASTERCARD       | Seguro de 15 años - 100% - Mensual - opción 1   |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          |OTRO | Seguro de 15 años - 100% - Semestral - opción 1 |
      | CE      | Rosa Souza Venegas    | 10/06/2000      | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          | VISA     | Seguro de 15 años - 100% - Anual - opción 1     |


  @ESC25_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 39-43, a 15 años y 120% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                      |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | MASTERCARD         | Seguro de 15 años - 120% - Mensual - opción 1   |
      | CE      | Victor Aguirre Huaman | 10/06/2000      | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | OTRO         | Seguro de 15 años - 120% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 11/07/2000      | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | VISA   | Seguro de 15 años - 120% - Anual - opción 1     |


  @ESC26_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 44-48, a 15 años y 150% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 15 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres              | fechacumpleaños | sexo      | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                    |
      | CE      | Victor Rosales Gomez | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com | mensual - opc 2 | IMC_INTERMEDIO    | TC          | MASTERCARD | Seguro de 15 años - 150% - Mensual - opción 1 |


  @ESC27_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 49-53, a 20 años y 100% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                      |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | OTRO | Seguro de 20 años - 100% - Mensual - opción 1   |
      | CE      | Victor Aguirre Huaman | 10/06/2000      | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | VISA         | Seguro de 20 años - 100% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 11/07/2000      | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | MASTERCARD         | Seguro de 20 años - 100% - Anual - opción 1     |


  @ESC28_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 54-58, a 20 años y 120% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 120%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                  | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                      |
      | CE      | Victor Rosales Gomez  | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com  | mensual - opc 2   | IMC_INTERMEDIO    | TC          | OTRO       | Seguro de 20 años - 120% - Mensual - opción 1   |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@icloud.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | VISA | Seguro de 20 años - 120% - Semestral - opción 1 |
      | CE      | Rosa Souza Venegas    | 10/06/2000      | masculino | 996848620 | testPacifico@zohoo.com  | anual - opc 2     | IMC_INTERMEDIO    | TC          | MASTERCARD     | Seguro de 20 años - 120% - Anual - opción 1     |


  @ESC29_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 18-28, a 20 años y 150% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 150%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres               | fechacumpleaños | sexo      | celular   | correo                   | frecuenciaPago    | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | comentario                                      |
      | DNI     | Carmen Aguirre Huaman | 10/06/2000      | femenino  | 996848620 | testPacifico@gmail.com   | mensual - opc 2   | IMC_INTERMEDIO    | TC          | OTRO         | Seguro de 20 años - 150% - Mensual - opción 1   |
      | CE      | Victor Aguirre Huaman | 10/06/2000      | masculino | 996848620 | testPacifico@hotmail.com | semestral - opc 2 | IMC_INTERMEDIO    | TC          | VISA         | Seguro de 20 años - 150% - Semestral - opción 1 |
      | DNI     | Victor Reyes Souza    | 11/07/2000      | masculino | 996848620 | testPacifico@outlook.com | anual - opc 2     | IMC_INTERMEDIO    | TC          | MASTERCARD   | Seguro de 20 años - 150% - Anual - opción 1     |


  @ESC30_NOCLIENTE
  Scenario Outline: Validar que un NO CLIENTE pueda adquirir un seguro cuando su edad está entre 29-33, a 20 años y 200% de devolución
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 20 años
    And ingreso los siguientes datos del no cliente <nombres>, <fechacumpleaños>, <sexo>, <celular>, <correo>, 200%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, <comentario>
    Then la operación de compra es satisfactoria

    Examples:
      | tipoDoc | nombres              | fechacumpleaños | sexo      | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | comentario                                    |
      | CE      | Victor Rosales Gomez | 10/06/2000      | masculino | 996848620 | testPacifico@yahoo.com | mensual - opc 2 | IMC_INTERMEDIO    | TC          | OTRO | Seguro de 20 años - 200% - Mensual - opción 1 |
