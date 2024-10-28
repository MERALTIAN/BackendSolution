package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository; 

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{

}
