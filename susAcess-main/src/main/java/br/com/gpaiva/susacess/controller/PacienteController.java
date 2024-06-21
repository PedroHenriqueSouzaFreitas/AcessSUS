package br.com.gpaiva.susacess.controller;


import br.com.gpaiva.susacess.model.dto.PacienteInputDTO;
import br.com.gpaiva.susacess.model.dto.PacienteOutDTO;
import br.com.gpaiva.susacess.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteOutDTO> cadastrar(@RequestBody PacienteInputDTO pacienteInputDTO) {
        PacienteOutDTO pacienteOutDTO = pacienteService.cadastrar(pacienteInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteOutDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteOutDTO> obterPaciente(@PathVariable Long id) {
        PacienteOutDTO pacienteOutDTO = pacienteService.obterPaciente(id);
        return ResponseEntity.ok(pacienteOutDTO);
    }

    @GetMapping
    public ResponseEntity<List<PacienteOutDTO>> listarPacientes() {
        List<PacienteOutDTO> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteOutDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteInputDTO pacienteInputDTO) {
        PacienteOutDTO pacienteOutDTO = pacienteService.atualizarPaciente(id, pacienteInputDTO);
        return ResponseEntity.ok(pacienteOutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

}
