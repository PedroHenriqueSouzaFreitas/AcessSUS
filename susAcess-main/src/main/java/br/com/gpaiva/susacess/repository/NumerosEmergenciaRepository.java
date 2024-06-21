package br.com.gpaiva.susacess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gpaiva.susacess.model.NumerosEmergencia;

public interface NumerosEmergenciaRepository extends JpaRepository<NumerosEmergencia, Long> {
    
}
