package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer>{

}
