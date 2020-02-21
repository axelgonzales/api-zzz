package pe.financieraoh.apiseguro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="FINAN_SEG_TIPO_CANCELACION", schema = "EFINAN")
public class TipoCancelacion {

	@Id
	@Column(name="COD_TIPO_CANCELACION")
	private Integer codTipCancelacion;
	
	@Column(name="COD_TIPO_PRODUCTO")
	private Integer codTipProducto;
}
