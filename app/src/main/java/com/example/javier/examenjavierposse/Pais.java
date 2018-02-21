package com.example.javier.examenjavierposse;

import java.util.ArrayList;

/**
 * Created by Javier on 21/02/2018.
 */

public class Pais {

    public String nombreIngles, nombreCastellano, clave, capital, continente, poblacion, lat, lon, paisesFront;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais(){

    }

    public Pais(String nombreIngles, String nombreCastellano, String clave, String capital, String continente, String poblacion, String lat, String lon,String paisesFront) {
        this.nombreIngles = nombreIngles;
        this.nombreCastellano = nombreCastellano;
        this.clave = clave;
        this.capital = capital;
        this.continente = continente;
        this.poblacion = poblacion;
        this.lat = lat;
        this.lon = lon;
        this.paisesFront = paisesFront;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getNombreCastellano() {
        return nombreCastellano;
    }

    public void setNombreCastellano(String nombreCastellano) {
        this.nombreCastellano = nombreCastellano;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getPaisesFront() {

        return paisesFront;
    }

    public void setPaisesFront(String paisesFront) {
        this.paisesFront = paisesFront;
    }
}
