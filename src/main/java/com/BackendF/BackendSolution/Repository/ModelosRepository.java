package com.BackendF.BackendSolution.Repository;

import org.springframework.stereotype.Repository;
import com.BackendF.BackendSolution.Models.Modelos;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ModelosRepository extends JpaRepository<Modelos, Integer> {

}
