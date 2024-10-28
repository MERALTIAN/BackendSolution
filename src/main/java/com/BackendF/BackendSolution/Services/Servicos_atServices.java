package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Servicio_at;
import com.BackendF.BackendSolution.Repository.IServicio_atServices;
import com.BackendF.BackendSolution.Repository.Servicio_atRepository;
import java.util.HashMap;
import java.util.List;


@Service
public class Servicos_atServices implements IServicio_atServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(Servicos_atServices.class);

    @Autowired
    Servicio_atRepository servicio_atRepository;

    @Override
    public Servicio_at creaServicio(Servicio_at servicio_at) {
        try{
            return servicio_atRepository.save(servicio_at);
        }catch(Exception e){
            LOGGER.error("Error craeting Servicio: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
        
    } 

    @Override
    public HashMap<String, String> deleteServicio(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            servicio_atRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }

    @Override 
    public List<Servicio_at> getAllServicio() {
        try{
            return servicio_atRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while Servicios:{}", e.getMessage());
            throw new RuntimeException("Error fetching servicio");
        }
    }

    @Override
    public Servicio_at updateServicio(Servicio_at servicio_at) {
        if(servicio_atRepository.existsById(servicio_at.getIDServicio_At())){
            return servicio_atRepository.save(servicio_at);
        }else{
            LOGGER.error("Servicio no encontrado con ID: {}",servicio_at.getIDServicio_At());
            throw new RuntimeException("Servicio no encontrado");
        }
    }
}
