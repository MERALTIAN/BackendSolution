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

import com.BackendF.BackendSolution.Models.Clientes;
import com.BackendF.BackendSolution.Repository.IClienteServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/ClienteControllers")

public class ClienteControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllers.class);
    @Autowired
    IClienteServices clienteServices;

    @PostMapping("/insertarClientes")
    public ResponseEntity<Clientes> creaClientes(@RequestBody Clientes clientes){
        try{
            Clientes createdClientes = clienteServices.creaClientes(clientes);
            return new ResponseEntity<>(createdClientes, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminarCliente/{id}")
    public ResponseEntity<HashMap<String, String>> deleteclinetes(@PathVariable int id){
        try{
            HashMap<String, String> response =clienteServices.deleteclinetes(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Clientes>> getAllClientes(){
        try{
            List<Clientes> clientes = clienteServices.getAllClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizarClientes")
    public ResponseEntity<Clientes> updateClientes(@RequestBody Clientes clientes) {
        try{
            Clientes updateClientes = clienteServices.updateClientes(clientes);
            return new ResponseEntity<>(updateClientes, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el cliente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el cliente: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
