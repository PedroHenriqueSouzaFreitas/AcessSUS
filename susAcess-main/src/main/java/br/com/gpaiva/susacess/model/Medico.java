package br.com.gpaiva.susacess.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crm;
    private String nome;

    @ElementCollection
    private List<String> ruas;

    @ElementCollection
    private List<String> diasAtendimento;

    @ElementCollection
    private List<String> turnos;
}
