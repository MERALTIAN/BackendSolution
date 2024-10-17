package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDAge", "nombre", "telefono"})

@Entity
@Getter
@Setter

public class Agente_Co {
    @Id
    @JsonProperty("IDAge")
    private int IDAgente_co;

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("telefono")
    private String Telefono;

    public Agente_Co(){

    }

    public Agente_Co(String nombre, String telefono){
        this.Nombre = nombre;
        this.Telefono = telefono;
    }

    public Agente_Co(Integer IDAge, String nombre, String telefono){
        this.IDAgente_co = IDAge;
        this.Nombre = nombre;
        this.Telefono = telefono;

    }
}
