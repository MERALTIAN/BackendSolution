package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.DetalleFactura;
import java.util.HashMap;


public interface IDetalleFacturaServices {
    public DetalleFactura creaDetalle(DetalleFactura detalleFactura);

    public HashMap<String, String> deleteDetallle(int Id);

    public List<DetalleFactura> getAllDetalle(); //Metodo para listar

    public DetalleFactura updateDetalles(DetalleFactura detalleFactura);//Metodo Actualizar
}
