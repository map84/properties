package br.com.properties.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class ProvinceEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="CD_PROVINCIA")
	private Integer code;
	
	@NotEmpty
	@Size(min = 1, max = 30, message="provincia name: size must be between 1 and 30 characters")
	@Column(name="NO_PROVINCIA", length = 30)
	private String name;

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
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
}
