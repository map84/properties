package br.com.properties.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.properties.dto.ErrorResponse;
import br.com.properties.dto.ErrorType;
import br.com.properties.dto.PropertiesResponse;
import br.com.properties.dto.Property;
import br.com.properties.dto.PropertySearch;
import br.com.properties.entity.PropertyEntity;
import br.com.properties.repository.PropertyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.glasnost.orika.MapperFacade;

/**
 * 
 * @author Marcos Alves
 *
 */
@Controller
@RequestMapping(value = "/properties")
@Api(value = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
public class PropertyResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyResource.class);
	
	private static final String URL = "/properties/";
	
	@Autowired
	private MapperFacade orikaMapperFacade;
	
	@Autowired
	private PropertyRepository repository;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Adiciona uma propriedade", response = Property.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Success", response = Property.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorResponse.class) })
	public ResponseEntity<?> add(@Valid @RequestBody Property request, UriComponentsBuilder uriBuilder) throws Exception {

		PropertyEntity entity = orikaMapperFacade.map(request, PropertyEntity.class);
		entity = repository.save(entity);
		
		LOGGER.debug("StatusCode: {}, RequestURI: {}, Message: Propriedade criada com sucesso [ID {}]",
				HttpStatus.CREATED.value(), URL, entity.getCode());
		
		return ResponseEntity
				.created(uriBuilder.path(URL + "{id}").buildAndExpand(entity.getCode()).toUri())
				.body(request);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Busca uma propriedade", response = PropertySearch.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = PropertySearch.class),
			@ApiResponse(code = 404, message = "NotFound", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorResponse.class) })
	public ResponseEntity<?> get(@PathVariable(name="id", required = true) Long id) throws Exception {

		PropertyEntity entity = repository.findOne(id);
		
		if (entity == null) {
			
			LOGGER.debug("StatusCode: {}, RequestURI: {}, Message: Propriedade nao foi encontrada [ID {}]",
					HttpStatus.NOT_FOUND.value(), URL, id);
			
			return ResponseEntity.notFound().build();
			
		} else {
			
			Property response = orikaMapperFacade.map(entity, Property.class);
			
			LOGGER.debug("StatusCode: {}, RequestURI: {}, Message: Propriedade encontrada [ID {}]", HttpStatus.OK.value(),
					URL, id);
			
			return ResponseEntity.ok(response);
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Busca uma propriedade", response = PropertiesResponse.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = PropertiesResponse.class),
			@ApiResponse(code = 404, message = "NotFound", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorResponse.class) })
	public ResponseEntity<?> search(
			@RequestParam(name="ax", required = true) Integer ax,
			@RequestParam(name="ay", required = true) Integer ay,
			@RequestParam(name="bx", required = true) Integer bx,
			@RequestParam(name="by", required = true) Integer by) throws Exception {
		
		LOGGER.debug("StatusCode: {}, RequestURI: {}", HttpStatus.OK.value(), URL);
		
		return ResponseEntity.ok(null);
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
 
        List<String> reason = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorType.INVALID_DATA_VALUES, reason), HttpStatus.BAD_REQUEST);
    }
	
//	@ExceptionHandler
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<?> handleException(Exception e) {
// 
//        List<String> reason = new ArrayList<String>();
//        reason.add(e.getMessage());
//        
//        return new ResponseEntity<ErrorResponse>(new ErrorResponse(ErrorType.INVALID_DATA_VALUES, reason), HttpStatus.BAD_REQUEST);
//    }
}
