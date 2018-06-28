/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián
 */
public class EmpresaConvenio {
    public int id;
    public int saldoMes, telefono, celular;
    public String direccion, urlPlanilla, urlContrato, nombre;
    public boolean convenio;
    
    public EmpresaConvenio() {
        
    }

    public EmpresaConvenio(int saldoMes, int telefono, int celular, String direccion, String nombre) {
        this.saldoMes = saldoMes;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public EmpresaConvenio(int saldoMes, int telefono, int celular, String direccion, String urlPlanilla, String urlContrato, String nombre) {
        this.saldoMes = saldoMes;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.urlPlanilla = urlPlanilla;
        this.urlContrato = urlContrato;
        this.nombre = nombre;
    }

    public EmpresaConvenio(int id, int saldoMes, int telefono, int celular, String direccion, String urlPlanilla, String urlContrato, String nombre) {
        this.id = id;
        this.saldoMes = saldoMes;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.urlPlanilla = urlPlanilla;
        this.urlContrato = urlContrato;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldoMes() {
        return saldoMes;
    }

    public void setSaldoMes(int saldoMes) {
        this.saldoMes = saldoMes;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlPlanilla() {
        return urlPlanilla;
    }

    public void setUrlPlanilla(String urlPlanilla) {
        this.urlPlanilla = urlPlanilla;
    }

    public String getUrlContrato() {
        return urlContrato;
    }

    public void setUrlContrato(String urlContrato) {
        this.urlContrato = urlContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
