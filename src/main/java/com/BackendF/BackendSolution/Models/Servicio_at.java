package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDSer", "codigo", "monto"})

@Entity
@Getter
@Setter

public class Servicio_at {
    @Id
    @JsonProperty("IDSer")
    private int IDServicio_At;

    @JsonProperty("codigo")
    private String Codigo_de_Modelo;

    @JsonProperty("monto")
    private int Monto;

    @JsonProperty("IDMod")
    private int IDModelo;

    @JsonProperty("IDCon")
    private int IDContrato;

    public Servicio_at(){
    }

    public Servicio_at(String codigo, Integer monto, Integer IDMod, Integer IDCon){
        this.Codigo_de_Modelo = codigo;
        this.Monto = monto;
        this.IDModelo = IDMod;
        this.IDContrato = IDCon;
    }

    public Servicio_at(Integer IDSer, String codigo, Integer monto, Integer IDMod, Integer IDCon){
        this.IDServicio_At = IDSer;
        this.Codigo_de_Modelo = codigo; 
        this.Monto = monto;
        this.IDModelo = IDMod;
        this.IDContrato = IDCon;
    }

}
