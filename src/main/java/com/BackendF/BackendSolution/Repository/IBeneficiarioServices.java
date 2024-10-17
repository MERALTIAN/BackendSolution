package com.BackendF.BackendSolution.Repository;

import java.util.List;
import com.BackendF.BackendSolution.Models.Beneficiarios;
import java.util.HashMap;

public interface IBeneficiarioServices {

    public Beneficiarios creaBeneficiarios(Beneficiarios beneficiarios); //Metodo para crear

    public HashMap<String, String> deleteBeneficiario(int Id); //Metodo para eliminar

    public List<Beneficiarios> getAllBeneficiarios(); //Metodo para listar

    public Beneficiarios updateBeneficiarios(Beneficiarios beneficiarios); //Metodo para actualizar

}
