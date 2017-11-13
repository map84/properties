package br.com.properties.validator.test;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.properties.builder.test.BuilderTest;
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
    	
    	PropertySearch dto = BuilderTest.getPropertySearchDto();
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredPropertySearch() {
    	
    	PropertySearch dto = new PropertySearch();
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_REQUIRED)).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenPropertySearch() {
    	
    	PropertySearch dto = BuilderTest.getPropertySearchDto();
    	dto.setDescription("");
    	dto.setTitle("");
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_SIZE)).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanPropertySearch() {
    	
    	PropertySearch dto = BuilderTest.getPropertySearchDto();
    	dto.setBaths(0);
    	dto.setBeds(0);
    	dto.setSquareMeters(0);
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_GREATER)).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualPropertySearch() {
    	
    	PropertySearch dto = BuilderTest.getPropertySearchDto();
    	dto.setBaths(5);
    	dto.setBeds(6);
    	dto.setSquareMeters(241);
    	Set<ConstraintViolation<PropertySearch>> violations = validator.validate(dto);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_LESS)).count());
    }
}
