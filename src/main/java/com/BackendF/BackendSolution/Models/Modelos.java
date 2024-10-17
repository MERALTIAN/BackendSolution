package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"IDMod", "nombre", "modelo", "medida", "color"})

@Entity
@Getter
@Setter


public class Modelos {
    @Id
    @JsonProperty("IDMod")
    private int IDModelo;

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("modelo")
    private String Modelo;

    @JsonProperty("medida")
    private String Medida;

    @JsonProperty("color")
    private String Color;


    public Modelos(){
    }

    public Modelos(String nombre, String modelo, String medida, String color){
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.Medida = medida;
        this.Color = color;
    }

    public Modelos(Integer IDMod, String nombre, String modelo, String medida, String color){
        this.IDModelo = IDMod;
        this.Nombre = nombre;
        this.Modelo = modelo;
        this.Medida = medida;
        this.Color = color;
    }
}

