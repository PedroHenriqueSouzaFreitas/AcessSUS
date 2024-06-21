package br.com.gpaiva.susacess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gpaiva.susacess.model.dto.NumerosEmergenciaOutDTO;
import br.com.gpaiva.susacess.service.NumerosEmergenciaService;

public class NumerosEmergenciaController {
    
    @Autowired
    private NumerosEmergenciaService service;

    @GetMapping
    public List<NumerosEmergenciaOutDTO> getAllNumerosEmergencias() {
        return service.getAllNumerosEmergencias();

}
}
