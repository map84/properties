package br.com.properties.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import br.com.properties.entity.ProvinceEntity;
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
    	
    	PropertyEntity entity = getEntity();
    	Property dto = orikaMapperFacade.map(entity, Property.class);
    	assertEquals(entity.getBathrooms(), dto.getBaths());
    	assertEquals(entity.getBedrooms(), dto.getBeds());
    	assertEquals(entity.getDescription(), dto.getDescription());
    	assertEquals(entity.getLatitude(), dto.getX());
    	assertEquals(entity.getLongitude(), dto.getY());
    	assertEquals(entity.getMeters(), dto.getSquareMeters());
    	assertEquals(entity.getPrice(), dto.getPrice());
    	assertEquals(entity.getName(), dto.getTitle());
    	assertEquals(entity.getProvinces().size(), dto.getProvinces().size());
    }
    
    @Test
    public void testMapperPropertyEntityToPropertySearch() {
    	
    	PropertyEntity entity = getEntity();
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
    	
    	PropertySearch dto = getPropertySearchDto();
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
    	
    	Property dto = getPropertyDto();
    	PropertyEntity tesss = orikaMapperFacade.map(dto, PropertyEntity.class);
    	assertEquals(dto.getBaths(), tesss.getBathrooms());
    	assertEquals(dto.getBeds(), tesss.getBedrooms());
    	assertEquals(dto.getDescription(), tesss.getDescription());
    	assertEquals(dto.getX(), tesss.getLatitude());
    	assertEquals(dto.getY(), tesss.getLongitude());
    	assertEquals(dto.getSquareMeters(), tesss.getMeters());
    	assertEquals(dto.getPrice(), tesss.getPrice());
    	assertEquals(dto.getTitle(), tesss.getName());
    	assertEquals(dto.getProvinces().size(), tesss.getProvinces().size());
    }
    
    private PropertyEntity getEntity() {
    	
    	PropertyEntity entity = new PropertyEntity();
    	entity.setBathrooms(2);
    	entity.setBedrooms(3);
    	entity.setCode(1l);
    	entity.setDescription("Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.");
    	entity.setLatitude(1257);
    	entity.setLongitude(928);
    	entity.setMeters(61);
    	entity.setPrice(new BigDecimal("456000"));
    	entity.setName("Imóvel código 1, com 3 quartos e 2 banheiros.");
    	entity.setProvinces(new ArrayList<ProvinceEntity>());
    	
    	ProvinceEntity entity1 = new ProvinceEntity();
    	entity1.setCode(1);
    	entity1.setName("Province One");
    	
    	ProvinceEntity entity2 = new ProvinceEntity();
    	entity2.setCode(1);
    	entity2.setName("Province Two");
    	
    	entity.getProvinces().add(entity1);
    	entity.getProvinces().add(entity2);
    	
    	return entity;
    }
    
    private Property getPropertyDto() {
    	
    	Property dto = new Property();
    	dto.setBaths(2);
    	dto.setBeds(3);
    	dto.setDescription("Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.");
    	dto.setX(1257);
    	dto.setY(928);
    	dto.setPrice(new BigDecimal("456000"));
    	dto.setSquareMeters(61);
    	dto.setTitle("Imóvel código 1, com 3 quartos e 2 banheiros.");
    	dto.setProvinces(new ArrayList<String>());
    	dto.getProvinces().add("Province One");
    	dto.getProvinces().add("Province Two");
    	
    	return dto;
    }
    
    private PropertySearch getPropertySearchDto() {
    	
    	PropertySearch dto = new PropertySearch();
    	dto.setId(1l);
    	dto.setBaths(2);
    	dto.setBeds(3);
    	dto.setDescription("Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.");
    	dto.setX(1257);
    	dto.setY(928);
    	dto.setPrice(new BigDecimal("456000"));
    	dto.setSquareMeters(61);
    	dto.setTitle("Imóvel código 1, com 3 quartos e 2 banheiros.");
    	dto.setProvinces(new ArrayList<String>());
    	dto.getProvinces().add("Province One");
    	dto.getProvinces().add("Province Two");
    	
    	return dto;
    }
}
