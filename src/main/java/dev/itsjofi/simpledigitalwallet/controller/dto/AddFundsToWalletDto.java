package dev.itsjofi.simpledigitalwallet.controller.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AddFundsToWalletDto(@DecimalMin("0.01") @NotNull BigDecimal amount) {
}
