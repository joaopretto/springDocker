package com.springdocker.springdocker.repository;

import com.springdocker.springdocker.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {
}
