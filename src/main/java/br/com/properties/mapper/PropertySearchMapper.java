package br.com.properties.mapper;

import org.springframework.stereotype.Component;

import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class PropertySearchMapper implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(PropertySearch.class, PropertyEntity.class)
        .field("title", "name")
        .field("x", "latitude")
        .field("y", "longitude")
        .field("beds", "bedrooms")
        .field("baths", "bathrooms")
        .field("squareMeters", "meters")
        .field("id", "code")
        .field("provinces{}", "provinces{name}")
        .byDefault()
        .register();
	}
}