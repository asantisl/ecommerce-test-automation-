Feature: Compra de seguro por un No Cliente pacífico - unhappy


  @ESC012_NOCLIENTE_ @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa numero de celular invalido para adquirir una poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del no cliente <nombres>, con una edad fuera de rango <edad>, <sexo>
    Then se muestra el mensaje de error 'Edad inválida o fuera de rango'

    Examples:
      | tipoDoc | nombres              | edad | sexo      |
      | DNI     | Victor Rosales Gomez | 17   | masculino |
      | CE      | Victor Rosales Gomez | 59   | masculino |


  @ESC013_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa numero de celular invalido para adquirir una poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del no cliente con el numero de celular o correo invalido <nombres>, <edad>, <sexo>, <celular>, <correo>
    Then se muestra el mensaje de error 'El número debe iniciar con 9 y tener 9 dígitos'

    Examples:
      | tipoDoc | nombres              | edad | sexo      | celular   | correo                 |
      | DNI     | Victor Rosales Gomez | 19   | masculino | 999999999 | testpacifico@gmail.com |


  @ESC14_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa un correo invalido para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 5 años
    And ingreso los siguientes datos del no cliente con el numero de celular o correo invalido <nombres>, <edad>, <sexo>, <celular>, <correo>
    Then se muestra el mensaje de error 'El correo debe tener un formato válido'

    Examples:
      | tipoDoc | nombres              | edad       | sexo      | celular   | correo                  |
      | CE      | Victor Rosales Gomez | 10/06/2000 | masculino | 996848620 | testpacifico:@gmail.com |


  @ESC15_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una relación de Peso y Talla fuera de rango para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo Si, requiere consentimiento Si
    When intento adquirir un seguro de 7 años
    And ingreso los siguientes datos del no cliente <nombres>, <edad>, <sexo>, <celular>, <correo>, 100%, <frecuenciaPago>, con relación PesoTalla invalido <RelacionPesoTalla>
    Then se muestra el mensaje de error 'verifique que su peso y talla sean correctos'


    Examples:
      | tipoDoc | nombres              | edad       | sexo      | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla        |
      | DNI     | Victor Rosales Gomez | 10/06/2000 | masculino | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_FUERA_RANGO_SUPERIOR |


  @ESC16_NOCLIENTE_ @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problemas de Comercio no válido para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Comercio o Terminal no válido

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA         | 4539674409144668 |


  @ESC17_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problemas de Contactar emisor para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Contactar con entidad emisora

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | MASTERCARD   | 5100538637530152 |


  @ESC18_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una Tarjeta no registrada para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Parece que la tarjeta ingresada no es válida
    #¡sucedió algo inesperado!
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | numTarjeta      |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | AMERICAN EXPRESS | 370374318198760 |

  @ESC19_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con Problemas de comunicación con antifraude para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Problemas de comunicación con antifraude
    #¡sucedió algo inesperado!
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta     |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | DINNERS CLUB | 36124375262074 |


  @ESC20_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problema de Transacción denegada por posible fraude para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Transacción denegada por posible fraude
    #¡sucedió algo inesperado!
    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | UNION PAY    | 6210946888160006 |


  @ESC21_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problemas de Error en autenticación para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Error con Verified

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta       |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | VISA         | 4732453453776393 |


  @ESC22_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problemas de Transacción inválida para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Contactar con entidad emisora

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta | numTarjeta     |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | DINNERS CLUB | 36552045187919 |


  @ESC23_NOCLIENTE @UNHAPPY
  Scenario Outline: Validar mensaje de error cuando un NO CLIENTE, ingresa una tarjeta con problemas de Tienda inhabilitada para adquirir su poliza
    Given que soy un NO_CLIENTE de Pacífico
    And obtengo data de TDM <tipoDoc>, requiere ubigeo si, requiere consentimiento si
    When intento adquirir un seguro de 7 años
    And ingreso los datos del no cliente <celular>, <correo>, 100%, <frecuenciaPago>, <RelacionPesoTalla>, <tipoTarjeta>, <marcaTarjeta>, con número de Tarjeta <numTarjeta>
    Then se muestra el siguiente mensaje de error Tienda inhabilitada

    Examples:
      | tipoDoc | celular   | correo                 | frecuenciaPago  | RelacionPesoTalla | tipoTarjeta | marcaTarjeta     | numTarjeta      |
      | CE      | 996848620 | testPacifico@gmail.com | Mensual - opc 1 | IMC_INTERMEDIO    | TC          | AMERICAN EXPRESS | 371032217060171 |
