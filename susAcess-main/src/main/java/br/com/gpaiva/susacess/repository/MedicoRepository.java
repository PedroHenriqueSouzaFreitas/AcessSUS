package br.com.gpaiva.susacess.repository;


import br.com.gpaiva.susacess.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {}
