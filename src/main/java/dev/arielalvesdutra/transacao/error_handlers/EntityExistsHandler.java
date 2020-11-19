package dev.arielalvesdutra.transacao.error_handlers;


import dev.arielalvesdutra.transacao.controllers.dtos.ErroResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class EntityExistsHandler {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErroResponseDTO> handler(
            HttpServletRequest request,
            EntityExistsException exception) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResponseDTO error = new ErroResponseDTO()
                .setStatus(status.value())
                .setCaminho(request.getRequestURI())
                .setInstante(Instant.now())
                .setErro(status.name())
                .setMensagem(exception.getMessage());

        return ResponseEntity.status(status).body(error);
    }
}
