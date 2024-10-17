package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Agente_Co;
import java.util.HashMap;

public interface IAgente_CoServices {
    public Agente_Co creaAgente(Agente_Co agente_Co);

    public HashMap<String, String> deleteAgente(int Id);

    public List<Agente_Co> getAllAgente(); //Metodo para listar

    public Agente_Co updateAgente(Agente_Co agente_Co);

}
