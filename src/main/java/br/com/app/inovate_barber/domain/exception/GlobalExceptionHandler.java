package br.com.app.inovate_barber.domain.exception;

import br.com.app.inovate_barber.domain.responses.ErrorResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        ex.getClass().getSimpleName(),
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(CnpjAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCnpjAlreadyExists(CnpjAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        ex.getClass().getSimpleName(),
                        messageSource.getMessage("exception.cnpj.already.exists", null, LocaleContextHolder.getLocale()),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        ex.getClass().getSimpleName(),
                        messageSource.getMessage("exception.entity.already.exists", null, LocaleContextHolder.getLocale()),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBarbershopNotFound(EntityNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        ex.getClass().getSimpleName(),
                        messageSource.getMessage("pt.exception.entity.not.found", null, LocaleContextHolder.getLocale()),
                        LocalDateTime.now()
                ));
    }
}
