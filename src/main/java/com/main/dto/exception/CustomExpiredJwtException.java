package com.main.dto.exception;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;

public class CustomExpiredJwtException extends ExpiredJwtException {

    private String customMessage;

    public CustomExpiredJwtException(Header<?> header, Claims claims, String customMessage) {
        super(header, claims, customMessage);
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + ": " + customMessage;
    }
}
