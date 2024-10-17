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

import com.BackendF.BackendSolution.Models.Modelos;
import com.BackendF.BackendSolution.Repository.IModelosServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ModelosCntrollers")

public class ModelosCntrollers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelosCntrollers.class);
    @Autowired
    IModelosServices modelosServices;

    @PostMapping("/insertarModelos")
    public ResponseEntity<Modelos> creaModelos(@RequestBody Modelos modelos){
        try{
            Modelos createdModelos = modelosServices.creaModelos(modelos);
            return new ResponseEntity<>(createdModelos, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminarModelos/{id}")
    public ResponseEntity<HashMap<String, String>> deleteModelos(@PathVariable int id){
        try{
            HashMap<String, String> response =modelosServices.deleteModelos(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarModelos")
    public ResponseEntity<List<Modelos>> getAllModelos(){
        try{
            List<Modelos> Modelos = modelosServices.getAllModelos();
            return new ResponseEntity<>(Modelos, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarModelos")
    public ResponseEntity<Modelos> updateModelos(@RequestBody Modelos modelos) {
        try{
            Modelos updateModelos = modelosServices.updateModelos(modelos);
            return new ResponseEntity<>(updateModelos, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el cliente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el cliente: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
