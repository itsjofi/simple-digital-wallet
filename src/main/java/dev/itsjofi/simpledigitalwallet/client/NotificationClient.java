package dev.itsjofi.simpledigitalwallet.client;

import dev.itsjofi.simpledigitalwallet.entity.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "NotificationService",
        url = "${client.notification-service.url}"
)
public interface NotificationClient {

    @PostMapping
    void notify(Transfer transfer);
}
