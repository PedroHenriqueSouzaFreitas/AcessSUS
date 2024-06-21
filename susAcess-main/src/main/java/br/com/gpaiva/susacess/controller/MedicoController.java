package br.com.gpaiva.susacess.controller;

import br.com.gpaiva.susacess.model.dto.MedicoInputDTO;
import br.com.gpaiva.susacess.model.dto.MedicoOutDTO;

import br.com.gpaiva.susacess.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoOutDTO> cadastrar(@RequestBody MedicoInputDTO medicoInputDTO) {
        MedicoOutDTO medicoOutDTO = medicoService.cadastrar(medicoInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoOutDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoOutDTO> obterMedico(@PathVariable Long id) {
        MedicoOutDTO medicoOutDTO = medicoService.obterMedico(id);
        return ResponseEntity.ok(medicoOutDTO);
    }

    @GetMapping
    public ResponseEntity<List<MedicoOutDTO>> listarMedicos() {
        List<MedicoOutDTO> medicos = medicoService.listarMedicos();
        return ResponseEntity.ok(medicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoOutDTO> atualizarMedico(@PathVariable Long id, @RequestBody MedicoInputDTO medicoInputDTO) {
        MedicoOutDTO medicoOutDTO = medicoService.atualizarMedico(id, medicoInputDTO);
        return ResponseEntity.ok(medicoOutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}


