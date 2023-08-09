package com.seidelsoft.SpringEcommerceBackend.model.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN(0L, "Admin"),
    USER(1L, "User");

    private final Long value;
    private final String description;
}
