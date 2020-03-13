package com.example.proyectoinventario.ui;

public class Prestamo {
    private String idPrestamo;
    private String Nombre_Prestamo;
    private String Serial_Prestamo;
    private String Marca_Prestamo;
    private String Cantidad_Prestamo;
    private String Spinner_Prestamo;


    public Prestamo(String idPrestamo, String nombre_Prestamo, String serial_Prestamo, String marca_Prestamo, String cantidad_Prestamo) {
        this.idPrestamo = idPrestamo;
        Nombre_Prestamo = nombre_Prestamo;
        Serial_Prestamo = serial_Prestamo;
        Marca_Prestamo = marca_Prestamo;
        Cantidad_Prestamo = cantidad_Prestamo;
        
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public String getNombre_Prestamo() {
        return Nombre_Prestamo;
    }

    public String getSerial_Prestamo() {
        return Serial_Prestamo;
    }

    public String getMarca_Prestamo() {
        return Marca_Prestamo;
    }

    public String getCantidad_Prestamo() {
        return Cantidad_Prestamo;
    }

    public String getSpinner_Prestamo() {
        return Spinner_Prestamo;
    }
}

