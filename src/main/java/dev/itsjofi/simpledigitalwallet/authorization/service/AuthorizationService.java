package dev.itsjofi.simpledigitalwallet.authorization.service;

import dev.itsjofi.simpledigitalwallet.authorization.client.AuthorizationClient;
import dev.itsjofi.simpledigitalwallet.authorization.exception.UnauthorizedTransferException;
import dev.itsjofi.simpledigitalwallet.common.exception.DefaultException;
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
