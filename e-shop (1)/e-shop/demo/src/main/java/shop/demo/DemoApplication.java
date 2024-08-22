package shop.demo;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.demo.core.utilities.exceptions.BusinessException;
import shop.demo.core.utilities.exceptions.ProblemDetail;
import shop.demo.core.utilities.exceptions.ValidationProblemDetail;

@SpringBootApplication
@RestControllerAdvice
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationProblemDetail validationProblemDetail = new ValidationProblemDetail();
		validationProblemDetail.setErrors(new HashMap<String, String>());
		validationProblemDetail.setMessage("Validasyon Hatası meydana geldi!");
		
		for (FieldError fieldError : methodArgumentNotValidException.getFieldErrors()) {
			
			validationProblemDetail.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		return validationProblemDetail;
		
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleBusinessException(BusinessException businessException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage(businessException.getMessage());
		
		return problemDetail;
		
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		problemDetail.setMessage("Böyle bir ürün mevcut değil");
		
		return problemDetail;
		
	}
	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
		
		ProblemDetail problemDetail = new ProblemDetail();
		
		problemDetail.setMessage("Sistem isteğinize cevap veremiyor");
		
		return problemDetail;
		
		
	}
	
	
	

}
