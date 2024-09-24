package dev.itsjofi.simpledigitalwallet.controller;

import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto createWalletDto) {
        return new ResponseEntity<>(walletService.create(createWalletDto), HttpStatus.CREATED);
    }
}
