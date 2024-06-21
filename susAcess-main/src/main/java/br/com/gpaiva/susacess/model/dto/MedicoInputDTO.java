package br.com.gpaiva.susacess.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class MedicoInputDTO {
    private String crm;
    private String nome;
    private List<String> ruas;
    private List<String> diasAtendimento;
    private List<String> turnos;
}
