package br.com.gpaiva.susacess.repository;


import br.com.gpaiva.susacess.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {}
