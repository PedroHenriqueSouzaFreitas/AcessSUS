package br.com.gpaiva.susacess.repository;


import br.com.gpaiva.susacess.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}
