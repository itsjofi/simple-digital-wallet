package dev.itsjofi.simpledigitalwallet.modules.authorization.dto;

public record AuthorizationResponse(String status, Data data) {
    public record Data(boolean authorization) {}
}
