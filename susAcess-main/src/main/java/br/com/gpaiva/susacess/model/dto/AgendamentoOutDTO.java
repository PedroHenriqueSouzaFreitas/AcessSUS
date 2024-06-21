package br.com.gpaiva.susacess.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendamentoOutDTO {
    private Long id;
    private Long medicoId;
    private Long pacienteId;
    private LocalDateTime dataHora;
}
