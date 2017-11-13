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
import br.com.properties.entity.PropertyEntity;

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
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredPropertyEntity() {
    	
    	PropertyEntity entity = new PropertyEntity();
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(8, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_REQUIRED)).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenPropertyEntity() {
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	entity.setDescription("");
    	entity.setName("");
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(2, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_SIZE)).count());
    }
    
    @Test
    public void testValidatdorMinMustBeGreaterThanPropertyEntity() {
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	entity.setBathrooms(0);
    	entity.setBedrooms(0);
    	entity.setMeters(0);
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_GREATER)).count());
    }
    
    @Test
    public void testValidatdorMaxMustBeLessThanOrEqualPropertyEntity() {
    	
    	PropertyEntity entity = BuilderTest.getPropertyEntity();
    	entity.setBathrooms(5);
    	entity.setBedrooms(6);
    	entity.setMeters(241);
    	Set<ConstraintViolation<PropertyEntity>> violations = validator.validate(entity);
    	assertEquals(3, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains(BuilderTest.MSG_MUST_LESS)).count());
    }
}
