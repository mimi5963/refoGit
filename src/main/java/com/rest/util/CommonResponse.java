package com.rest.util;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Builder
public class CommonResponse<T> {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    private static final String FAIL = "fail";
    private String status;
    private int statusCode;
    private T data;

    private String message;

    public static <T> CommonResponse<T> setSuccess(T data,int code){
        return new CommonResponseBuilder<T>().message("").data(data).status(SUCCESS).statusCode(code).message("").build();
    }

    public static CommonResponse<?> setError(String errorMessage,int code){
        return new CommonResponseBuilder<>().status(ERROR).message(errorMessage).statusCode(code).build();
    }

    public static CommonResponse<?> setFail(BindingResult bindingResult,int code){
        Map<String, String> fails = new HashMap<>();

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for(ObjectError er : allErrors){
            if(er instanceof FieldError){
                fails.put(((FieldError) er).getField(),er.getDefaultMessage());
            }else{
                fails.put(er.getObjectName(), er.getDefaultMessage());
            }
        }
        return new CommonResponseBuilder<>().data(fails).status(FAIL).statusCode(code).message("").build();
    }

}
