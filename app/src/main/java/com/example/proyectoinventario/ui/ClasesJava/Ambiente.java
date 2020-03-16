package com.example.proyectoinventario.ui.ClasesJava;

public class Ambiente {

    private String idAmbienete;
    private String Nombre_Ambiente;
    private String Codigo_Ambiente;
    private String Zona_Ambiente;


    public Ambiente(String idAmbienete, String nombre_Ambiente, String codigo_Ambiente, String zona_Ambiente) {
        this.idAmbienete = idAmbienete;
        Nombre_Ambiente = nombre_Ambiente;
        Codigo_Ambiente = codigo_Ambiente;
        Zona_Ambiente = zona_Ambiente;
    }

    public String getIdAmbienete() {
        return idAmbienete;
    }

    public String getNombre_Ambiente() {
        return Nombre_Ambiente;
    }

    public String getCodigo_Ambiente() {
        return Codigo_Ambiente;
    }

    public String getZona_Ambiente() {
        return Zona_Ambiente;
    }
}
