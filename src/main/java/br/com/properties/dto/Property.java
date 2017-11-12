package br.com.properties.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Marcos Alves
 *
 */
@ApiModel
public class Property implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="title is required")
	@Size(min = 1, max = 30, message="title: size must be between 1 and 100 characters")
	@ApiModelProperty(value = "Titulo da propriedade", required=true)
	private String title;
	
	@NotNull(message="price is required")
	@ApiModelProperty(value = "Preco", required=true)
	private BigDecimal price;
	
	@NotEmpty(message="description is required")
	@Size(min = 1, max = 100, message="description: size must be between 1 and 100 characters")
	@ApiModelProperty(value = "Descricao", required=true)
	private String description;
	
	@NotNull(message="latitude is required")
	@ApiModelProperty(value = "Latitude", required=true)
	private Integer x;
	
	@NotNull(message="longitude is required")
	@ApiModelProperty(value = "Longitude", required=true)
	private Integer y;
	
	@NotNull(message="beds is required")
	@Min(value=1, message="the beds must be greater than 0")
	@Max(value=5, message="the beds must be less than or equal to 5")
	@ApiModelProperty(value = "Quantidade de quartos", required=true)
	private Integer beds;
	
	@NotNull(message="baths is required")
	@Min(value=1, message="the baths must be greater than 0")
	@Max(value=4, message="the baths must be less than or equal to 4")
	@ApiModelProperty(value = "Quantidade de banheiros", required=true)
	private Integer baths;
	
	@NotNull(message="squareMeters is required")
	@Min(value=20, message="the baths must be greater than or equal 20")
	@Max(value=240, message="the baths must be less than or equal to 240")
	@ApiModelProperty(value = "Metro quadrado", required=true)
	private Integer squareMeters;
	
	@ApiModelProperty(value = "Provincias")
	private List<String> provinces;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * @return the beds
	 */
	public Integer getBeds() {
		return beds;
	}

	/**
	 * @param beds the beds to set
	 */
	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	/**
	 * @return the baths
	 */
	public Integer getBaths() {
		return baths;
	}

	/**
	 * @param baths the baths to set
	 */
	public void setBaths(Integer baths) {
		this.baths = baths;
	}

	/**
	 * @return the squareMeters
	 */
	public Integer getSquareMeters() {
		return squareMeters;
	}

	/**
	 * @param squareMeters the squareMeters to set
	 */
	public void setSquareMeters(Integer squareMeters) {
		this.squareMeters = squareMeters;
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
