package com.BackendF.BackendSolution.Services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.BackendF.BackendSolution.Models.Clientes;
import com.BackendF.BackendSolution.Repository.ClienteRepository;
import com.BackendF.BackendSolution.Repository.IClienteServices;
import java.util.HashMap;
import java.util.List;

@Service
public class ClientesServices implements IClienteServices{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientesServices.class);

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Clientes creaClientes(Clientes clientes) {
        try{
            return clienteRepository.save(clientes);
        }catch(Exception e){
            LOGGER.error("Error craeting cliente: {}",e.getMessage());
            throw new RuntimeException("Error creating user");
        }
        
    } 


    @Override
    public HashMap<String, String> deleteclinetes(int Id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("messege","User deleted succesfully!");
            clienteRepository.deleteById(Id);
            return response;
        }catch(Exception e){
            LOGGER.error("Error while deleting user: {}", e.getMessage());
            throw new RuntimeException("Error deleting user");
        }
        
    }
    @Override 
    public List<Clientes> getAllClientes() {
        try{
            return clienteRepository.findAll();
        }catch(Exception e){
            LOGGER.error("Error while clientes:{}", e.getMessage());
            throw new RuntimeException("Error fetching cliente");
        }
    }

    @Override
    public Clientes updateClientes(Clientes clientes) {
        if(clienteRepository.existsById(clientes.getIDCliente())){
            return clienteRepository.save(clientes);
        }else{
            LOGGER.error("Cliente no encontrado con ID: {}",clientes.getIDCliente());
            throw new RuntimeException("Clinete no encontrado");
        }
    }
    

}
