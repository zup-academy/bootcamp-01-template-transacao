package dev.arielalvesdutra.transacao.utils;

import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Classe auxiliar para Handlers Adivice.
 */
public class HandlerAdviceUtils {

    public static List<String> fieldErrorsToStringList(BindingResult bindingResult) {
        List<String> errorList =  new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errorList.add(error.getDefaultMessage());
        });

        return errorList;
    }

    public static List<String> constraintViolationsToString(Set<ConstraintViolation<?>> constraintViolations) {
        List<String> errorList =  new ArrayList<>();
        constraintViolations.forEach(violation -> {
            errorList.add(violation.getMessage());
        });

        return errorList;
    }
}
