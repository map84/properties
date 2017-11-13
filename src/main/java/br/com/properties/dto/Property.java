package br.com.properties.dto;

import java.io.Serializable;
import java.math.BigDecimal;

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
	@Size(min = 1, max = 100, message="title: size must be between 1 and 100 characters")
	@ApiModelProperty(value = "Titulo da propriedade", required=true)
	private String title;
	
	@NotNull(message="price is required")
	@ApiModelProperty(value = "Preco", required=true)
	private BigDecimal price;
	
	@NotEmpty(message="description is required")
	@Size(min = 1, max = 250, message="description: size must be between 1 and 250 characters")
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
	@Min(value=20, message="the squareMeters must be greater than or equal 20")
	@Max(value=240, message="the squareMeters must be less than or equal to 240")
	@ApiModelProperty(value = "Metro quadrado", required=true)
	private Integer squareMeters;
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baths == null) ? 0 : baths.hashCode());
		result = prime * result + ((beds == null) ? 0 : beds.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((squareMeters == null) ? 0 : squareMeters.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (baths == null) {
			if (other.baths != null)
				return false;
		} else if (!baths.equals(other.baths))
			return false;
		if (beds == null) {
			if (other.beds != null)
				return false;
		} else if (!beds.equals(other.beds))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (squareMeters == null) {
			if (other.squareMeters != null)
				return false;
		} else if (!squareMeters.equals(other.squareMeters))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
}
