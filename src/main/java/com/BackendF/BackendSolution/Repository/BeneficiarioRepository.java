package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Beneficiarios;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface BeneficiarioRepository extends JpaRepository<Beneficiarios, Integer>{

}
