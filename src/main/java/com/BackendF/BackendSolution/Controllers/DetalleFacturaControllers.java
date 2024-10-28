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
import com.BackendF.BackendSolution.Models.DetalleFactura;
import com.BackendF.BackendSolution.Repository.IDetalleFacturaServices;
import com.BackendF.BackendSolution.Services.DetalleFacturaServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/DetalleControllers")


public class DetalleFacturaControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleFacturaServices.class);

    @Autowired
    IDetalleFacturaServices detalleFacturaServices;

    @PostMapping("/insertarDetalles")
    public ResponseEntity<DetalleFactura> creaDetalle(@RequestBody DetalleFactura detalleFactura){
        try{
            DetalleFactura createdDetalle = detalleFacturaServices.creaDetalle(detalleFactura);
            return new ResponseEntity<>(createdDetalle, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarDetalle/{id}")
    public ResponseEntity<HashMap<String, String>> deleteDetallle(@PathVariable int id){
        try{
            HashMap<String, String> response =detalleFacturaServices.deleteDetallle(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarDetalles")
    public ResponseEntity<List<DetalleFactura>> getAllDetalle(){
        try{
            List<DetalleFactura> detalleFacturas = detalleFacturaServices.getAllDetalle();
            return new ResponseEntity<>(detalleFacturas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarClientes")
    public ResponseEntity<DetalleFactura> updateDetalles(@RequestBody DetalleFactura detalleFactura) {
        try{
            DetalleFactura updateDetalles = detalleFacturaServices.updateDetalles(detalleFactura);
            return new ResponseEntity<>(updateDetalles, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el detalles: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el detalles: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
