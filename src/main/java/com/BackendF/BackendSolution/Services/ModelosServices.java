package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Modelos;
import com.BackendF.BackendSolution.Repository.ModelosRepository;
import com.BackendF.BackendSolution.Repository.IModelosServices;
import java.util.HashMap;
import java.util.List;

@Service
public class ModelosServices implements IModelosServices {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelosServices.class);

    @Autowired
    ModelosRepository modelosRepository;

    @Override
    public Modelos creaModelos(Modelos modelos){
        try{
            return modelosRepository.save(modelos);
        }catch(Exception e){
            LOGGER.error("Error craeting modelo: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        } 
    }

    @Override
    public HashMap<String, String> deleteModelos(int Id){
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            modelosRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
    }

    @Override
    public List<Modelos> getAllModelos(){
        try{
            return modelosRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while modelo:{}", e.getMessage());
            throw new RuntimeException("Error fetching modelo");
        }
    }

    @Override
    public Modelos updateModelos(Modelos modelos){
        if(modelosRepository.existsById(modelos.getIDModelo())){
            return modelosRepository.save(modelos);
        }else{
            LOGGER.error("Modelo no encontrado con ID: {}",modelos.getIDModelo());
            throw new RuntimeException("Modelo no encontrado");
        }
    }

}
