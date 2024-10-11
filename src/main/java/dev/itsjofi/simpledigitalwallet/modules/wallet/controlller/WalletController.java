package dev.itsjofi.simpledigitalwallet.modules.wallet.controlller;

import dev.itsjofi.simpledigitalwallet.controller.dto.AddFundsToWalletDto;
import dev.itsjofi.simpledigitalwallet.controller.dto.CreateWalletDto;
import dev.itsjofi.simpledigitalwallet.entity.Wallet;
import dev.itsjofi.simpledigitalwallet.service.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/wallet")
    public ResponseEntity<List<dev.itsjofi.simpledigitalwallet.entity.Wallet>> findAll() {
        return new ResponseEntity<>(walletService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/wallet/{id}")
    public ResponseEntity<Optional<dev.itsjofi.simpledigitalwallet.entity.Wallet>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(walletService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/wallet")
    public ResponseEntity<dev.itsjofi.simpledigitalwallet.entity.Wallet> createWallet(@RequestBody @Valid CreateWalletDto createWalletDto) {
        return new ResponseEntity<>(walletService.create(createWalletDto), HttpStatus.CREATED);
    }

    @PostMapping("/wallet/{id}/add-funds")
    public ResponseEntity<Wallet> addFunds(
            @PathVariable Long id,
            @RequestBody @Valid AddFundsToWalletDto addFundsToWalletDto) {
        return new ResponseEntity<>(walletService.addFunds(id, addFundsToWalletDto), HttpStatus.OK);
    }
}
