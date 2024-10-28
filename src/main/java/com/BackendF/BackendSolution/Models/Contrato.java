package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDContra", "estado", "Cantidad", "cuotas", "monto", "idcliente"})

@Entity
@Getter
@Setter

public class Contrato {
    @Id
    @JsonProperty("IDContra")
    private int IDContrato;

    @JsonProperty("estado")
    private String Estado;

    @JsonProperty("Cantidad")
    private String Cantidad_Beneficiarios;

    @JsonProperty("cuotas")
    private String Cuotas;

    @JsonProperty("monto")
    private String Monto;

    @JsonProperty("idcliente")
    private int IDCliente;

    public Contrato(){

    }

    public Contrato(String estado, String Cantidad, String cuotas, String monto, Integer idcliente){
        this.Estado = estado;
        this.Cantidad_Beneficiarios = Cantidad;
        this.Cuotas = cuotas;
        this.Monto = monto;
        this.IDCliente = idcliente;
    }

    public Contrato(Integer IDContra, String estado, String Cantidad, String cuotas, 
    String monto, Integer idcliente){
        this.IDContrato = IDContra;
        this.Estado = estado;
        this.Cantidad_Beneficiarios = Cantidad;
        this.Cuotas = cuotas;
        this.Monto = monto;
        this.IDCliente = idcliente;
    }
}
