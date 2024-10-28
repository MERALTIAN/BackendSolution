package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Factura;
import com.BackendF.BackendSolution.Repository.IFacturaServices;
import com.BackendF.BackendSolution.Repository.FacturaRepository;
import java.util.HashMap;
import java.util.List;

@Service
public class FacturaServices implements IFacturaServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacturaServices.class);

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public Factura creaFacturas(Factura factura) {
        try{
            return facturaRepository.save(factura);
        }catch(Exception e){
            LOGGER.error("Error craeting factura: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
    }  

    @Override
    public HashMap<String, String> deletefactura(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            facturaRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }
    @Override 
    public List<Factura> getAllFActuras() {
        try{
            return facturaRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while facturas:{}", e.getMessage());
            throw new RuntimeException("Error fetching factura");
        }
    }

    @Override
    public Factura updateFacturas(Factura factura) {
        if(facturaRepository.existsById(factura.getIDFactura())){
            return facturaRepository.save(factura);
        }else{
            LOGGER.error("Factura no encontrado con ID: {}",factura.getIDFactura());
            throw new RuntimeException("Factura no encontrado");
        }
    }

}
