package br.com.properties.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Marcos Alves
 *
 */
@ApiModel
public class PropertySearch extends Property implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Identificador da propriedade", required=true)
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
