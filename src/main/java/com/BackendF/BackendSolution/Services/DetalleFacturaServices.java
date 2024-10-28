package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.DetalleFactura;
import com.BackendF.BackendSolution.Repository.IDetalleFacturaServices;
import com.BackendF.BackendSolution.Repository.DetalleFacturaRepository;
import java.util.HashMap;
import java.util.List;

@Service
public class DetalleFacturaServices implements IDetalleFacturaServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleFacturaServices.class);

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public DetalleFactura creaDetalle(DetalleFactura detalleFactura) {
        try{
            return detalleFacturaRepository.save(detalleFactura);
        }catch(Exception e){
            LOGGER.error("Error craeting detalle: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
        
    } 
    @Override
    public HashMap<String, String> deleteDetallle(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            detalleFacturaRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }
    @Override 
    public List<DetalleFactura> getAllDetalle() {
        try{
            return detalleFacturaRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while clientes:{}", e.getMessage());
            throw new RuntimeException("Error fetching detalle");
        }
    }
    @Override
    public DetalleFactura updateDetalles(DetalleFactura detalleFactura) {
        if(detalleFacturaRepository.existsById(detalleFactura.getIDDetalle())){
            return detalleFacturaRepository.save(detalleFactura);
        }else{
            LOGGER.error("Detalle no encontrado con ID: {}",detalleFactura.getIDDetalle());
            throw new RuntimeException("Detalle no encontrado");
        }
    }
}