package mx.com.gapsi.examen.mm.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.gapsi.examen.mm.dto.GapsiGenericResponseDto;
import mx.com.gapsi.examen.mm.ws.service.exception.GapsiException;

@ControllerAdvice
public class GapsiExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GapsiExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected ResponseEntity<GapsiGenericResponseDto> handleGeneralException(Exception exception) {
		LOG.error("Calling handleGeneralException", exception);
		GapsiGenericResponseDto response = new GapsiGenericResponseDto();
		response.setError("Ocurrió un error general en la petición");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ExceptionHandler(GapsiException.class)
	@ResponseBody
	protected ResponseEntity<GapsiGenericResponseDto> handleGapsiException(GapsiException exception) {
		LOG.error("Calling handleGapsiException", exception);
		GapsiGenericResponseDto response = new GapsiGenericResponseDto();
		response.setError(exception.getErrorMessage());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
