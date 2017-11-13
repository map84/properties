package br.com.properties.rules;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.properties.dto.Property;
import br.com.properties.entity.ProvinceEntity;
import br.com.properties.exception.ProvinceException;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.json.utils.Province;
import br.com.properties.json.utils.Provinces;

public class ProvincesRules {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvincesRules.class);

	public List<ProvinceEntity> rules(Property request) throws ProvinceException {
		
		LOGGER.debug("rules - INICIO");
		
		List<ProvinceEntity> response = new ArrayList<ProvinceEntity>();
		Provinces provinces = (Provinces) JsonUtils.convertJsonToObject(JsonUtils.PATH_PROVINCES, Provinces.class);
		
		if(isGode(provinces.getGode(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setCode(null);
			province.setName("Gode");
			response.add(province);
		}
		
		boolean isRujaUpperX = provinces.getRuja().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isRujaBottomX = provinces.getRuja().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isRujaUpperY = provinces.getRuja().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isRujaBottomY = provinces.getRuja().getBoundaries().getBottomRight().getY() >= request.getY();
		
		boolean isJabyUpperX = provinces.getJaby().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isJabyBottomX = provinces.getJaby().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isJabyUpperY = provinces.getJaby().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isJabyBottomY = provinces.getJaby().getBoundaries().getBottomRight().getY() >= request.getY();
		
		boolean isScavyUpperX = provinces.getScavy().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isScavyBottomX = provinces.getScavy().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isScavyUpperY = provinces.getScavy().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isScavyBottomY = provinces.getScavy().getBoundaries().getBottomRight().getY() >= request.getY();
		
		boolean isGroolaUpperX = provinces.getGroola().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isGroolaBottomX = provinces.getGroola().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isGroolaUpperY = provinces.getGroola().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isGroolaBottomY = provinces.getGroola().getBoundaries().getBottomRight().getY() >= request.getY();
		
		boolean isNovaUpperX = provinces.getNova().getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isNovaBottomX = provinces.getNova().getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isBovaUpperY = provinces.getNova().getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isnovaBottomY = provinces.getNova().getBoundaries().getBottomRight().getY() >= request.getY();
		
		LOGGER.debug("rules - FIM");
		
		return response;
	}
	
	private boolean isGode(Province province, Property request) {
		
		boolean isGodeUpperX = province.getBoundaries().getUpperLeft().getX() >= request.getX();
		boolean isGodeBottomX = province.getBoundaries().getBottomRight().getX() <= request.getX();
		boolean isGodeUpperY = province.getBoundaries().getUpperLeft().getY() <= request.getY();
		boolean isGodeBottomY = province.getBoundaries().getBottomRight().getY() >= request.getY();
		
		return isGodeUpperX && isGodeBottomX && isGodeUpperY && isGodeBottomY;
	}
}
