package com.springdocker.springdocker.repository;

import com.springdocker.springdocker.model.Professores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoresRepository extends JpaRepository<Professores, Long> {
}
