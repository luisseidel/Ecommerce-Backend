package com.seidelsoft.SpringEcommerceBackend.model.dto.in;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

	public RegisterRequest(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
