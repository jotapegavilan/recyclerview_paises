package com.gavilan.septiembre_14.models;

import java.io.Serializable;
import java.util.Objects;

public class Pais implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return nombre.equals(pais.nombre) &&
                continente.equals(pais.continente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, continente);
    }
}
