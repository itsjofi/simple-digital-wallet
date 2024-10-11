package dev.itsjofi.simpledigitalwallet.wallet.service;

import dev.itsjofi.simpledigitalwallet.wallet.dto.AddFundsToWalletDto;
import dev.itsjofi.simpledigitalwallet.wallet.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.wallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.wallet.exception.WalletNotFoundException;
import dev.itsjofi.simpledigitalwallet.wallet.repository.WalletRepository;
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

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> findById(Long id) {
        return walletRepository.findById(id);
    }

    public Wallet create(CreateWalletDto createWalletDto) {
        Wallet wallet = createWalletDto.toWalletEntity();
        wallet.setPassword(passwordEncryptor.encryptPassword(wallet.getPassword()));
        return walletRepository.save(wallet);
    }

    public Wallet addFunds(Long walletId, AddFundsToWalletDto addFundsToWalletDto) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new WalletNotFoundException(walletId));
        creditWallet(wallet, addFundsToWalletDto.amount());

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
