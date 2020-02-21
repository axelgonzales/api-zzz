package pe.financieraoh.apiseguro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Solicitud  {
	
	@Id
	@Column(name="NRO_SOLICITUD")
	private String nroSolicitud;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_SOLICITUD")
	private Date fecSolicitud; 
	
	@Column(name="NRO_SECUENCIA")
	private Integer nroScuencia;
	 
	@Column(name="COD_INTERNO")
	private String codInterno;
	
	@Column(name="TIP_PRODUCTO")
	private Integer tipoProducto;

	@Column(name="NUM_CUENTA")
	private String numCuenta;
	
	@Column(name="NUM_TARJETA")
	private String numTarjeta;
	
	@Column(name="COD_TIPO_PRODUCTO")
	private Integer codTipProducto;
	
	@Column(name="COD_TIPO_PLAN")
	private Integer codTipPlan;
	 
	@Column(name="COD_TIPO_PERIODICIDAD")
	private Integer codTipPeriocidad;
	
	@Column(name="COD_TIPO_VENDEDOR")
	private Integer codTipVendedor;
	
	@Column(name="COD_VENDEDOR")
	private String codVendedor;
	 
	@Column(name="COD_AGENCIA")
	private Integer codAgencia;
	
	@Column(name="COD_AGENCIA_VENDEDOR")
	private Integer codAgenciaVendedor;
	 
	@Column(name="COD_TIPO_ANULACION")
	private Integer codTipAnulacion;
	
	@Column(name="COD_TIPO_BENEFICIARIO")
	private Integer codBenefeciario;
	
	@Column(name="COD_OCUPACION")
	private Integer codOcupacion;
	 
	@Column(name="DIR_EMAIL")
	private String dirEmail;
	 
	@Column(name="FLAG_EMAIL")
	private Integer flagEmail;
	
	@Column(name="EST_SOLICITUD")
	private Integer estSolicitud;
	 
	@Column(name="EST_GLOBAL_TPA")
	private Integer estGlobalTpa;
	
	@Column(name="EST_REGISTRO")
	private Integer	 estRegistro;
	 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_REGISTRO")
	private Date fecRegistro;//
	 
	@Column(name="USU_REGISTRO")
	private String usuRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ACTUALIZACION")
	private Date fecActualizacion;
	 
	@Column(name="USU_ACTUALIZACION")
	private String usuActualizacion;
	
	@Column(name="DIR_CORRESPONDENCIA")
	private String dirCorrespondencia;
	
	@Column(name="FLAG_ORI_CAI")
	private Integer flagOriCai;
	 
	@Column(name="FLAG_NUM_CTA_MANUAL")
	private Integer flagNumCtaManual;
	 
	@Column(name="COD_TIPO_CANCELACION")
	private Integer codTipCancelacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_CANCELACION")
	private Date fecCancelacion;
	 
	@Column(name="EST_ENVIO_GLOBAL")
	private String estEnvioGlobal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ENVIO_GLOBAL")
	private Date fecEnvioGlobal;
	 
	@Column(name="EST_EJECUCION_GLOBAL")
	private String estEjecucionGlobal;
	 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_EJECUCION_GLOBAL")
	private Date fecEjecucionGlobal;
	
	@Column(name="USU_CANCELACION")
	private String usuCancelacion;
	 
	@Column(name="EST_ENVIO_CAN_GLOBAL")
	private String estEnvioCanGlobal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ENVIO_CAN_GLOBAL")
	private Date fecEnvioCanGlobal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_NACIMIENTO")
	private Date fecNacimiento;
	 
	@Column(name="DPT_UBIGEO")
	private String dptUbigeo;
	 
	@Column(name="PRV_UBIGEO")
	private String prvUbigeo;
	
	@Column(name="DST_UBIGEO")
	private String dstUbigeo;
	
	@Column(name="FLAG_NRO_DUPLICADO")
	private Integer flagNroDuplicado;
	
	@Column(name="TIPO_VALIDACION")
	private String tipValidacion;
	 
	@Column(name="NRO_SECUENCIA_INT")
	private String nroSecuenciaInt;
	 
}
	