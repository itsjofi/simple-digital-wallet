package dev.itsjofi.simpledigitalwallet.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DefaultException extends RuntimeException {
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("An unexpected error has occurred.");

        return problemDetail;
    }
}
