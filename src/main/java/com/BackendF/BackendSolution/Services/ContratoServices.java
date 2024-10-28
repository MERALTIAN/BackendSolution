package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Contrato;
import com.BackendF.BackendSolution.Repository.ContratoReposity;
import com.BackendF.BackendSolution.Repository.IContratoServices;
import java.util.HashMap;
import java.util.List;

@Service
public class ContratoServices implements IContratoServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(ContratoServices.class);

    @Autowired
    ContratoReposity contratoReposity;

    @Override
    public Contrato creaContrato(Contrato contrato) {
        try{
            return contratoReposity.save(contrato);
        }catch(Exception e){
            LOGGER.error("Error craeting contrato: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
        
    }

    @Override
    public HashMap<String, String> deletecontrato(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            contratoReposity.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }
    @Override 
    public List<Contrato> getAllContrato() {
        try{
            return contratoReposity.findAll();
        }catch(Exception e){
            LOGGER.error("Error while contratos:{}", e.getMessage());
            throw new RuntimeException("Error fetching contrato");
        }
    }

    @Override
    public Contrato updateContrato(Contrato contrato) {
        if(contratoReposity.existsById(contrato.getIDContrato())){
            return contratoReposity.save(contrato);
        }else{
            LOGGER.error("Contrato no encontrado con ID: {}",contrato.getIDContrato());
            throw new RuntimeException("Contrato no encontrado");
        }
    }

}
