package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Agente_Co;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AgenteRepository extends JpaRepository<Agente_Co, Integer> {

}
