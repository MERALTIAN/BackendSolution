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

import com.BackendF.BackendSolution.Models.Agente_Co;
import com.BackendF.BackendSolution.Repository.IAgente_CoServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/AgenteControllers")

public class AgenteControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(AgenteControllers.class);
    @Autowired
    IAgente_CoServices agente_CoServices;

    @PostMapping("/insertarAgente")
    public ResponseEntity<Agente_Co> creaAgente(@RequestBody Agente_Co agente_Co){
        try{
            Agente_Co createdAgente = agente_CoServices.creaAgente(agente_Co);
            return new ResponseEntity<>(createdAgente, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarAgente/{id}")
    public ResponseEntity<HashMap<String, String>> deleteAgente(@PathVariable int id){
        try{
            HashMap<String, String> response =agente_CoServices.deleteAgente(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarAgente")
    public ResponseEntity<List<Agente_Co>> getAllAgente(){
        try{
            List<Agente_Co> agente_Co = agente_CoServices.getAllAgente();
            return new ResponseEntity<>(agente_Co, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarAgente")
    public ResponseEntity<Agente_Co> updateAgente(@RequestBody Agente_Co agente_Co) {
        try{
            Agente_Co updateAgente = agente_CoServices.updateAgente(agente_Co);
            return new ResponseEntity<>(updateAgente, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el Agente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el Agente: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
