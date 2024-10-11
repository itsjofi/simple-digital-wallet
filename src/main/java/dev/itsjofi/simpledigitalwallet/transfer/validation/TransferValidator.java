package dev.itsjofi.simpledigitalwallet.transfer.validation;

import dev.itsjofi.simpledigitalwallet.authorization.service.AuthorizationService;
import dev.itsjofi.simpledigitalwallet.transfer.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.transfer.exception.InsufficientFundsException;
import dev.itsjofi.simpledigitalwallet.transfer.exception.TransferNotAllowedException;
import dev.itsjofi.simpledigitalwallet.wallet.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferValidator {
    @Autowired
    private AuthorizationService authorizationService;

    public void validate(Wallet payer, TransferDto transferDto) {
        if (payer.getIsMerchant()) {
            throw new TransferNotAllowedException();
        }

        if (payer.getBalance().compareTo(transferDto.value()) < 0) {
            throw new InsufficientFundsException();
        }

        authorizationService.authorize();
    }
}
