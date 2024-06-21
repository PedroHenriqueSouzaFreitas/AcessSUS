package br.com.gpaiva.susacess.model.dto;


import br.com.gpaiva.susacess.model.Endereco;
import lombok.Data;

@Data
public class PacienteInputDTO {
    private String nome;
    private String cartaoSus;
    private Endereco endereco;
}
