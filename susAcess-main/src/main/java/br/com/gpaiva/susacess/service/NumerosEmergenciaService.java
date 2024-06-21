package br.com.gpaiva.susacess.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gpaiva.susacess.model.NumerosEmergencia;
import br.com.gpaiva.susacess.model.dto.NumerosEmergenciaOutDTO;
import br.com.gpaiva.susacess.repository.NumerosEmergenciaRepository;

public class NumerosEmergenciaService {
    
    @Autowired
    private NumerosEmergenciaRepository repository;

    public List<NumerosEmergenciaOutDTO> getAllNumerosEmergencias() {
        return repository.findAll().stream().map(this::convertToOutDTO).collect(Collectors.toList());
    }

    private NumerosEmergenciaOutDTO convertToOutDTO(NumerosEmergencia NumerosEmergencia) {
        NumerosEmergenciaOutDTO outDTO = new NumerosEmergenciaOutDTO();
        outDTO.setId(NumerosEmergencia.getId());
        outDTO.setName(NumerosEmergencia.getName());
        outDTO.setNumber(NumerosEmergencia.getNumber());
        return outDTO;
    }

}
