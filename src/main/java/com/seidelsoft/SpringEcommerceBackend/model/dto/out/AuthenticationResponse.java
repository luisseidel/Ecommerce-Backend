package com.seidelsoft.SpringEcommerceBackend.model.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private String id;
	private String email;
	private String name;
    private String token;

}
