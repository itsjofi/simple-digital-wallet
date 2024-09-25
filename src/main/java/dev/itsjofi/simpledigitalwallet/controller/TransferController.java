package dev.itsjofi.simpledigitalwallet.controller;

import dev.itsjofi.simpledigitalwallet.controller.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import dev.itsjofi.simpledigitalwallet.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/transfer")
    public ResponseEntity<List<Transfer>> findAll(
            @RequestParam(name = "senderId", required = false) String senderId,
            @RequestParam(name = "receiverId", required = false) String receiverId) {
        return new ResponseEntity<>(transferService.findAll(senderId, receiverId), HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto transferDto) {
        return new ResponseEntity<>(transferService.transfer(transferDto), HttpStatus.OK);
    }
}
