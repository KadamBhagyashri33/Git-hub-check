package com.productservicecatalog.productservicecatalog.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus()
	public ErrorMessage exception(ProductNotFoundException ex) {
		ErrorMessage exception = new ErrorMessage(ex.getMessage(), "PRD_NOT_FOUND");
		return exception;
	}

	/*
	 * @ExceptionHandler(ConstraintViolationException.class)
	 * // @ResponseStatus(HttpStatus.BAD_REQUEST) public void
	 * constraintViolationException(HttpServletResponse response) throws IOException
	 * { response.sendError(HttpStatus.BAD_REQUEST.value()); }
	 * 
	 * // error handle for @Valid
	 * 
	 * @ExceptionHandler(MethodArgumentNotValidException.class)
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp", new
	 * Date()); body.put("status", status.value());
	 * 
	 * // Get all fields errors List<String> errors =
	 * ex.getBindingResult().getFieldErrors().stream().map(x ->
	 * x.getDefaultMessage()) .collect(Collectors.toList());
	 * 
	 * body.put("errors", errors);
	 * 
	 * return new ResponseEntity<>(body, headers, status);
	 * 
	 * }
	 */

	@ExceptionHandler(Throwable.class)

	@ResponseStatus()
	public ErrorMessage allTypeException(Throwable exception) {
		ErrorMessage exceptions = new ErrorMessage("PLease try again later", "GENERAL");
		return exceptions;
	}

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public Map<String, String>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	 * Map<String, String> errorMap = new HashMap<>();
	 * ex.getBindingResult().getFieldErrors().forEach(error -> {
	 * errorMap.put(error.getField(), error.getDefaultMessage()); }); return
	 * errorMap;
	 * 
	 * }
	 * 
	 * @ExceptionHandler(PropertyValueException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST) public Map<String, String>
	 * handleMethodArgumentNotValid(PropertyValueException ex) { Map<String, String>
	 * errorMap = new HashMap<>(); ex.getCause();
	 * 
	 * // ex.getBindingResult().getFieldErrors().forEach(error -> //
	 * errorMap.put(error.getField(), error.getDefaultMessage())); return errorMap;
	 * 
	 * }
	 */

}
