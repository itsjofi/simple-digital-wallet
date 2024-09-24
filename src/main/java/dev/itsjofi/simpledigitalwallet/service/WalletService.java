package dev.itsjofi.simpledigitalwallet.service;

import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet create(CreateWalletDto createWalletDto) {
        return walletRepository.save(createWalletDto.toWalletEntity());
    }
}
