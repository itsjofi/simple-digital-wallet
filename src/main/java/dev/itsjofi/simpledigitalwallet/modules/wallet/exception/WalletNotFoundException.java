package dev.itsjofi.simpledigitalwallet.modules.wallet.exception;

import dev.itsjofi.simpledigitalwallet.exception.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends DefaultException {
    private final Long walletId;

    public WalletNotFoundException(Long walletId) {
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Wallet not found!");
        problemDetail.setDetail("There is not wallet with id " + walletId);

        return problemDetail;
    }
}
