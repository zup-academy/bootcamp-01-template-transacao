package dev.arielalvesdutra.transacao.error_handlers;


import dev.arielalvesdutra.transacao.controllers.dtos.ErroResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static dev.arielalvesdutra.transacao.utils.HandlerAdviceUtils.fieldErrorsToStringList;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class BindHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErroResponseDTO> handler(
            HttpServletRequest request,
            BindException exception) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResponseDTO error = new ErroResponseDTO()
                .setErros(fieldErrorsToStringList(exception.getBindingResult()))
                .setStatus(status.value())
                .setCaminho(request.getRequestURI())
                .setInstante(Instant.now())
                .setErro(status.name())
                .setMensagem("Dados inválidos!");

        return ResponseEntity.status(status).body(error);
    }
}
