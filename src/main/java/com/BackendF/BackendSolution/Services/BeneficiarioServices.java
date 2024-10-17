package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Beneficiarios;
import com.BackendF.BackendSolution.Repository.BeneficiarioRepository;
import com.BackendF.BackendSolution.Repository.IBeneficiarioServices;

import java.util.HashMap;
import java.util.List;

@Service
public class BeneficiarioServices implements IBeneficiarioServices{

    private static final Logger LOGGER = LoggerFactory.getLogger(BeneficiarioServices.class);

    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    @Override
    public Beneficiarios creaBeneficiarios(Beneficiarios beneficiarios){
        try{
            return beneficiarioRepository.save(beneficiarios);
        }catch(Exception e){
            LOGGER.error("Error to create a beneficiario: {}", e.getMessage());
            throw new RuntimeException("Error creating a Beneficiario");
        }
    }

    @Override
    public HashMap<String, String> deleteBeneficiario(int Id){
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("message","Beneficiario deleted succesfully!");
            beneficiarioRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting a beneficiario: {}", e.getMessage());
            throw new RuntimeException("Error deleting Beneficiario");
        }
    }

    @Override
    public List<Beneficiarios> getAllBeneficiarios() {
        try{
            return beneficiarioRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while list beneficiarios: {}", e.getMessage());
            throw new RuntimeException("Error while list beneficiario");
        }
    }

    @Override
    public Beneficiarios updateBeneficiarios(Beneficiarios beneficiarios){
        if(beneficiarioRepository.existsById(beneficiarios.getIDBeneficiarios())){
            return beneficiarioRepository.save(beneficiarios);
        }else{
            LOGGER.error("Beneficiario doesnt exists with ID: {}", beneficiarios.getIDBeneficiarios());
            throw new RuntimeException("Beneficiario doesnt exists");
        }
    }
}
