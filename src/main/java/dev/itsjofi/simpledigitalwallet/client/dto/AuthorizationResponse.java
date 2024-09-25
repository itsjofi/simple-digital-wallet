package dev.itsjofi.simpledigitalwallet.client.dto;

public record AuthorizationResponse(String status, Data data) {
    public record Data(boolean authorization) {}
}
