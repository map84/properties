package br.com.properties.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.properties.builder.test.BuilderTest;
import br.com.properties.entity.ProvinceEntity;
import br.com.properties.repository.ProvinceRepository;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@EnableJpaRepositories(basePackages = "br.com.properties.repository")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class ProvinceRepositoryTest {

	@Autowired(required=true)
    private ProvinceRepository repository;
 
    @Test
    @Transactional
    public void save() {
    	
    	ProvinceEntity entity = repository.save(BuilderTest.getProvinceEntity());
        assertNotNull(repository.findOne(entity.getCode()));
    }
    
    @Test
    @Transactional
    public void update() {
    	
    	ProvinceEntity entity = repository.save(BuilderTest.getProvinceEntity());
    	entity.setName("Province One One");
        entity = repository.save(entity);
        entity = repository.findOne(entity.getCode());
        assertEquals("Province One One", entity.getName());
    }
}
