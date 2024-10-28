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

import com.BackendF.BackendSolution.Models.Factura;
import com.BackendF.BackendSolution.Repository.IFacturaServices;
import com.BackendF.BackendSolution.Services.FacturaServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/FacturaControllers")

public class FacturaControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacturaServices.class);

    @Autowired
    IFacturaServices facturaServices;

    @PostMapping("/insertarFacturas")
    public ResponseEntity<Factura> creaFacturas(@RequestBody Factura factura){
        try{
            Factura createdFactura = facturaServices.creaFacturas(factura);
            return new ResponseEntity<>(createdFactura, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/eliminarFactura/{id}")
    public ResponseEntity<HashMap<String, String>> deletefactura(@PathVariable int id){
        try{
            HashMap<String, String> response =facturaServices.deletefactura(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listarFactura")
    public ResponseEntity<List<Factura>> getAllFActuras(){
        try{
            List<Factura> facturas = facturaServices.getAllFActuras();
            return new ResponseEntity<>(facturas, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/actualizarFactura")
    public ResponseEntity<Factura> updateFacturas(@RequestBody Factura factura) {
        try{
            Factura updateFacturas = facturaServices.updateFacturas(factura);
            return new ResponseEntity<>(updateFacturas, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el factura: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el factura: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
