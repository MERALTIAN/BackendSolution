package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ID_Clien", "nombre", "apellidos", "direccion", "cedula", "telefono"})

@Entity
@Getter
@Setter

public class Clientes {
    @Id
    @JsonProperty("ID_Clien")
    private int IDCliente;

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("apellidos")
    private String Apellido;

    @JsonProperty("direccion")
    private String Direccion;

    @JsonProperty("cedula")
    private String Cedula;

    @JsonProperty("telefono")
    private String Telefono;

    public Clientes(){

    }

    public Clientes(String nombre, String apellidos, String direccion, String cedula, String telefono){
        this.Nombre = nombre;
        this.Apellido = apellidos;
        this.Direccion = direccion;
        this.Cedula = cedula;
        this.Telefono = telefono;
    }

    public Clientes(Integer ID_Clien,String nombre,String apellidos,String direccion,String cedula,String telefono){
        this.IDCliente = ID_Clien;
        this.Nombre = nombre;
        this.Apellido = apellidos;
        this.Direccion = direccion;
        this.Cedula = cedula;
        this.Telefono = telefono;
    }

}
