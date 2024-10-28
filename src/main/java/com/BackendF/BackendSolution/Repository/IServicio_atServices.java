package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Servicio_at;
import java.util.HashMap;


public interface IServicio_atServices {
    public Servicio_at creaServicio(Servicio_at servicio_at);

    public HashMap<String, String> deleteServicio(int Id);

    public List<Servicio_at> getAllServicio(); //Metodo para listar

    public Servicio_at updateServicio(Servicio_at servicio_at);
}
