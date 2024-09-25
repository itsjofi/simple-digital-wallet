package dev.itsjofi.simpledigitalwallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientFundsException extends DefaultException {

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Insufficient funds.");
        problemDetail.setDetail("The transfer amount exceeds your available balance.");

        return problemDetail;
    }
}
