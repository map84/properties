package br.com.properties.rules;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.properties.dto.Property;
import br.com.properties.entity.ProvinceEntity;
import br.com.properties.exception.ProvinceException;
import br.com.properties.json.utils.Boundaries;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.json.utils.Provinces;

@Component
public class ProvincesRules {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvincesRules.class);
	
	private Provinces provinces;
	
	public ProvincesRules() throws ProvinceException {
		this.provinces = (Provinces) JsonUtils.convertJsonToObject(JsonUtils.PATH_PROVINCES, Provinces.class);
	}

	public List<ProvinceEntity> getProvinces(Property request) throws ProvinceException {
		
		LOGGER.debug("rules - INICIO");
		
		List<ProvinceEntity> response = new ArrayList<ProvinceEntity>();
		
		if(isGode(provinces.getGode().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Gode");
			response.add(province);
		}
		
		if(isRuja(provinces.getRuja().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Ruja");
			response.add(province);
		}
		
		if(isJaby(provinces.getJaby().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Jaby");
			response.add(province);
		}
		
		if(isScavy(provinces.getScavy().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Scavy");
			response.add(province);
		}
		
		if(isGroola(provinces.getGroola().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Groola");
			response.add(province);
		}
		
		if(isNova(provinces.getNova().getBoundaries(), request)) {
			
			ProvinceEntity province = new ProvinceEntity();
			province.setName("Nova");
			response.add(province);
		}
		
		LOGGER.debug("rules - FIM");
		
		return response;
	}
	
	private boolean isGode(Boundaries boundary, Property request) {
		
		boolean isGodeUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isGodeBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isGodeUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isGodeBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isGodeUpperX && isGodeBottomX && isGodeUpperY && isGodeBottomY;
	}
	
	private boolean isRuja(Boundaries boundary, Property request) {
		
		boolean isRujaUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isRujaBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isRujaUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isRujaBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isRujaUpperX && isRujaBottomX && isRujaUpperY && isRujaBottomY;
	}
	
	private boolean isJaby(Boundaries boundary, Property request) {
	
		boolean isJabyUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isJabyBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isJabyUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isJabyBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isJabyUpperX && isJabyBottomX && isJabyUpperY && isJabyBottomY;
	}
	
	private boolean isScavy(Boundaries boundary, Property request) {
		
		boolean isScavyUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isScavyBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isScavyUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isScavyBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isScavyUpperX && isScavyBottomX && isScavyUpperY && isScavyBottomY;
	}
	
	private boolean isGroola(Boundaries boundary, Property request) {
		
		boolean isGroolaUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isGroolaBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isGroolaUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isGroolaBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isGroolaUpperX && isGroolaBottomX && isGroolaUpperY && isGroolaBottomY;
	}
	
	private boolean isNova(Boundaries boundary, Property request) {
		
		boolean isNovaUpperX = boundary.getUpperLeft().getX() <= request.getX();
		boolean isNovaBottomX = boundary.getBottomRight().getX() >= request.getX();
		boolean isBovaUpperY = boundary.getUpperLeft().getY() >= request.getY();
		boolean isnovaBottomY = boundary.getBottomRight().getY() <= request.getY();
		
		return isNovaUpperX && isNovaBottomX && isBovaUpperY && isnovaBottomY;
	}
}
