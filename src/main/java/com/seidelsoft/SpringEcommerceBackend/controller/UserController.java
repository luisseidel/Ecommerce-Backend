package com.seidelsoft.SpringEcommerceBackend.controller;

import com.seidelsoft.SpringEcommerceBackend.model.dto.in.UserDTO;
import com.seidelsoft.SpringEcommerceBackend.model.entity.User;
import com.seidelsoft.SpringEcommerceBackend.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements SecuredController {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	@CrossOrigin
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable String id) {
		return repository.findById(id);
	}

	@PutMapping("/{id}")
	public Optional<User> update(@PathVariable String id, @RequestBody UserDTO dto) {
		Optional<User> c = repository.findById(id);

		c.ifPresent( user -> {
			c.get().setName(dto.getName());
			c.get().setEmail(dto.getEmail());
			//password dont changed
			if (!StringUtils.isAllBlank(dto.getPassword())) {
				c.get().setPassword(passwordEncoder.encode(dto.getPassword()));
			}
			repository.save(c.get());
		});

		return c;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {
		repository.delete(new User(id));
		return ResponseEntity.ok().build();
	}
}
