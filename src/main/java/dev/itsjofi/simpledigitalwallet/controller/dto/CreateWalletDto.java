package dev.itsjofi.simpledigitalwallet.controller.dto;

import dev.itsjofi.simpledigitalwallet.entity.Wallet;

public record CreateWalletDto(String fullName, String cpfCnpj, String email, String password, Boolean isMerchant) {
    public Wallet toWalletEntity() {
        return new Wallet(fullName, cpfCnpj, email, password, isMerchant);
    }
}
