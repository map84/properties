package br.com.properties.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.properties.builder.test.BuilderTest;
import br.com.properties.entity.PropertyEntity;
import br.com.properties.repository.PropertyRepository;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PropertyRepositoryTest {

	@Autowired(required=true)
    private PropertyRepository repository;
 
    @Test
    @Transactional
    public void save() {
    	
    	PropertyEntity entity = repository.save(BuilderTest.getPropertyEntity());
        assertNotNull(repository.findOne(entity.getCode()));
    }
    
    @Test
    @Transactional
    public void update() {
    	
    	PropertyEntity entity = repository.save(BuilderTest.getPropertyEntity());
        entity.setBathrooms(4);
        entity.setBedrooms(3);
        entity = repository.save(entity);
        entity = repository.findOne(entity.getCode());
        
        assertEquals(4, entity.getBathrooms().intValue());
        assertEquals(3, entity.getBedrooms().intValue());
    }
    
    @Test
    public void search() {
    	
       List<PropertyEntity> entities = repository.findByCoordinates(1, 3, 3, 4);
        assertEquals(0, entities.size());
    }
}
