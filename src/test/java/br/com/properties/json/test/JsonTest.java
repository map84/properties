package br.com.properties.json.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.properties.exception.ProvinceException;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.json.utils.Provinces;

/**
 * @author Marcos Alves
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonTest {
 
    @Test
    public void testConvertJsonToProvinces() throws ProvinceException {
    	
    	Provinces provinces = (Provinces) JsonUtils.convertJsonToObject(JsonUtils.FILE_PROVINCES, Provinces.class);
    	
    	assertEquals(600, provinces.getGode().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(500, provinces.getGode().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(0, provinces.getGode().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(1000, provinces.getGode().getBoundaries().getUpperLeft().getY().intValue());
    	
    	assertEquals(800, provinces.getGroola().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(0, provinces.getGroola().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(600, provinces.getGroola().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(500, provinces.getGroola().getBoundaries().getUpperLeft().getY().intValue());
    	
    	assertEquals(1400, provinces.getJaby().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(500, provinces.getJaby().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(1100, provinces.getJaby().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(1000, provinces.getJaby().getBoundaries().getUpperLeft().getY().intValue());
    	
    	assertEquals(1400, provinces.getNova().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(0, provinces.getNova().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(800, provinces.getNova().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(500, provinces.getNova().getBoundaries().getUpperLeft().getY().intValue());
    	
    	assertEquals(1100, provinces.getRuja().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(500, provinces.getRuja().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(400, provinces.getRuja().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(1000, provinces.getRuja().getBoundaries().getUpperLeft().getY().intValue());
    	
    	assertEquals(600, provinces.getScavy().getBoundaries().getBottomRight().getX().intValue());
    	assertEquals(0, provinces.getScavy().getBoundaries().getBottomRight().getY().intValue());
    	assertEquals(0, provinces.getScavy().getBoundaries().getUpperLeft().getX().intValue());
    	assertEquals(500, provinces.getScavy().getBoundaries().getUpperLeft().getY().intValue());
    }
}
