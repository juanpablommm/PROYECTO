package com.example.proyectoinventario;

public class Usuarios {


    private String nombre_Usuario;
    private String apellido_Usuario;
    private String cedula_Usuario;
    private String telefono_Usuario;
    private String correo_Usuario;
    private String contrasena_Usuario;
    private String idUsuario;
    private String rol_Usuario;

    public Usuarios(String nombre_Usuario, String apellido_Usuario,
                    String cedula_Usuario, String telefono_Usuario, String correo_Usuario,
                    String contrasena_Usuario, String idUsuario, String rol_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
        this.apellido_Usuario = apellido_Usuario;
        this.cedula_Usuario = cedula_Usuario;
        this.telefono_Usuario = telefono_Usuario;
        this.correo_Usuario = correo_Usuario;
        this.contrasena_Usuario = contrasena_Usuario;
        this.idUsuario = idUsuario;
        this.rol_Usuario = rol_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getApellido_Usuario() {
        return apellido_Usuario;
    }

    public void setApellido_Usuario(String apellido_Usuario) {
        this.apellido_Usuario = apellido_Usuario;
    }

    public String getCedula_Usuario() {
        return cedula_Usuario;
    }

    public void setCedula_Usuario(String cedula_Usuario) {
        this.cedula_Usuario = cedula_Usuario;
    }

    public String getTelefono_Usuario() {
        return telefono_Usuario;
    }

    public void setTelefono_Usuario(String telefono_Usuario) {
        this.telefono_Usuario = telefono_Usuario;
    }

    public String getCorreo_Usuario() {
        return correo_Usuario;
    }

    public void setCorreo_Usuario(String correo_Usuario) {
        this.correo_Usuario = correo_Usuario;
    }

    public String getContrasena_Usuario() {
        return contrasena_Usuario;
    }

    public void setContrasena_Usuario(String contrasena_Usuario) {
        this.contrasena_Usuario = contrasena_Usuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRol_Usuario() {
        return rol_Usuario;
    }

    public void setRol_Usuario(String rol_Usuario) {
        this.rol_Usuario = rol_Usuario;
    }
}