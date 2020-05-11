package com.syhdeclan.onlineform.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author Shenyvhao
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult handleMethodArgumentNotValidException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> list = new LinkedList<String>();
        while (iterator.hasNext()){
            list.add(iterator.next().getMessageTemplate());
        }

        return JsonResult.error(Code.PARAMETER_ERROR,list);
    }

    @ExceptionHandler(WebException.class)
    public JsonResult handleWebException(WebException e){
        e.printStackTrace();
        return JsonResult.error(e.getCode(),e.getMsg());
    }

}
