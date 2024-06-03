package com.springdocker.springdocker.service;

import com.springdocker.springdocker.DTO.AlunosDTO;
import com.springdocker.springdocker.DTO.MateriasDTO;
import com.springdocker.springdocker.model.Alunos;
import com.springdocker.springdocker.model.Materias;
import com.springdocker.springdocker.repository.MateriasRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MateriasServices {

    private final MateriasRepository repository;

    public MateriasServices(MateriasRepository repository){
        this.repository = repository;
    }

    public MateriasDTO criar(MateriasDTO materiasDTO){
        Materias materias = new Materias();
        materias.setMateria(materiasDTO.getMateria());
        repository.save(materias);
        materiasDTO.setId(materias.getId());
        return materiasDTO;
    }

    public MateriasDTO converter (Materias materias){
        MateriasDTO result = new MateriasDTO();
        result.setId(materias.getId());
        result.setMateria(materias.getMateria());
        return result;
    }

    public List<MateriasDTO> getAll (){
        return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public String delete(Long materiaId){
        repository.deleteById(materiaId);
        return "DELETED";
    }
}
