package com.scaler.fakestoreapiproxy.advice;

import com.scaler.fakestoreapiproxy.DTOs.ExceptionResponseDTO;
import com.scaler.fakestoreapiproxy.Exceptions.ProductNotFoundException.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepitionHandlerAdvice {
   // @ExceptionHandler(ProductNotFoundException.class)// we are specifying here if proudct not found exception occurs, handle through this method
    public ResponseEntity<ExceptionResponseDTO> productnotfoundhandler(){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO();
        exceptionResponseDTO.setMessage("Product not found");
        exceptionResponseDTO.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.NOT_FOUND);
    }
}
