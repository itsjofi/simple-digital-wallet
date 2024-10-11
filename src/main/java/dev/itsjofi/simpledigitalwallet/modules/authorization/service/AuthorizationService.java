package dev.itsjofi.simpledigitalwallet.modules.authorization.service;

import dev.itsjofi.simpledigitalwallet.client.AuthorizationClient;
import dev.itsjofi.simpledigitalwallet.exception.DefaultException;
import dev.itsjofi.simpledigitalwallet.exception.UnauthorizedTransferException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationClient authorizationClient;

    public void authorize() {
        try {
            authorizationClient.authorize();
        } catch (FeignException.FeignClientException e) {
            if (e.status() == 403) {
                throw new UnauthorizedTransferException();
            }

            throw new DefaultException();
        }
    }
}
