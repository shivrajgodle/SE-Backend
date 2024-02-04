package com.SE.exceptions;


import com.SE.dto.ApiResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

    //handler resource not found
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourseNotFoundExceptionHandler(ResourseNotFoundException ex){
        logger.info("Exception handler invoked !!");
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity(apiResponseMessage,HttpStatus.NOT_FOUND);
    }
}
