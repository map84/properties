package br.com.properties.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.properties.entity.PropertyEntity;
import br.com.properties.entity.ProvinceEntity;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PropertyEntityValidadorTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 
    @Test
    public void testValidatdorSuccessPropertyEntity() {
    	
    	PropertyEntity entity = getEntity();
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredPropertyEntity() {
    	
    	PropertyEntity entity = new PropertyEntity();
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("required")).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenPropertyEntity() {
    	
    	PropertyEntity entity = getEntity();
    	entity.setDescription("");
    	entity.setName("");
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("size must be between")).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanPropertyEntity() {
    	
    	PropertyEntity entity = getEntity();
    	entity.setBathrooms(0);
    	entity.setBedrooms(0);
    	entity.setMeters(0);
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be greater than")).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualPropertyEntity() {
    	
    	PropertyEntity entity = getEntity();
    	entity.setBathrooms(5);
    	entity.setBedrooms(6);
    	entity.setMeters(241);
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be less than or equal")).count());
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
}
