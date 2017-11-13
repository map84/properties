package br.com.properties.dto;

import java.io.Serializable;
import java.util.List;

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
	
	@ApiModelProperty(value = "Provincias")
	private List<String> provinces;

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
	
	/**
	 * @return the provinces
	 */
	public List<String> getProvinces() {
		return provinces;
	}

	/**
	 * @param provinces the provinces to set
	 */
	public void setProvinces(List<String> provinces) {
		this.provinces = provinces;
	}
}
