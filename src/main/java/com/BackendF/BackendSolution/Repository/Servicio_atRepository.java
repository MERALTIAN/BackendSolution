package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Servicio_at;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Servicio_atRepository extends JpaRepository<Servicio_at, Integer>{

}
