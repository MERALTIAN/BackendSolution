package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDDet", "numfac", "agentes", "cliente", "fac_IDfac"})

@Entity
@Getter
@Setter

public class DetalleFactura {
    @Id
    @JsonProperty("IDDet")
    private int IDDetalle;

    @JsonProperty("numfac")
    private int numFacturas;

    @JsonProperty("agentes")
    private String Agentes;

    @JsonProperty("cliente")
    private String Cliente;

    @JsonProperty ("fac_IDfac")
    private int factura_IDFactura;

    public DetalleFactura(){

    }

    public DetalleFactura(Integer numfac, String agentes, String cliente, Integer fac_IDfac){
        this.numFacturas = numfac;
        this.Agentes = agentes;
        this.Cliente = cliente;
        this.factura_IDFactura = fac_IDfac;
    }

    public DetalleFactura(Integer IDDet, Integer numfac, String agentes, String cliente, Integer fac_IDfac){
        this.IDDetalle = IDDet;
        this.numFacturas = numfac;
        this.Agentes = agentes; 
        this.Cliente = cliente; 
        this.factura_IDFactura = fac_IDfac;
    }

}
