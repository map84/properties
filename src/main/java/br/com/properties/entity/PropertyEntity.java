package br.com.properties.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * @author Marcos Alves
 *
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PropertyEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="CD_PROPRIEDADE")
	private Long code;
	
	@NotEmpty(message="title is required")
	@Size(min = 1, max = 100, message="name: size must be between 1 and 100 characters")
	@Column(name="NO_PROPRIEDADE", length = 100)
	private String name;
	
	@NotNull(message="price is required")
	@Column(name="VL_PRECO")
	private BigDecimal price;
	
	@NotEmpty(message="description is required")
	@Size(min = 1, max = 250, message="description: size must be between 1 and 250 characters")
	@Column(name="DC_PROPRIEDADE", length = 250)
	private String description;
	
	@NotNull(message="latitude is required")
	@Column(name="NU_LATITUDE")
	private Integer latitude;
	
	@NotNull(message="longitude is required")
	@Column(name="NU_LONGITUDE")
	private Integer longitude;
	
	@NotNull(message="bedrooms is required")
	@Min(value=1, message="the bedrooms must be greater than 0")
	@Max(value=5, message="the bedrooms must be less than or equal to 5")
	@Column(name="NU_QUARTO")
	private Integer bedrooms;
	
	@NotNull(message="bathrooms is required")
	@Min(value=1, message="the bathrooms must be greater than 0")
	@Max(value=4, message="the bathrooms must be less than or equal to 4")
	@Column(name="NU_BANHEIRO")
	private Integer bathrooms;
	
	@NotNull(message="meters is required")
	@Min(value=20, message="the meters must be greater than or equal 20")
	@Max(value=240, message="the meters must be less than or equal to 240")
	@Column(name="NU_METRO")
	private Integer meters;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<ProvinceEntity> provinces;

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the latitude
	 */
	public Integer getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Integer getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the bedrooms
	 */
	public Integer getBedrooms() {
		return bedrooms;
	}

	/**
	 * @param bedrooms the bedrooms to set
	 */
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * @return the bathrooms
	 */
	public Integer getBathrooms() {
		return bathrooms;
	}

	/**
	 * @param bathrooms the bathrooms to set
	 */
	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	/**
	 * @return the meters
	 */
	public Integer getMeters() {
		return meters;
	}

	/**
	 * @param meters the meters to set
	 */
	public void setMeters(Integer meters) {
		this.meters = meters;
	}

	/**
	 * @return the provinces
	 */
	public List<ProvinceEntity> getProvinces() {
		return provinces;
	}

	/**
	 * @param provinces the provinces to set
	 */
	public void setProvinces(List<ProvinceEntity> provinces) {
		this.provinces = provinces;
	}
}
