package me.kifio.demo.controller.advice;

import me.kifio.demo.model.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<String> handleNotEnoughMoneyException(NotEnoughMoneyException e){
        return ResponseEntity
                .badRequest()
                .body("400 NOT ENOUGH MONEY");
    }
}
