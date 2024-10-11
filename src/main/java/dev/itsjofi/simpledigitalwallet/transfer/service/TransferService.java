package dev.itsjofi.simpledigitalwallet.transfer.service;

import dev.itsjofi.simpledigitalwallet.notification.service.NotificationService;
import dev.itsjofi.simpledigitalwallet.transfer.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.transfer.entity.Transfer;
import dev.itsjofi.simpledigitalwallet.transfer.repository.TransferRepository;
import dev.itsjofi.simpledigitalwallet.transfer.validation.TransferValidator;
import dev.itsjofi.simpledigitalwallet.wallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public List<Transfer> findAll(String senderId, String receiverId) {
        if (senderId != null && receiverId != null) {
            return transferRepository.findTransferBySenderIdAndReceiverId(
                    Long.parseLong(senderId),
                    Long.parseLong(receiverId));
        }

        if (senderId != null) {
            return transferRepository.findTransferBySenderId(Long.parseLong(senderId));
        }

        if (receiverId != null) {
            return transferRepository.findTransferByReceiverId(Long.parseLong(receiverId));
        }

        return transferRepository.findAll();
    }

    @Transactional
    public Transfer transfer(TransferDto transferDto) {
        Wallet payer = walletService.getWalletById(transferDto.payer());
        Wallet payee = walletService.getWalletById(transferDto.payee());

        transferValidator.validate(payer, transferDto);
        walletService.debitWallet(payer, transferDto.value());
        walletService.creditWallet(payee, transferDto.value());

        Transfer transfer = transferRepository.save(transferDto.toTransferEntity());

        CompletableFuture.runAsync(() -> notificationService.notify(transfer));

        return transfer;
    }
}
