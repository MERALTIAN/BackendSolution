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

import com.BackendF.BackendSolution.Models.Beneficiarios;
import com.BackendF.BackendSolution.Repository.IBeneficiarioServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/BeneficiarioControllers")
public class BeneficiarioControllers {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeneficiarioControllers.class);
    @Autowired
    IBeneficiarioServices beneficiarioServices;

    @PostMapping("/InsertarBeneficiario")
public ResponseEntity<Beneficiarios> creaBeneficiarios(@RequestBody Beneficiarios beneficiarios){
    try{
        Beneficiarios createdBeneficiarios = beneficiarioServices.creaBeneficiarios(beneficiarios);
        return new ResponseEntity<>(createdBeneficiarios,HttpStatus.CREATED);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@DeleteMapping("/eliminarBeneficiario/{id}")
    public ResponseEntity<HashMap<String, String>> deleteBenificiario(@PathVariable int id){
        try{
            HashMap<String, String> response =beneficiarioServices.deleteBeneficiario(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarBeneficiario")
    public ResponseEntity<List<Beneficiarios>> getAllBeneficiarios(){
        try{
            List<Beneficiarios> beneficiarios = beneficiarioServices.getAllBeneficiarios();
            return new ResponseEntity<>(beneficiarios, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarBeneficiarios")
    public ResponseEntity<Beneficiarios> updateBeneficiarios(@RequestBody Beneficiarios beneficiarios) {
        try{
            Beneficiarios updateBeneficiarios = beneficiarioServices.updateBeneficiarios(beneficiarios);
            return new ResponseEntity<>(updateBeneficiarios, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el cliente: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el cliente: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
