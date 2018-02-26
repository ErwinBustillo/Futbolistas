package com.edu.uninorte.futbolistas;

import java.io.Serializable;

/**
 * Created by Visitante on 26/02/2018.
 */

public class Jugador implements Serializable {
    public String nombre;
    public String apellido;
    public String posicion;
    public String candidato;
    public int id;
    public int edad;

    public Jugador(int id,String nombre, String apellido, String posicion, String candidato,int edad) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.candidato = candidato;
        this.edad=edad;
    }
}
