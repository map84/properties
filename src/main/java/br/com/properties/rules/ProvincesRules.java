package br.com.properties.rules;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.properties.dto.Property;
import br.com.properties.entity.ProvinceEntity;
import br.com.properties.exception.ProvinceException;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.json.utils.Provinces;

public class ProvincesRules {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvincesRules.class);

	public List<ProvinceEntity> rules(Property request) throws ProvinceException {
		
		LOGGER.debug("rules - INICIO");
		
		List<ProvinceEntity> response = new ArrayList<ProvinceEntity>();
		Provinces provinces = (Provinces) JsonUtils.convertJsonToObject(JsonUtils.PATH_PROVINCES, Provinces.class);
		
		boolean isGodeUpperX = provinces.getGode().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isGodeBottomX = provinces.getGode().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isGodeUpperY = provinces.getGode().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isGodeBottomY = provinces.getGode().getBoundaries().getBottomRight().getY() >= request.getY();
		
		
		LOGGER.debug("rules - FIM");
		
		return response;
	}
}
