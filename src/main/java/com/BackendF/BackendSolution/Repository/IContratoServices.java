package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Contrato;
import java.util.HashMap;


public interface IContratoServices {
        public Contrato creaContrato(Contrato contrato);

    public HashMap<String, String> deletecontrato(int Id);

    public List<Contrato> getAllContrato(); //Metodo para listar

    public Contrato updateContrato(Contrato contrato);

}
