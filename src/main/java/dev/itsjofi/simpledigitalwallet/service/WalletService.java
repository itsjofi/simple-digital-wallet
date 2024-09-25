package dev.itsjofi.simpledigitalwallet.service;

import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.exception.WalletNotFoundException;
import dev.itsjofi.simpledigitalwallet.repository.WalletRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

    public Wallet getWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() ->  new WalletNotFoundException(walletId));
    }

    public void debitWallet(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().subtract(amount));
    }

    public void creditWallet(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().add(amount));
    }
}
