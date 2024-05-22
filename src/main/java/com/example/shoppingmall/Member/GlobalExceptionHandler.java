package com.example.shoppingmall.Member;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult handleValidationExceptions(MethodArgumentNotValidException errors) {
        Map<String, String> errorMessages = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String errorField = error.getField(); //예외 필드
            String errorMessage = error.getDefaultMessage(); // 예외 메세지
            errorMessages.put(errorField, errorMessage);
        }

        log.info("errorMessages={}", errorMessages.toString());
        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }
}