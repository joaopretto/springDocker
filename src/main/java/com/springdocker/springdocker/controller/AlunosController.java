package com.springdocker.springdocker.controller;

import com.springdocker.springdocker.DTO.AlunosDTO;
import com.springdocker.springdocker.service.AlunosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunosServices alunosServices;

    public AlunosController(AlunosServices alunosServices) {
        this.alunosServices = alunosServices;
    }

    @PostMapping
    public AlunosDTO criar(@RequestBody AlunosDTO alunosDTO){
        return alunosServices.criar(alunosDTO);
    }

    @PutMapping("/{alunosId}")
    public AlunosDTO atualizar(@PathVariable("alunosId") Long alunosId, @RequestBody AlunosDTO alunosDTO){
        return alunosServices.atualizar(alunosDTO, alunosId);
    }

    @GetMapping
    public List<AlunosDTO> getAll(){
        return alunosServices.getAll();
    }

    @DeleteMapping("/{alunosId}")
    public String deletar(@PathVariable("alunosId") Long alunosId){
        return alunosServices.delete(alunosId);
    }
}
