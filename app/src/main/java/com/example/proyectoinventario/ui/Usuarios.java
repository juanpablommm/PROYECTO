package com.example.proyectoinventario.ui;

import androidx.annotation.NonNull;

public class Usuarios {

    private String Nombre_Usuario;
    private String Apellido_Usuario;
    private String Cedula_Usuario;
    private String Telefono_Usuario;
    private String Correo_Usuario;
    private String Contrasena_Usuario;
    private String Rol_Usuario;

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_usuario) {
        Nombre_Usuario = Nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return Apellido_Usuario;
    }

    public void setApellido_Usuario(String apellido_Usuario) {
        this.Apellido_Usuario = Apellido_Usuario;
    }

    public String getCedula_Usuario() {
        return Cedula_Usuario;
    }

    public void setCedula_Usuario(String cedula_Usuario) {
        this.Cedula_Usuario = Cedula_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String telefono_Usuario) {
        this.Telefono_Usuario = telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.Correo_Usuario = Correo_Usuario;
    }

    public String getContrasena_Usuario() {
        return Contrasena_Usuario;
    }

    public void setContrasena_Usuario(String contrasena_Usuario) {
        this.Contrasena_Usuario = Contrasena_Usuario;
    }

    public String getRol_Usuario() {
        return Rol_Usuario;
    }

    public void setRol_Usuario(String rol_Usuario) {
        this.Rol_Usuario = rol_Usuario;
    }

    public Usuarios() {
    }

    public Usuarios(String nombre_Usuario,String apellido_Usuario,String cedula_Usuario,String telefono_Usuario,
                    String correo_Usuario,String contrasena_Usuario,String rol_Usuario) {
        Cedula_Usuario = cedula_Usuario;
        this.Nombre_Usuario = nombre_Usuario;
        this.Apellido_Usuario = apellido_Usuario;
        this.Telefono_Usuario = telefono_Usuario;
        this.Correo_Usuario = correo_Usuario;
        this.Contrasena_Usuario = contrasena_Usuario;
        this.Rol_Usuario = rol_Usuario;
    }
}