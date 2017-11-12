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

import br.com.properties.dto.PropertySearch;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PropertySearchValidadorTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 
    @Test
    public void testValidatdorSuccessPropertySearch() {
    	
    	PropertySearch dto = getPropertySearchDto();
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredPropertySearch() {
    	
    	PropertySearch dto = new PropertySearch();
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("required")).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenPropertySearch() {
    	
    	PropertySearch dto = getPropertySearchDto();
    	dto.setDescription("");
    	dto.setTitle("");
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("size must be between")).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanPropertySearch() {
    	
    	PropertySearch dto = getPropertySearchDto();
    	dto.setBaths(0);
    	dto.setBeds(0);
    	dto.setSquareMeters(0);
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be greater than")).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualPropertySearch() {
    	
    	PropertySearch dto = getPropertySearchDto();
    	dto.setBaths(5);
    	dto.setBeds(6);
    	dto.setSquareMeters(241);
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("must be less than or equal")).count());
    }
    
    private PropertySearch getPropertySearchDto() {
    	
    	PropertySearch dto = new PropertySearch();
    	dto.setId(1l);
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
