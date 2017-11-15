package br.com.properties.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.properties.entity.PropertyEntity;

/**
 * 
 * @author Marcos Alves
 *
 */
@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

	@Query("SELECT A FROM PropertyEntity A WHERE A.latitude <= :bx AND A.latitude >= :ax "
			+ "AND A.longitude >= :by AND A.longitude <= :ay ")
	List<PropertyEntity> findByCoordinates(@Param("ax")Integer ax, @Param("ay")Integer ay, 
			@Param("bx")Integer bx, @Param("by")Integer by);
}
