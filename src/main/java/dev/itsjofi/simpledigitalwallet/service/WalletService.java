package dev.itsjofi.simpledigitalwallet.service;

import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.repository.WalletRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private StrongPasswordEncryptor passwordEncryptor;

    public Wallet create(CreateWalletDto createWalletDto) {
        Wallet wallet = createWalletDto.toWalletEntity();
        wallet.setPassword(passwordEncryptor.encryptPassword(wallet.getPassword()));
        return walletRepository.save(wallet);
    }
}
