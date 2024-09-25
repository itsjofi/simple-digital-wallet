package dev.itsjofi.simpledigitalwallet.service;

import dev.itsjofi.simpledigitalwallet.controller.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.repository.TransferRepository;
import dev.itsjofi.simpledigitalwallet.validation.TransferValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TransferValidator transferValidator;

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        Wallet payer = walletService.getWalletById(transferDto.payer());
        Wallet payee = walletService.getWalletById(transferDto.payee());

        transferValidator.validate(payer, payee, transferDto);
        walletService.debitWallet(payer, transferDto.value());
        walletService.creditWallet(payee, transferDto.value());

        Transfer transfer = transferRepository.save(transferDto.toTransferEntity());

        CompletableFuture.runAsync(() -> notificationService.notify(transfer));

        return transfer;
    }
}
