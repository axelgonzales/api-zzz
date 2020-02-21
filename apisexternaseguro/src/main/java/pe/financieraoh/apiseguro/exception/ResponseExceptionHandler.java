package pe.financieraoh.apiseguro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.financieraoh.apiseguro.constant.Constant;
import pe.financieraoh.apiseguro.controller.response.SolicitudResponse;


@ControllerAdvice
public class ResponseExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(MethodArgumentNotValidException ex){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_VALOR_NO_PERMITIDO ,
				"EL ATRIBUTO \"" + ex.getBindingResult().getFieldError().getField().toUpperCase() + "\" " + 
				ex.getBindingResult().getFieldError().getDefaultMessage().toUpperCase(),
				"00"
				), 
				HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(ProductoNotFoundException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_TIPO_PRODUCTO,Constant.TIPO_PRODUCTO,
				except.getMessage()), 
				HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(TipCancelacionNotFoundException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_TIP_CANCELACION_NO_VALIDO,Constant.TIP_CANCELACION_NO_VALIDO,
				except.getMessage()), 
				HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(PolizaNotFoundException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_NINGUNA_POLIZA,Constant.NINGUNA_POLIZA,
				except.getMessage()), 
				HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(PolizaCancelException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_POLIZA_CANCEL,Constant.POLIZA_CANCEL,
				except.getMessage()), 
				HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(PersonaNotFoundException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_NINGUNA_PERSONA,Constant.NINGUNA_PERSONA,
				except.getMessage()), 
				HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<SolicitudResponse> handleException(PolizaDateNotFoundException  except){
		return new ResponseEntity<>(new SolicitudResponse(Constant.COD_FECHA_SOLICITUD,Constant.FECHA_SOLICITUD,
				except.getMessage()), 
				HttpStatus.NOT_FOUND);
		
	}


}

