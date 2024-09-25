package dev.itsjofi.simpledigitalwallet.service;

import dev.itsjofi.simpledigitalwallet.client.NotificationClient;
import dev.itsjofi.simpledigitalwallet.controller.dto.TransferDto;
import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationClient notificationClient;

    public void notify(Transfer transfer) {
        notificationClient.notify(transfer);
    }
}
