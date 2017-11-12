package br.com.properties.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.properties.entity.PropertyEntity;

/**
 * 
 * @author Marcos Alves
 *
 */
@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

}
