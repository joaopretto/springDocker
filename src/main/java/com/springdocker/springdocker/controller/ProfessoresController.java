package com.springdocker.springdocker.controller;

import com.springdocker.springdocker.DTO.ProfessoresDTO;
import com.springdocker.springdocker.service.ProfessoresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/professores")
public class ProfessoresController {

    private final ProfessoresService professoresService;

    public ProfessoresController(ProfessoresService professoresService) {
        this.professoresService = professoresService;
    }

    @PostMapping
    public ProfessoresDTO criar(@RequestBody ProfessoresDTO professoresDTO){
        return professoresService.criar(professoresDTO);
    }

    @GetMapping
    public List<ProfessoresDTO> getAll(){
        return professoresService.getAll();
    }

    @DeleteMapping("/{professoresId}")
    public String deletar(@PathVariable("professoresId") Long professoresId){
        return professoresService.delete(professoresId);
    }

}
