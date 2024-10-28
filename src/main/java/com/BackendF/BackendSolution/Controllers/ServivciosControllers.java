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

import com.BackendF.BackendSolution.Models.Servicio_at;
import com.BackendF.BackendSolution.Repository.IServicio_atServices;
import com.BackendF.BackendSolution.Services.Servicos_atServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/Servicios_atControllers")

public class ServivciosControllers {
  private static final Logger LOGGER = LoggerFactory.getLogger(Servicos_atServices.class);

  @Autowired
  IServicio_atServices servicio_atServices;

  @PostMapping("/insertarServicios_at")
    public ResponseEntity<Servicio_at> creaClientes(@RequestBody Servicio_at servicio_at){
        try{
            Servicio_at createdServicio = servicio_atServices.creaServicio(servicio_at);
            return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminarSertvicios/{id}")
    public ResponseEntity<HashMap<String, String>> deleteServicio(@PathVariable int id){
        try{
            HashMap<String, String> response =servicio_atServices.deleteServicio(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/listarServicios")
    public ResponseEntity<List<Servicio_at>> getAllServicio(){
        try{
            List<Servicio_at> servicio_at = servicio_atServices.getAllServicio();
            return new ResponseEntity<>(servicio_at, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizarServicio")
    public ResponseEntity<Servicio_at> updateClientes(@RequestBody Servicio_at servicio_at) {
        try{
            Servicio_at updateServicio = servicio_atServices.updateServicio(servicio_at);
            return new ResponseEntity<>(updateServicio, HttpStatus.OK);
        }catch (RuntimeException e) {
            LOGGER.error("Error al actualizar el Servicio: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            LOGGER.error("Error al actualizar el Servicio: {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
