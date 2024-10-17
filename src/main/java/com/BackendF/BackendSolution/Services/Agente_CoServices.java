package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Agente_Co;
import com.BackendF.BackendSolution.Repository.AgenteRepository;
import com.BackendF.BackendSolution.Repository.IAgente_CoServices;
import java.util.HashMap;
import java.util.List;

@Service
public class Agente_CoServices implements IAgente_CoServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(Agente_CoServices.class);

    @Autowired
    AgenteRepository agenteRepository;

    @Override
    public Agente_Co creaAgente(Agente_Co agente_Co) {
        try{
            return agenteRepository.save(agente_Co);
        }catch(Exception e){
            LOGGER.error("Error craeting cliente: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
    }
    

    @Override
    public HashMap<String, String> deleteAgente(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            agenteRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }

    @Override 
    public List<Agente_Co> getAllAgente() {
        try{
            return agenteRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while clientes:{}", e.getMessage());
            throw new RuntimeException("Error fetching cliente");
        }
    }

    @Override
    public Agente_Co updateAgente(Agente_Co agente_Co) {
        if(agenteRepository.existsById(agente_Co.getIDAgente_co())){
            return agenteRepository.save(agente_Co);
        }else{
            LOGGER.error("Cliente no encontrado con ID: {}",agente_Co.getIDAgente_co());
            throw new RuntimeException("Agente no encontrado");
        }
    }


}
