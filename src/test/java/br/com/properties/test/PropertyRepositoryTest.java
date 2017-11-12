package br.com.properties.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.properties.entity.PropertyEntity;
import br.com.properties.repository.PropertyRepository;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@EnableJpaRepositories(basePackages = "br.com.properties.repository")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class PropertyRepositoryTest {

	@Autowired(required=true)
    private PropertyRepository repository;
 
    @Test
    @Transactional
    public void save() {
    	
    	PropertyEntity entity = repository.save(getEntity());
        assertNotNull(repository.findOne(entity.getCode()));
    }
    
    @Test
    @Transactional
    public void update() {
    	
    	PropertyEntity entity = repository.save(getEntity());
        entity.setBathrooms(4);
        entity.setBedrooms(3);
        entity = repository.save(entity);
        entity = repository.findOne(entity.getCode());
        
        assertEquals(4, entity.getBathrooms().intValue());
        assertEquals(3, entity.getBedrooms().intValue());
    }
    
    @Test
    @Transactional
    public void search() {
    	
       List<PropertyEntity> entities = repository.findByCoordinates(1, 3, 3, 4);
        assertEquals(0, entities.size());
    }
    
    private PropertyEntity getEntity() {
    	
    	PropertyEntity entity = new PropertyEntity();
    	entity.setBathrooms(2);
    	entity.setBedrooms(3);
    	entity.setPrice(new BigDecimal("456000"));
    	entity.setCode(null);
    	entity.setDescription("Laboris quis quis elit commodo eiusmod qui exercitation. In laborum fugiat quis minim occaecat id.");
    	entity.setLatitude(1257);
    	entity.setLongitude(928);
    	entity.setMeters(61);
    	entity.setName("Imóvel código 1, com 3 quartos e 2 banheiros.");
    	
    	return entity;
    }
}
