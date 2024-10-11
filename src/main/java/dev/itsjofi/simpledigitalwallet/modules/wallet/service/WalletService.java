package dev.itsjofi.simpledigitalwallet.modules.wallet.service;

import dev.itsjofi.simpledigitalwallet.controller.dto.AddFundsToWalletDto;
import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.exception.WalletNotFoundException;
import dev.itsjofi.simpledigitalwallet.repository.WalletRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private StrongPasswordEncryptor passwordEncryptor;

    public List<dev.itsjofi.simpledigitalwallet.entity.Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Optional<dev.itsjofi.simpledigitalwallet.entity.Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    public dev.itsjofi.simpledigitalwallet.entity.Wallet create(CreateWalletDto createWalletDto) {
        dev.itsjofi.simpledigitalwallet.entity.Wallet wallet = createWalletDto.toWalletEntity();
        wallet.setPassword(passwordEncryptor.encryptPassword(wallet.getPassword()));
        return walletRepository.save(wallet);
    }

    public dev.itsjofi.simpledigitalwallet.entity.Wallet addFunds(Long walletId, AddFundsToWalletDto addFundsToWalletDto) {
        dev.itsjofi.simpledigitalwallet.entity.Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException(walletId));
        creditWallet(wallet, addFundsToWalletDto.amount());

        return walletRepository.save(wallet);
    }

    public dev.itsjofi.simpledigitalwallet.entity.Wallet getWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() ->  new WalletNotFoundException(walletId));
    }

    public void debitWallet(dev.itsjofi.simpledigitalwallet.entity.Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().subtract(amount));
    }

    public void creditWallet(Wallet wallet, BigDecimal amount) {
        wallet.setBalance(wallet.getBalance().add(amount));
    }
}
