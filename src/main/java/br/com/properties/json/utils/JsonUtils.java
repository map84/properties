package br.com.properties.json.utils;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.properties.exception.ProvinceException;

/**
 * 
 * @author Marcos Alves
 *
 */
public class JsonUtils {
	
	public static final String PATH_PROVINCES = "src/main/resources/provinces.json";
	public static final String PATH_PROPERTIES = "src/test/resources/properties.json";
	
	public static String convertObjectToJson(final Object obj) throws ProvinceException {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new ProvinceException(e);
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object convertJsonToObject(final String path, final Class classes) throws ProvinceException {
		try {
			return new ObjectMapper().readValue(new File(path), classes);
		} catch (Exception e) {
            throw new ProvinceException(e);
        }
	}
}