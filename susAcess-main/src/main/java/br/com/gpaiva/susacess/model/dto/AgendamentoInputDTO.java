package br.com.gpaiva.susacess.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendamentoInputDTO {
    private Long medicoId;
    private Long pacienteId;
    private LocalDateTime dataHora;
}
