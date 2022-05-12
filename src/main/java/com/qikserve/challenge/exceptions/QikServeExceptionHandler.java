package com.qikserve.challenge.exceptions;

import com.qikserve.challenge.dtos.ExceptionResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Desha exception handler.
 */
@ControllerAdvice
public class QikServeExceptionHandler {

    private static final Logger log = LogManager.getLogger();

    /**
     * Handle unauthorized exceptions response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedExceptions(UnauthorizedException ex, WebRequest request) {

        log.error(ex.getMessage());

        ExceptionResponse exceptionResponse =
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .httpStatus(HttpStatus.UNAUTHORIZED)
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .details(request.getDescription(false))
                        .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Handle unauthorized exceptions response entity.
     *
     * @param ex the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotExceptions(NotFoundException ex, WebRequest request) {

        log.error(ex.getMessage());

        ExceptionResponse exceptionResponse =
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .code(HttpStatus.NOT_FOUND.value())
                        .details(request.getDescription(false))
                        .build();

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
