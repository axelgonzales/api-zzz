package pe.financieraoh.apiseguro.constant;


public class Constant {

	public Constant() {
	}
	//CÓDIGOS DE RESPUESTA
	public static final String COD_OKEY= "00";
	public static final String COD_TIPO_PRODUCTO= "01";
	public static final String COD_FECHA_SOLICITUD= "02";
	public static final String COD_NINGUNA_POLIZA= "03";
	public static final String COD_NINGUNA_PERSONA= "04";
	public static final String COD_NINGUNA_PERSONA_COINCIDE= "05";
	public static final String COD_TIP_CANCELACION_NO_VALIDO = "06";
	public static final String COD_POLIZA_CANCEL = "07";
	public static final String COD_VALOR_NO_PERMITIDO = "08";
	
	//MENSAJES DE RESPUESTA
	public static final String OKEY = "SE GÉNERO LA CANCELACIÓN DE FORMA CORRECTA";
	public static final String TIPO_PRODUCTO= "TIPO DE PRODUCTO NO VALIDO";
	public static final String FECHA_SOLICITUD= "LA FECHA DE INICIO DE VIGENCIA INGRESADA ES DIFERENTE CON EL DE LA SOLICITUD ENCONTRADA";
	public static final String NINGUNA_POLIZA= "NO SE TIENE NINGUNA PÓLIZA PARA CANCELAR CON ESOS DATOS";
	public static final String NINGUNA_PERSONA= "NO SE ENCONTRO A NINGUNA PERSONA CON ESE NÚMERO DE DOCUMENTO";
	public static final String NINGUNA_PERSONA_COINCIDE= "EL DOCUMENTOS DE IDENTIDAD INGRESADO NO COINCIDEN CON LOS DATOS DEL CLIENTE REGISTRADOS EN LA SOLICITUD";
	public static final String TIP_CANCELACION_NO_VALIDO = "EL CÓDIGO DE CANCELACIÓN NO ES VALIDO";
	public static final String POLIZA_CANCEL = "LA PÓLIZA YA SE ENCUENTRA CANCELADA";
	public static final String VALOR_NO_PERMITIDO = "SE INGRESO UN ATRIBUTO NO VALIDÓ O FALTA UN CAMPO OBLIGATORIO";
	
	//VARIABLES DEL SISTEMA
	public static final Integer EST_SOLICITUD_PT_CANCEL = 2741;
	public static final Integer EST_SOLICITUD_ONCOLOGICO_CANCEL = 3284;

}
