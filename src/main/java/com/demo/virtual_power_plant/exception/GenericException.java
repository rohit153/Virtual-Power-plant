package com.demo.virtual_power_plant.exception;

import com.demo.virtual_power_plant.enums.ResponseStatus;
import com.demo.virtual_power_plant.pojo.api.ApiError;
import com.demo.virtual_power_plant.utill.CustomMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rohit.tamang
 * @Created 8/26/2022
 */
@ControllerAdvice
@RequiredArgsConstructor
public class GenericException extends ResponseEntityExceptionHandler {
    private final CustomMessageSource customMessageSource;

    /**
     *
     * @param ex
     * @param request
     * @return Api Error For DataIntegrityViolationException
     */
    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseBody
    public ResponseEntity<Object> handleConstraintViolation(DataIntegrityViolationException ex, WebRequest request) {
        final List<String> errors = new ArrayList<String>();
        String fieldName = "";
        ApiError apiError = null;
        if (ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            org.hibernate.exception.ConstraintViolationException violation = ((org.hibernate.exception.ConstraintViolationException) ex.getCause());
            if (violation.getCause().getLocalizedMessage().contains("NULL")) {
                String s = violation.getCause().getMessage();
                Pattern p = Pattern.compile("\"([^\"]*)\"");
                Matcher m = p.matcher(s);
                String constraintName = null;
                while (m.find()) {
                    constraintName = m.group(1);
                }


                errors.add(customMessageSource.get("not.null", constraintName));
            } else {
                errors.add(customMessageSource.get("not.null", violation.getCause().getLocalizedMessage()));
            }

            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            apiError = new ApiError(ResponseStatus.FAIL, httpStatus.value(),new Date(), errors.get(0), errors);

        }
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), httpStatus);
    }
}
