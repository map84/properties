package br.com.properties.service;

import br.com.properties.dto.PropertiesResponse;
import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.exception.ProvinceException;

public interface PropertyService {

	Long save(Property request) throws ProvinceException;
	PropertySearch findById(Long id);
	PropertiesResponse findByTwoCoordinates(Integer ax,Integer ay, Integer bx,Integer by);
}
