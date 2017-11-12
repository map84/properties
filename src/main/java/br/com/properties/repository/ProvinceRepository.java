package br.com.properties.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.properties.entity.ProvinceEntity;

/**
 * 
 * @author Marcos Alves
 *
 */
@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Integer> {

}
