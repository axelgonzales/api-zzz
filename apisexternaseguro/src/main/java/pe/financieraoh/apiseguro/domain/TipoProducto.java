package pe.financieraoh.apiseguro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="FINAN_SEG_TIPO_PRODUCTO", schema = "EFINAN")
public class TipoProducto {
	
	
	@Id
	@Column(name="COD_TIPO_PRODUCTO")
	private Integer codTipProducto;

}
