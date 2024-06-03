package com.springdocker.springdocker.service;

import com.springdocker.springdocker.DTO.AlunosDTO;
import com.springdocker.springdocker.model.Alunos;
import com.springdocker.springdocker.repository.AlunosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class AlunosServices {

    private final AlunosRepository repository;

    public AlunosServices(AlunosRepository repository) {
        this.repository = repository;
    }

    public AlunosDTO criar(AlunosDTO alunosDTO){
        Alunos alunos = new Alunos();
        alunos.setNome(alunosDTO.getNome());
        alunos.setEmail(alunosDTO.getEmail());
        alunos.setCpf(alunosDTO.getCpf());
        repository.save(alunos);
        alunosDTO.setId(alunos.getId());
        return alunosDTO;
    }

    public AlunosDTO atualizar(AlunosDTO alunosDTO, Long alunosId){
        Alunos alunosDatabase = repository.getReferenceById(alunosId);
        alunosDatabase.setNome(alunosDTO.getNome());
        alunosDatabase.setEmail(alunosDTO.getEmail());
        alunosDatabase.setCpf(alunosDTO.getCpf());
        return alunosDTO;
    }

    public AlunosDTO converter (Alunos alunos){
        AlunosDTO result = new AlunosDTO();
        result.setId(alunos.getId());
        result.setNome(alunos.getNome());
        result.setEmail(alunos.getEmail());
        result.setCpf(alunos.getCpf());
        return result;
    }

    public List<AlunosDTO> getAll (){
        return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public String delete(Long alunosId){
        repository.deleteById(alunosId);
        return "DELETED";
    }
}
