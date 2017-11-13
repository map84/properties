package br.com.properties.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.properties.dto.PropertiesResponse;
import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import br.com.properties.exception.ProvinceException;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.json.utils.Provinces;
import br.com.properties.repository.PropertyRepository;
import br.com.properties.service.PropertyService;
import ma.glasnost.orika.MapperFacade;

/**
 * 
 * @author Marcos Alves
 *
 */
@Service
public class PropertyServiceImpl implements PropertyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyService.class);
	
	@Autowired
	private MapperFacade orikaMapperFacade;
	
	@Autowired
	private PropertyRepository repository;
	
	public Long save(Property request) throws ProvinceException {
		
		LOGGER.debug("save - INICIO");
		
		PropertyEntity entity = orikaMapperFacade.map(request, PropertyEntity.class);
		Provinces provinces = (Provinces) JsonUtils.convertJsonToObject(JsonUtils.PATH_PROVINCES, Provinces.class);
		entity = repository.save(entity);
		
		LOGGER.debug("save - FIM");
		
		return entity != null ? entity.getCode() : null;
	}
	
	public PropertySearch findById(Long id) {
	
		LOGGER.debug("findById - INICIO");
		
		PropertyEntity entity = repository.findOne(id);
		PropertySearch response = orikaMapperFacade.map(entity, PropertySearch.class);
		
		LOGGER.debug("findById - FIM");
		
		return response;
	}
	
	public PropertiesResponse findByTwoCoordinates(
			Integer ax,Integer ay, Integer bx,Integer by) {
		
		LOGGER.debug("findByTwoCoordinates - INICIO");
		
		PropertiesResponse response = new PropertiesResponse();
		List<PropertyEntity> entities = repository.findByCoordinates(ax, ay, bx, by);
		response.setFoundProperties(entities.size());
		response.setProperties(new ArrayList<PropertySearch>());
		entities.forEach(entity->response.getProperties().add(orikaMapperFacade.map(entity, PropertySearch.class)));
		
		LOGGER.debug("findByTwoCoordinates - FIM");
		
		return response;
	}
}
