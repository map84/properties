package br.com.properties.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PropertiesResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Quantidade de propriedades", required=true)
	private Integer foundProperties;
	
	@ApiModelProperty(value = "lista de propriedades", required=true)
	private List<PropertySearch> properties;

	/**
	 * @return the foundProperties
	 */
	public Integer getFoundProperties() {
		return foundProperties;
	}

	/**
	 * @param foundProperties the foundProperties to set
	 */
	public void setFoundProperties(Integer foundProperties) {
		this.foundProperties = foundProperties;
	}

	/**
	 * @return the properties
	 */
	public List<PropertySearch> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<PropertySearch> properties) {
		this.properties = properties;
	}
}
