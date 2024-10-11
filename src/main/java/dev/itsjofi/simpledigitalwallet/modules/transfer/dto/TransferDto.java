package dev.itsjofi.simpledigitalwallet.modules.transfer.dto;

import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDto(
        @DecimalMin("0.01") @NotNull BigDecimal value,
        @NotNull Long payer,
        @NotNull Long payee) {
    public Transfer toTransferEntity() {
        return new Transfer(payer, payee, value);
    }
}
