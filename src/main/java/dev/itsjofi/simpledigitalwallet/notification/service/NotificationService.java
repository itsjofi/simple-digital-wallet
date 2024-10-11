package dev.itsjofi.simpledigitalwallet.notification.service;

import dev.itsjofi.simpledigitalwallet.notification.client.NotificationClient;
import dev.itsjofi.simpledigitalwallet.transfer.entity.Transfer;
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
