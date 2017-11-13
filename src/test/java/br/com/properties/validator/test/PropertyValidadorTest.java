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
    	
    	Property dto = BuilderTest.getPropertyDto();
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredProperty() {
    	
    	Property dto = new Property();
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_REQUIRED)).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenProperty() {
    	
    	Property dto = BuilderTest.getPropertyDto();
    	dto.setDescription("");
    	dto.setTitle("");
    	Set<ConstraintViolation<Property>> violations = validator.validate(dto);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_SIZE)).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanProperty() {
    	
    	Property entity = BuilderTest.getPropertyDto();
    	entity.setBaths(0);
    	entity.setBeds(0);
    	entity.setSquareMeters(0);
    	Set<ConstraintViolation<Property>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_GREATER)).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualProperty() {
    	
    	Property entity = BuilderTest.getPropertyDto();
    	entity.setBaths(5);
    	entity.setBeds(6);
    	entity.setSquareMeters(241);
    	Set<ConstraintViolation<Property>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_LESS)).count());
    }
}
