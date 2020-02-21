package pe.financieraoh.apiseguro.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.financieraoh.apiseguro.constant.Constant;
import pe.financieraoh.apiseguro.controller.request.SolicitudRequest;
import pe.financieraoh.apiseguro.controller.response.SolicitudResponse;
import pe.financieraoh.apiseguro.service.SolicitudService;


@RestController
@RequestMapping("solicitud")
public class SolicitudController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudController.class);

	
	@Autowired
	private SolicitudService seguroService;
	

	@DeleteMapping("{nroSolicitud}")
	@ApiOperation(value = "Cancela los seguros PT y ONCO", httpMethod = "DELETE", produces = "application/json", consumes = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cancelación de seguro exitoso"),
			@ApiResponse(code = 400, message = "No se logro realizar las cancelación") })
	public ResponseEntity<SolicitudResponse> cancelar(
					 @PathVariable 	@NotNull @NotEmpty @Valid String  nroSolicitud,
    				 @RequestBody @Valid SolicitudRequest request) {
		
		request.setNroSolicitud(nroSolicitud);
		seguroService.validate(request);
		
		seguroService.cancel(request); 
		
		LOGGER.info("Controller Response Message solicitud cancel: {}", request);
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_OKEY,Constant.OKEY, request.getCodTipCancelacion()+""), 
				HttpStatus.OK);
    }
	

	
}
