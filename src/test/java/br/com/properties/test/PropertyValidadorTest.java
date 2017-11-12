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

import br.com.properties.dto.Property;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PropertyValidadorTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 
    @Test
    public void testValidatdorSuccessProperty() {
    	
    	Property dto = getPropertyDto();
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredProperty() {
    	
    	Property dto = new Property();
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("required")).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenProperty() {
    	
    	Property dto = getPropertyDto();
    	dto.setDescription("");
    	dto.setTitle("");
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("size must be between")).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanProperty() {
    	
    	Property entity = getPropertyDto();
    	entity.setBaths(0);
    	entity.setBeds(0);
    	entity.setSquareMeters(0);
    	Set<ConstraintViolation<Property>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be greater than")).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualProperty() {
    	
    	Property entity = getPropertyDto();
    	entity.setBaths(5);
    	entity.setBeds(6);
    	entity.setSquareMeters(241);
    	Set<ConstraintViolation<Property>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be less than or equal")).count());
    }
    
    private Property getPropertyDto() {
    	
    	Property dto = new Property();
    	dto.setBaths(2);
    	dto.setBeds(3);
    	dto.setDescription("Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.");
    	dto.setX(1257);
    	dto.setY(928);
    	dto.setSquareMeters(61);
    	dto.setPrice(new BigDecimal("456000"));
    	dto.setTitle("Imóvel código 1, com 3 quartos e 2 banheiros.");
    	dto.setProvinces(new ArrayList<String>());
    	dto.getProvinces().add("Province One");
    	dto.getProvinces().add("Province Two");
    	
    	return dto;
    }
}
