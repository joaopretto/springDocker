package com.springdocker.springdocker.service;

import com.springdocker.springdocker.DTO.ProfessoresDTO;
import com.springdocker.springdocker.model.Professores;
import com.springdocker.springdocker.repository.ProfessoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfessoresService {

    private final ProfessoresRepository repository;

    public ProfessoresService(ProfessoresRepository repository) {
        this.repository = repository;
    }

    public ProfessoresDTO criar(ProfessoresDTO proofessoresDTO){
        Professores professores = new Professores();
        professores.setNome(proofessoresDTO.getNome());
        professores.setCpf((proofessoresDTO.getCpf()));
        repository.save(professores);
        proofessoresDTO.setId(professores.getId());
        return proofessoresDTO;
    }

    public ProfessoresDTO converter (Professores professores){
        ProfessoresDTO result = new ProfessoresDTO();
        result.setId(professores.getId());
        result.setNome(professores.getNome());
        result.setCpf(professores.getCpf());
        return result;
    }

    public List<ProfessoresDTO> getAll (){
        return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public String delete(Long professoresID){
        repository.deleteById(professoresID);
        return "DELETED";
    }
}
