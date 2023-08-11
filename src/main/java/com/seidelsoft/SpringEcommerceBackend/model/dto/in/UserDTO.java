package com.seidelsoft.SpringEcommerceBackend.model.dto.in;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO extends RegisterRequest {

	public UserDTO(@NotEmpty String name, @NotEmpty String email) {
		super(name, email);
	}
}
