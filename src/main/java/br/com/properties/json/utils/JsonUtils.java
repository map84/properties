package br.com.properties.json.utils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.properties.exception.ProvinceException;

/**
 * 
 * @author Marcos Alves
 *
 */
public class JsonUtils {
	
	public static final String FILE_PROVINCES = "provinces.json";
	public static final String FILE_PROPERTIES = "properties.json";
	
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
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream(path);
			return new ObjectMapper().readValue(is, classes);
		} catch (Exception e) {
            throw new ProvinceException(e);
        }
	}
}