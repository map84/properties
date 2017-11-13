package br.com.properties.mapper.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.properties.builder.test.BuilderTest;
import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import ma.glasnost.orika.MapperFacade;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class MapperTest {

	@Autowired
	private MapperFacade orikaMapperFacade;
 
    @Test
    public void testMapperPropertyEntityToProperty() {
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	Property dto = orikaMapperFacade.map(entity, Property.class);
    	assertEquals(entity.getBathrooms(), dto.getBaths());
    	assertEquals(entity.getBedrooms(), dto.getBeds());
    	assertEquals(entity.getDescription(), dto.getDescription());
    	assertEquals(entity.getLatitude(), dto.getX());
    	assertEquals(entity.getLongitude(), dto.getY());
    	assertEquals(entity.getMeters(), dto.getSquareMeters());
    	assertEquals(entity.getPrice(), dto.getPrice());
    	assertEquals(entity.getName(), dto.getTitle());
    }
    
    @Test
    public void testMapperPropertyEntityToPropertySearch() {
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	PropertySearch dto = orikaMapperFacade.map(entity, PropertySearch.class);
    	assertEquals(entity.getBathrooms(), dto.getBaths());
    	assertEquals(entity.getBedrooms(), dto.getBeds());
    	assertEquals(entity.getDescription(), dto.getDescription());
    	assertEquals(entity.getLatitude(), dto.getX());
    	assertEquals(entity.getLongitude(), dto.getY());
    	assertEquals(entity.getMeters(), dto.getSquareMeters());
    	assertEquals(entity.getPrice(), dto.getPrice());
    	assertEquals(entity.getName(), dto.getTitle());
    	assertEquals(entity.getCode(), dto.getId());
    	assertEquals(entity.getProvinces().size(), dto.getProvinces().size());
    }
    
    @Test
    public void testMapperPropertySearchToPropertyEntity() {
    	
    	PropertySearch dto = BuilderTest.getPropertySearchDto();
    	PropertyEntity tesss = orikaMapperFacade.map(dto, PropertyEntity.class);
    	assertEquals(dto.getBaths(), tesss.getBathrooms());
    	assertEquals(dto.getBeds(), tesss.getBedrooms());
    	assertEquals(dto.getDescription(), tesss.getDescription());
    	assertEquals(dto.getX(), tesss.getLatitude());
    	assertEquals(dto.getY(), tesss.getLongitude());
    	assertEquals(dto.getSquareMeters(), tesss.getMeters());
    	assertEquals(dto.getPrice(), tesss.getPrice());
    	assertEquals(dto.getTitle(), tesss.getName());
    	assertEquals(dto.getId(), tesss.getCode());
    	assertEquals(dto.getProvinces().size(), tesss.getProvinces().size());
    }
    
    @Test
    public void testMapperPropertyToPropertyEntity() {
    	
    	Property dto = BuilderTest.getPropertyDto();
    	PropertyEntity tesss = orikaMapperFacade.map(dto, PropertyEntity.class);
    	assertEquals(dto.getBaths(), tesss.getBathrooms());
    	assertEquals(dto.getBeds(), tesss.getBedrooms());
    	assertEquals(dto.getDescription(), tesss.getDescription());
    	assertEquals(dto.getX(), tesss.getLatitude());
    	assertEquals(dto.getY(), tesss.getLongitude());
    	assertEquals(dto.getSquareMeters(), tesss.getMeters());
    	assertEquals(dto.getPrice(), tesss.getPrice());
    	assertEquals(dto.getTitle(), tesss.getName());
    }
}
