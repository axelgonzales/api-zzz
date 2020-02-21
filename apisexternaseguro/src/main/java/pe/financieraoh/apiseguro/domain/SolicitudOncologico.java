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
@Table(name="FINAN_SEG_ONCO_SOLICITUD" , schema = "EFINAN")
public class SolicitudOncologico  extends Solicitud{

	@Column(name="COD_PRIMA_ONCO")
	private Integer codPrimaOnco;
	
	@Column(name="COD_TIPO_EMAIL")
	private Integer codTipEmail;
	
	@Column(name="VAL_EDAD_CALCULADA")
	private Integer valEdadCalculada;
	
	@Column(name="EST_ENVIO_MC")
	private String estEnvioMc;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ENVIO_MC")
	private Date fecEnvioMc;
	
	@Column(name="EST_EJECUCION_MC")
	private String estEjecuionMc;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_EJECUCION_MC")
	private Date fecEjecucionMc;
	
	@Column(name="EST_ENVIO_PACIFICO")
	private String estEnvioPacifico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ENVIO_PACIFICO")
	private Date fecEnvioPacifico;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_EJECUCION_PACIFICO")
	private Date fecEjecucionPacifico;
	
	@Column(name="EST_EJECUCION_PACIFICO")
	private String estEjecucionPacifico;
	 
	
	
	
	
}
