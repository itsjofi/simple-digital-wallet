package dev.itsjofi.simpledigitalwallet.transfer.exception;

import dev.itsjofi.simpledigitalwallet.common.exception.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedException extends DefaultException {

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Transfer not allowed for this type of wallet!");

        return problemDetail;
    }
}
