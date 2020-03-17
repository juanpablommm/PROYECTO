package com.example.proyectoinventario.ui.ClasesJava;

import android.widget.EditText;

public class Inventario {

    private String idInventario;;
    private String Instructor;
    private String Ape;
    private String Materiales;
    private String CantidadMaterial;
    private String Equipos;
    private String CantidadEquipos;
    private  String Herramimientas;
    private String CantidadHerramientas;
    //private String Spinner_Prestamo;


    public Inventario(String id,String instructor,String ape,String materiales,
                      String cantidadMaterial,String equipos,String cantidadEquipos,
                      String herramimientas,String cantidadHerramientas) {
        this.idInventario = idInventario;
        Instructor = instructor;
        Ape = ape;
        Materiales = materiales;
        CantidadMaterial = cantidadMaterial;
        Equipos = equipos;
        CantidadEquipos = cantidadEquipos;
        Herramimientas = herramimientas;
        CantidadHerramientas = cantidadHerramientas;

    }
    public String getIdInventario() {
        return idInventario;
    }

    public String getInstructor() {
        return Instructor;
    }

    public String getApe() {
        return Ape;
    }

    public String getMateriales() {
        return Materiales;
    }

    public String getCantidadMaterial() {
        return CantidadMaterial;
    }

    public String getEquipos() {
        return Equipos;
    }

    public String getCantidadEquipos() {
        return CantidadEquipos;
    }

    public String getHerramimientas() {
        return Herramimientas;
    }

    public String getCantidadHerramientas() {
        return CantidadHerramientas;
    }

    //public String getSpinner_Prestamo() { return Spinner_Prestamo; }

}
