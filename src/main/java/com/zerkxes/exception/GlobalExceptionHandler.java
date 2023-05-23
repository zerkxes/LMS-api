package com.zerkxes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EdgeCaseErrorResponse> handleAllEdgeCaseException(Exception x) {
		StackTraceElement[] trace = x.getStackTrace();
		EdgeCaseErrorResponse error = new EdgeCaseErrorResponse(HttpStatus.FORBIDDEN.value(), "Unhandled Exception. Possible invalid value as input", trace[trace.length-1], System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
}
