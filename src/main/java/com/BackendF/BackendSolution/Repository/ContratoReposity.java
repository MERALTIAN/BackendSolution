package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContratoReposity extends JpaRepository<Contrato, Integer>{

}
