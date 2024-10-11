package dev.itsjofi.simpledigitalwallet.modules.wallet.advice;

import dev.itsjofi.simpledigitalwallet.controller.WalletController;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice(assignableTypes = WalletController.class)
public class WalletExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleConstraintViolationException(ConstraintViolationException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        List<String> messages = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());

        problemDetail.setDetail(String.join(", ", messages));

        return problemDetail;
    }
}
