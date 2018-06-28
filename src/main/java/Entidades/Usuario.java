/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Sebastián
 */
public class Usuario {
    public int id;
    public String usuario;
    public String password;
    public String nombre, apellPaterno, apellMaterno;
    public Date fechaRegistro;
    public int rut;
    public char divRut;
    public String direccion;
    public int telefono, celular;
    public String email;
    public int cartera;

    public Usuario() {
        
    }
    
    public Usuario(Date fechaRegistro, String nombre, String apellPaterno, String apellMaterno, int rut, char divRut, String direccion, int telefono, int celular, String email, String usuario, String password, int cartera) {
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
        this.apellPaterno = apellPaterno;
        this.apellMaterno = apellMaterno;
        this.rut = rut;
        this.divRut = divRut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.cartera = cartera;
    }
    
    public Usuario(int id, Date fechaRegistro, String nombre, String apellPaterno, String apellMaterno, int rut, char divRut, String direccion, int telefono, int celular, String email, String usuario, String password, int cartera) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.nombre = nombre;
        this.apellPaterno = apellPaterno;
        this.apellMaterno = apellMaterno;
        this.rut = rut;
        this.divRut = divRut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.cartera = cartera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellPaterno() {
        return apellPaterno;
    }

    public void setApellPaterno(String apellPaterno) {
        this.apellPaterno = apellPaterno;
    }

    public String getApellMaterno() {
        return apellMaterno;
    }

    public void setApellMaterno(String apellMaterno) {
        this.apellMaterno = apellMaterno;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDivRut() {
        return divRut;
    }

    public void setDivRut(char divRut) {
        this.divRut = divRut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMonedero() {
        return cartera;
    }

    public void setMonedero(int monedero) {
        this.cartera = monedero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCartera() {
        return cartera;
    }

    public void setCartera(int cartera) {
        this.cartera = cartera;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", nombre=" + nombre + ", apellPaterno=" + apellPaterno + ", apellMaterno=" + apellMaterno + ", rut=" + rut + ", divRut=" + divRut + ", direccion=" + direccion + ", telefono=" + telefono + ", celular=" + celular + ", email=" + email + ", usuario=" + usuario + ", password=" + password + ", cartera=" + cartera + '}';
    }
    
    
}
