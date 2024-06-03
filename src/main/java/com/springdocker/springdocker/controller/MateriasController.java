package com.springdocker.springdocker.controller;

import com.springdocker.springdocker.DTO.MateriasDTO;
import com.springdocker.springdocker.service.MateriasServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/materias")
public class MateriasController {

    private final MateriasServices materiasServices;

    public MateriasController(MateriasServices materiasServices){
        this.materiasServices = materiasServices;
    }

    @PostMapping
    public MateriasDTO criar(@RequestBody MateriasDTO materiasDTO){
        return materiasServices.criar(materiasDTO);
    }

    @GetMapping
    public List<MateriasDTO> getAll(){
        return materiasServices.getAll();
    }

    @DeleteMapping("/{materiaId}")
    public String deletar(@PathVariable("materiaId") Long materiaId){
        return materiasServices.delete(materiaId);
    }
}
