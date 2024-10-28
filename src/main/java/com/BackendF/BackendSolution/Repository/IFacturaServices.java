package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Factura;
import java.util.HashMap;


public interface IFacturaServices {
    public Factura creaFacturas(Factura factura);

    public HashMap<String, String> deletefactura(int Id);

    public List<Factura> getAllFActuras(); //Metodo para listar

    public Factura updateFacturas(Factura factura);

}
