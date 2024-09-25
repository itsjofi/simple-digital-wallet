package dev.itsjofi.simpledigitalwallet.validation;

import dev.itsjofi.simpledigitalwallet.controller.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.exception.InsufficientFundsException;
import dev.itsjofi.simpledigitalwallet.exception.TransferNotAllowedException;
import dev.itsjofi.simpledigitalwallet.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferValidator {
    @Autowired
    private AuthorizationService authorizationService;

    public void validate(Wallet payer, Wallet payee, TransferDto transferDto) {
        if (payer.getIsMerchant()) {
            throw new TransferNotAllowedException();
        }

        if (payer.getBalance().compareTo(transferDto.value()) < 0) {
            throw new InsufficientFundsException();
        }

        authorizationService.authorize();
    }
}
