package dev.itsjofi.simpledigitalwallet.controller;

import dev.itsjofi.simpledigitalwallet.controller.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import dev.itsjofi.simpledigitalwallet.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto transferDto) {
        return new ResponseEntity<>(transferService.transfer(transferDto), HttpStatus.OK);
    }
}
