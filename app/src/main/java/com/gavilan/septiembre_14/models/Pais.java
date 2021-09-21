package com.gavilan.septiembre_14.models;

public class Pais {
    private String nombre;
    private String continente;

    public Pais(String nombre, String continente) {
        this.nombre = nombre;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
