package br.com.properties.resource.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import br.com.properties.builder.test.BuilderTest;
import br.com.properties.dto.ErrorType;
import br.com.properties.dto.PropertiesResponse;
import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.json.utils.JsonUtils;
import br.com.properties.resource.PropertyResource;
import br.com.properties.service.PropertyService;

/**
 * @author Marcos Alves
 *
 */
@WebAppConfiguration
@ContextConfiguration("classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = PropertyResource.class, secure = false)
public class PropertyResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PropertyService service;
 
    @Test
    public void testGetByIdSuccess() throws Exception {
    	
    	when(service.findById(BuilderTest.ID)).thenReturn(BuilderTest.getPropertySearchDto());
    	
    	mockMvc.perform(get("/properties/{id}", BuilderTest.ID))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.title", is(BuilderTest.TITLE)))
        .andExpect(jsonPath("$.description", is(BuilderTest.DESCRIPTION)))
        .andExpect(jsonPath("$.price", is(BuilderTest.PRICE.intValue())))
    	.andExpect(jsonPath("$.x", is(BuilderTest.X)))
    	.andExpect(jsonPath("$.y", is(BuilderTest.Y)))
    	.andExpect(jsonPath("$.beds", is(BuilderTest.BEDS)))
    	.andExpect(jsonPath("$.baths", is(BuilderTest.BATHS)))
    	.andExpect(jsonPath("$.squareMeters", is(BuilderTest.SQUARE_METERS)));
    	
    	verify(service, times(1)).findById(BuilderTest.ID);
		verifyZeroInteractions(service);
    }
    
    @Test
    public void testGetByIdNotFound() throws Exception {
    	
    	when(service.findById(BuilderTest.ID)).thenReturn(null);
    	
    	mockMvc.perform(get("/properties/{id}", BuilderTest.ID))
        .andExpect(status().isNotFound());
    	
    	verify(service, times(1)).findById(BuilderTest.ID);
		verifyZeroInteractions(service);
    }
    
    @Test
    public void testPostAddSuccess() throws Exception {
    	
    	Property request = BuilderTest.getPropertyDto();
    	when(service.save(request)).thenReturn(BuilderTest.ID);
    	
    	mockMvc.perform(post("/properties")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(JsonUtils.convertObjectToJson(request)))
        .andExpect(status().isCreated())
        .andExpect(header().string("location", containsString("/properties/1")));
    	
    	verify(service, times(1)).save(request);
		verifyZeroInteractions(service);
    }
    
    @Test
    public void testPostAddBadReques() throws Exception {
    	
    	mockMvc.perform(post("/properties")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(JsonUtils.convertObjectToJson(new Property())))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.errorType", is(ErrorType.INVALID_DATA_VALUES.name())));
    }
    
    @Test
    public void testGetByTwoCordinatesSuccess() throws Exception {
    	
    	PropertiesResponse response = new PropertiesResponse();
    	response.setFoundProperties(0);
    	response.setProperties(new ArrayList<PropertySearch>());
    	
    	when(service.findByTwoCoordinates(1, 2, 3, 4)).thenReturn(response);
    	
    	mockMvc.perform(get("/properties/?ax={ax}&ay={ay}&bx={bx}&by={by}", 1, 2, 3, 4))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$.foundProperties", is(0)));
    	
    	verify(service, times(1)).findByTwoCoordinates(1, 2, 3, 4);
		verifyZeroInteractions(service);
    }
}
