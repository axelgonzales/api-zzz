package pe.financieraoh.apiseguro.controller.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Valid
public class SolicitudRequest {

	@NotNull
	@JsonProperty("producto")
	private Integer codTipProducto;
	
	@NotNull
	private Integer tipoDocumento;
	@NotNull
	@NotEmpty
	private String nroDocumento;

	@NotNull
	@Size(min = 10, max = 10, message = "EL FECHA DE INICIO DE VIGENCIA DEBE TENER 10 DIGITOS")
	@Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}", message = "DEBE SER UNA FECHA VALIDA (DD/MM/YYYY)")
	private String fecIniVigencia;

	@JsonIgnore
	private String nroSolicitud;

	@NotNull
	@JsonProperty("codCancelacion")
	private Integer codTipCancelacion;
	@NotNull
	@Size(min = 10, max = 10, message = "EL FECHA DE INICIO DE VIGENCIA DEBE TENER 10 DIGITOS")
	@Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}", message = "DEBE SER UNA FECHA VALIDA (DD/MM/YYYY)")
	private String fecCancelacion;
	
	@NotNull
	private String usrCancelacion;


}
