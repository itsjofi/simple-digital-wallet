package dev.itsjofi.simpledigitalwallet.modules.wallet.dto;

import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(
        @NotBlank String fullName,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull Boolean isMerchant) {
    public Wallet toWalletEntity() {
        return new Wallet(fullName, cpfCnpj, email, password, isMerchant);
    }
}
