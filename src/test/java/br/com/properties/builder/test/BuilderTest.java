package br.com.properties.builder.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import br.com.properties.entity.ProvinceEntity;

public class BuilderTest {
	
	public static final String DESCRIPTION = "Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.";
	public static final Long ID = 1l;
	public static final Integer BATHS = 2;
	public static final Integer BEDS = 3;
	public static final Integer X = 1257;
	public static final Integer Y = 928;
	public static final Integer SQUARE_METERS = 61;
	public static final BigDecimal PRICE = new BigDecimal("456000");
	public static final String TITLE = "Imóvel código 1, com 3 quartos e 2 banheiros.";
	public static final Integer PROVINCE_ONE_CODE = 1;
	public static final String PROVINCE_ONE = "Province One";
	public static final Integer PROVINCE_TWO_CODE = 2;
	public static final String PROVINCE_TWO = "Province Two";
	public static final String MSG_REQUIRED = "required";
	public static final String MSG_SIZE = "size must be between";
	public static final String MSG_MUST_GREATER = "must be greater than";
	public static final String MSG_MUST_LESS = "must be less than or equal";
	
	public static PropertySearch getPropertySearchDto() {
    	
    	PropertySearch dto = new PropertySearch();
    	dto.setId(ID);
    	dto.setBaths(BATHS);
    	dto.setBeds(BEDS);
    	dto.setDescription(DESCRIPTION);
    	dto.setX(X);
    	dto.setY(Y);
    	dto.setSquareMeters(SQUARE_METERS);
    	dto.setPrice((PRICE));
    	dto.setTitle(TITLE);
    	
    	return dto;
    }
	
	public static Property getPropertyDto() {
    	
    	Property dto = new Property();
    	dto.setBaths(BATHS);
    	dto.setBeds(BEDS);
    	dto.setDescription(DESCRIPTION);
    	dto.setX(X);
    	dto.setY(Y);
    	dto.setSquareMeters(SQUARE_METERS);
    	dto.setPrice((PRICE));
    	dto.setTitle(TITLE);
    	
    	return dto;
    }
	
	public static ProvinceEntity getProvinceEntity() {
    	
    	ProvinceEntity entity = new ProvinceEntity();
    	entity.setCode(1);
    	entity.setName(PROVINCE_ONE);
    	
    	return entity;
    }
	
	public static PropertyEntity getPropertyEntity() {
    	
    	PropertyEntity entity = new PropertyEntity();
    	entity.setBathrooms(BATHS);
    	entity.setBedrooms(BEDS);
    	entity.setCode(ID);
    	entity.setDescription(DESCRIPTION);
    	entity.setLatitude(X);
    	entity.setLongitude(Y);
    	entity.setMeters(SQUARE_METERS);
    	entity.setPrice((PRICE));
    	entity.setName(TITLE);
    	entity.setProvinces(new ArrayList<ProvinceEntity>());
    	
    	ProvinceEntity entity1 = new ProvinceEntity();
    	entity1.setName(PROVINCE_ONE);
    	
    	ProvinceEntity entity2 = new ProvinceEntity();
    	entity2.setName(PROVINCE_TWO);
    	
    	entity.getProvinces().add(entity1);
    	entity.getProvinces().add(entity2);
    	
    	return entity;
    }
}
