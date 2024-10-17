package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Clientes;
import java.util.HashMap;


public interface IClienteServices {
    public Clientes creaClientes(Clientes clientes);

    public HashMap<String, String> deleteclinetes(int Id);

    public List<Clientes> getAllClientes(); //Metodo para listar

    public Clientes updateClientes(Clientes clientes);

}
