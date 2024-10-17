package com.BackendF.BackendSolution.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ID_Ben", "nombre", "apellido", "cedula" , "telefono" , "ID_Con"})

@Entity
@Getter
@Setter

public class Beneficiarios {

@Id
@JsonProperty("ID_Ben")//Transicion de variables
private int IDBeneficiarios;

@JsonProperty("nombre")
private String Nombre;

@JsonProperty("apellido")
private String Apellido;

@JsonProperty("cedula")
private String Cedula;

@JsonProperty("telefono")
private int Telefono;

@JsonProperty("ID_Con")
private int IDContratos;

public Beneficiarios(){

}

public Beneficiarios(String nombre, String apellido, String cedula,int telefono, Integer ID_Con){
    this.Nombre=nombre;
    this.Apellido=apellido;
    this.Cedula=cedula;
    this.Telefono=telefono; 
    this.IDContratos=ID_Con;
}

public Beneficiarios(Integer ID_Ben, String nombre, String apellido, String cedula, int telefono, Integer ID_Con){
    this.IDBeneficiarios=ID_Ben;
    this.Nombre=nombre;
    this.Apellido=apellido;
    this.Cedula=cedula;
    this.Telefono=telefono;
    this.IDContratos=ID_Con;
}
}
