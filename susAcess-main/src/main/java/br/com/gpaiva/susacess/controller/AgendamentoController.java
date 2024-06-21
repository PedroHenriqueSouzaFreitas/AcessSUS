package br.com.gpaiva.susacess.controller;
import br.com.gpaiva.susacess.model.dto.AgendamentoInputDTO;
import br.com.gpaiva.susacess.model.dto.AgendamentoOutDTO;
import br.com.gpaiva.susacess.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoOutDTO> agendar(@RequestBody AgendamentoInputDTO agendamentoInputDTO) {
        AgendamentoOutDTO agendamentoOutDTO = agendamentoService.agendar(agendamentoInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoOutDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoOutDTO> obterAgendamento(@PathVariable Long id) {
        AgendamentoOutDTO agendamentoOutDTO = agendamentoService.obterAgendamento(id);
        return ResponseEntity.ok(agendamentoOutDTO);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoOutDTO>> listarAgendamentos() {
        List<AgendamentoOutDTO> agendamentos = agendamentoService.listarAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoOutDTO> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoInputDTO agendamentoInputDTO) {
        AgendamentoOutDTO agendamentoOutDTO = agendamentoService.atualizarAgendamento(id, agendamentoInputDTO);
        return ResponseEntity.ok(agendamentoOutDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id) {
        agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}



