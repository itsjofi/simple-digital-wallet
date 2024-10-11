package dev.itsjofi.simpledigitalwallet.modules.transfer.exception;

import dev.itsjofi.simpledigitalwallet.exception.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UnauthorizedTransferException extends DefaultException {

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);

        problemDetail.setTitle("Transfer not authorized.");
        problemDetail.setDetail("Authorization service didn't authorize the transfer.");

        return problemDetail;
    }
}
