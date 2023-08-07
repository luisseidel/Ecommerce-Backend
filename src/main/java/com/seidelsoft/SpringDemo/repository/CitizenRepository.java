package com.seidelsoft.SpringDemo.repository;

import com.seidelsoft.SpringDemo.model.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
