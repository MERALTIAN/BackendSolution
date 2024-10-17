package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Modelos;
import java.util.HashMap;

public interface IModelosServices {

    public Modelos creaModelos(Modelos modelos);

    public HashMap<String, String> deleteModelos(int Id);

    public List<Modelos> getAllModelos();

    public Modelos updateModelos(Modelos modelos);

}
