package com.example.proyectoinventario.ui.ClasesJava;

import androidx.annotation.NonNull;

public class Usuarios {

    private String Nombre_Usuario;
    private String Apellido_Usuario;
    private String Cedula_Usuario;
    private String Telefono_Usuario;
    private String Correo_Usuario;
    private String Contrasena_Usuario;
    private String Rol_Usuario;
    private String idUsuario;

    public Usuarios(String nombre_Usuario, String apellido_Usuario, String cedula_Usuario, String telefono_Usuario, String correo_Usuario, String contrasena_Usuario, String rol_Usuario, String idUsuario) {
        Nombre_Usuario = nombre_Usuario;
        Apellido_Usuario = apellido_Usuario;
        Cedula_Usuario = cedula_Usuario;
        Telefono_Usuario = telefono_Usuario;
        Correo_Usuario = correo_Usuario;
        Contrasena_Usuario = contrasena_Usuario;
        Rol_Usuario = rol_Usuario;
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return Apellido_Usuario;
    }

    public void setApellido_Usuario(String apellido_Usuario) {
        Apellido_Usuario = apellido_Usuario;
    }

    public String getCedula_Usuario() {
        return Cedula_Usuario;
    }

    public void setCedula_Usuario(String cedula_Usuario) {
        Cedula_Usuario = cedula_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String telefono_Usuario) {
        Telefono_Usuario = telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return Correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        Correo_Usuario = correo_Usuario;
    }

    public String getContrasena_Usuario() {
        return Contrasena_Usuario;
    }

    public void setContrasena_Usuario(String contrasena_Usuario) {
        Contrasena_Usuario = contrasena_Usuario;
    }

    public String getRol_Usuario() {
        return Rol_Usuario;
    }

    public void setRol_Usuario(String rol_Usuario) {
        Rol_Usuario = rol_Usuario;
    }

    public Usuarios() {
    }

    public Usuarios(String nombre_Usuario, String apellido_Usuario, String cedula_Usuario, String telefono_Usuario, String correo_Usuario, String contrasena_Usuario, String rol_Usuario) {
        Nombre_Usuario = nombre_Usuario;
        Apellido_Usuario = apellido_Usuario;
        Cedula_Usuario = cedula_Usuario;
        Telefono_Usuario = telefono_Usuario;
        Correo_Usuario = correo_Usuario;
        Contrasena_Usuario = contrasena_Usuario;
        Rol_Usuario = rol_Usuario;
    }
}