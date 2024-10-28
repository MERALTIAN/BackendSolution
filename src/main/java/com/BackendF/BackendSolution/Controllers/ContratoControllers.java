package com.BackendF.BackendSolution.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendF.BackendSolution.Models.Contrato;
import com.BackendF.BackendSolution.Repository.IContratoServices;
import com.BackendF.BackendSolution.Services.ContratoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ContratoControllers")


public class ContratoControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContratoServices.class);

    @Autowired
    IContratoServices contratoServices;

    @PostMapping("/insertarContrato")
    public ResponseEntity<Contrato> creaContrato(@RequestBody Contrato contrato){
        try{
            Contrato createdContrato = contratoServices.creaContrato(contrato);
            return new ResponseEntity<>(createdContrato, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarContrato/{id}")
    public ResponseEntity<HashMap<String, String>> deletecontrato(@PathVariable int id){
        try{
            HashMap<String, String> response =contratoServices.deletecontrato(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarContrato")
    public ResponseEntity<List<Contrato>> getAllContrato(){
        try{
            List<Contrato> contrato = contratoServices.getAllContrato();
            return new ResponseEntity<>(contrato, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarContrato")
    public ResponseEntity<Contrato> updateContrato(@RequestBody Contrato contrato) {
        try{
            Contrato updateContrato = contratoServices.updateContrato(contrato);
            return new ResponseEntity<>(updateContrato, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el contrato: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el contrato: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
