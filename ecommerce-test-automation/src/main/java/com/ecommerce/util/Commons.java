package com.ecommerce.util;

import com.nttdata.tdm.model.*;

import java.util.List;

public class Commons {
    public static String TIPO_DOC = "";
    public static String numTarjeta = "";
    public static String TIPO_CLIENTE = "";
    public static List<Customer> customer;
    public static Customer customer2;
    public static List<Tarjetas> tarjeta;
    public static String marcaTarjeta = "";
    public static boolean UBIGEO = false;
    public static List<Ubigeos> ubigeo;
    public static List<PesosTallas> pesoTalla;
    public static boolean REQUIERE_CONSENTIMIENTO = false;

    public static String CELULAR = "";
    public static String CORREO = "";
    public static String PORCENTAJE_DEVOLUCION = "";
    public static String FRECUENCIA_PAGO = "";
    public static String MONTO_PAGO = "";
    public static String TOTAL_DEVOLUCION = "";
    public static String MONTO_DEVOLUCION = "";
    public static String RESUMEN_PAGO = "";
    public static String RESUMEN_PAGO_TOTAL = "";
    public static int PESO;
    public static float TALLA;
    public static String ANIOS_AHORRO = "";
    public static String RESUMEN_CELULAR = "";
    public static String RESUMEN_CORREO = "";
    public static String RESUMEN_ANIOS_AHORRO = "";
    public static String RESUMEN_PORCENTAJE = "";
    public static String RESUMEN_DEVOLUCION = "";
    public static String RESUMEN_FRECUENCIA = "";
    public static String RESUMEN_PESO = "";
    public static String RESUMEN_TALLA = "";


//    public static Customer obtengoDataDeTDM(){
//        //TODO: Obtengo un cliente de TDM
//        Commons.customer = Do.spGetCustomerNotCustomerByTypeDocumentAndUbigeo(Commons.TIPO_DOC, Commons.TIPO_CLIENTE, requiereUbigeo);
//        //TODO: Valido que la información de TDM sea igual a la que trae el servicio
//        Commons.customer2 = QueryService.getCustomer(Commons.TIPO_DOC, Commons.customer.get(0).getNumDoc());
//
//        if((Commons.customer2.getUbigeo() == null ? 0 : 1) != (Commons.customer.get(0).getUbigeo() == null ? 0 : 1)){
//            //TODO: Obtengo un cliente de TDM
//            Commons.customer = Do.spGetCustomerNotCustomerByTypeDocumentAndUbigeo(Commons.TIPO_DOC, Commons.TIPO_CLIENTE, requiereUbigeo);
//        }
//        if(Commons.customer2.isFlagConsentimiento() != Commons.customer.get(0).isFlagConsentimiento()){
//            //TODO: Obtengo un cliente de TDM
//            Commons.customer = Do.spGetCustomerNotCustomerByTypeDocumentAndUbigeo(Commons.TIPO_DOC, Commons.TIPO_CLIENTE, requiereUbigeo);
//        }
//        if(Commons.customer2.isVerificado() != Commons.customer.get(0).isVerificado()){
//            //TODO: Obtengo un cliente de TDM
//            Commons.customer = Do.spGetCustomerNotCustomerByTypeDocumentAndUbigeo(Commons.TIPO_DOC, Commons.TIPO_CLIENTE, requiereUbigeo);
//        }
//
//    }

}
