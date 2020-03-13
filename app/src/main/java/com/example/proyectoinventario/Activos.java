package com.example.proyectoinventario;

public class Activos {

    String Idactivo;
    String NombreActivo;
    String CantidadActivo;
    String MarcaActivo;
    String SerialActivo;


    public Activos(String idactivo, String nombreActivo, String cantidadActivo, String marcaActivo, String serialActivo) {
        Idactivo = idactivo;
        NombreActivo = nombreActivo;
        CantidadActivo = cantidadActivo;
        MarcaActivo = marcaActivo;
        SerialActivo = serialActivo;
    }


    public String getIdactivo() {
        return Idactivo;
    }

    public String getNombreActivo() {
        return NombreActivo;
    }

    public String getCantidadActivo() {
        return CantidadActivo;
    }

    public String getMarcaActivo() {
        return MarcaActivo;
    }

    public String getSerialActivo() {
        return SerialActivo;
    }
}
