package pe.financieraoh.apiseguro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="FINAN_SEG_SOLICITUD" , schema = "EFINAN")
public class SolicitudPT extends Solicitud {
	

	@Column(name="EST_EJECUCION")
	private String estEjecucion;
	 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_EJECUCION")
	private Date fecEjecucion;

	@Column(name="MON_PRIMA")
	private Integer monPrima;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ENVIO")
	private Date fecEnvio;
	
	@Column(name="EST_ENVIO")
	private String estEnvio;
	
	@Column(name="FLAG_POL_ELECTRONICA")
	private Integer flagPolElectronica;
	
	@Column(name="NRO_SOLICITUD_GLOBAL")
	private String nroSolucitudGlobal;
	
	@Column(name="FLAG_ORI_CANCELACION")
	private Integer flagOriCancelacion;
	
	@Column(name="FLAG_ORI_SOLICITUD")
	private Integer flagOriSolicitud;
	
	@Column(name="N_ID_LEGAL")
	private Integer nIdLegal;
}
