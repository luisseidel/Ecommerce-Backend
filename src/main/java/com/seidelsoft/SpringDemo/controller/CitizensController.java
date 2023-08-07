package com.seidelsoft.SpringDemo.controller;

import com.seidelsoft.SpringDemo.model.dto.in.CitizenDTO;
import com.seidelsoft.SpringDemo.model.entity.Citizen;
import com.seidelsoft.SpringDemo.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citizens")
public class CitizensController implements SecuredController {

    @Autowired
    private CitizenRepository repository;

    @GetMapping
    public List<Citizen> getCitizens() {
        return repository.findAll();
    }

    @PostMapping
    public Citizen create(@RequestBody CitizenDTO dto) {
        return repository.save(new Citizen(dto.getCpf(), dto.getNome(), dto.getEndereco(), dto.getSexo()));
    }

    @PutMapping("/{id}")
    public Citizen update(@PathVariable Long id, @RequestBody CitizenDTO dto) {
        Citizen c = repository.getReferenceById(id);
        c.setCpf(dto.getCpf());
        c.setSexo(dto.getSexo());
        c.setNome(dto.getNome());
        c.setEndereco(dto.getEndereco());

        return repository.save(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }
}
