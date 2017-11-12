package br.com.properties.test;

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

import br.com.properties.entity.ProvinceEntity;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class ProvinceEntityValidadorTest {

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
 
    @Test
    public void testValidatdorSuccessProvinceEntity() {
    	
    	ProvinceEntity entity = getEntity();
    	Set<ConstraintViolation<ProvinceEntity>> violations = validator.validate(entity);
    	assertEquals(0, violations.size());
    }
    
    @Test
    public void testValidatdorRequiredProvinceEntity() {
    	
    	ProvinceEntity entity = new ProvinceEntity();
    	Set<ConstraintViolation<ProvinceEntity>> violations = validator.validate(entity);
    	assertEquals(1, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("required")).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetweenProvinceEntity() {
    	
    	ProvinceEntity entity = getEntity();
    	entity.setName("");
    	Set<ConstraintViolation<ProvinceEntity>> violations = validator.validate(entity);
    	assertEquals(1, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("size must be between")).count());
    }
    
    @Test
    public void testValidatdorSizeMustBeBetween2ProvinceEntity() {
    	
    	ProvinceEntity entity = getEntity();
    	entity.setName("0123456789012345678901234567890");
    	Set<ConstraintViolation<ProvinceEntity>> violations = validator.validate(entity);
    	assertEquals(1, violations.parallelStream().map(ConstraintViolation::getMessageTemplate)
    		.filter(message->message.contains("size must be between")).count());
    }
    
    private ProvinceEntity getEntity() {
    	
    	ProvinceEntity entity = new ProvinceEntity();
    	entity.setCode(1);
    	entity.setName("Province One");
    	
    	return entity;
    }
}
