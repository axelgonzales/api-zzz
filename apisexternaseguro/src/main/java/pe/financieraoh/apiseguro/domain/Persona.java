package pe.financieraoh.apiseguro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="puc_personas" , schema = "epuc")
public class Persona {
	
	@Id
	@Column(name="cod_interno")
	private String codInterno;
	
	@Column(name="tip_docum_ide")
	private Integer  tipDocumIde; 
	
	@Column(name="num_docum_ide")
	private String numDocumIde;
}
