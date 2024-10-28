package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDFac", "IDAgen", "IDCon", "cuotas", "monto_dec"})

@Entity
@Getter
@Setter

public class Factura {
    @Id
    @JsonProperty("IDFac")
    private int IDFactura;

    @JsonProperty("IDAgen")
    private int IDAgente_co;

    @JsonProperty("IDCon")
    private int IDContrato;

    @JsonProperty ("cuotas")
    private int Cuotas;

    @JsonProperty("monto_dec")
    private int Monto_DEC;

    public Factura(){

    }
    public Factura (Integer  IDAgen, Integer IDCon, Integer cuotas, Integer monto_dec){
        this.IDAgente_co = IDAgen;
        this.IDContrato = IDCon;
        this.Cuotas = cuotas;
        this.Monto_DEC = monto_dec;
    }

    public Factura (Integer IDFac, Integer IDAgen, Integer IDCon, Integer cuotas, Integer monto_dec){
        this.IDFactura = IDFac;
        this.IDAgente_co = IDAgen;
        this.IDContrato = IDCon;
        this.Cuotas = cuotas;
        this.Monto_DEC = monto_dec;
    }
}
