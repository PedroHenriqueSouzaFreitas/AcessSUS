package br.com.gpaiva.susacess.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cartaoSus;

    @Embedded
    private Endereco endereco;
}
