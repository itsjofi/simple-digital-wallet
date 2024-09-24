package dev.itsjofi.simpledigitalwallet.controller.advice;

import dev.itsjofi.simpledigitalwallet.controller.WalletController;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = WalletController.class)
public class WalletExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolation(DataIntegrityViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setDetail("Oops! It seems like the information you're trying to use is already in our system.");

        if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            problemDetail.setDetail("It seems like the Email or CPF/CNPJ you provided is already registered. Please try again with a different one.");
        } else {
            problemDetail.setDetail("Data integrity violation");
        }

        return problemDetail;
    }
}
