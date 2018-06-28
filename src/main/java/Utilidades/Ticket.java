/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Date;

/**
 *
 * @author Sebastián
 */
public class Ticket {
    public int id;
    public int idUSuario;
    public Date fechaCreacion;
    public Date fechaExpiracion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUSuario() {
        return idUSuario;
    }

    public void setIdUSuario(int idUSuario) {
        this.idUSuario = idUSuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
    
}
