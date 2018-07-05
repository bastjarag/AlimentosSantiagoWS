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
public class Menu {
    public int id;
    public Date fechaCreacion;
    public int idUsuario;
    public Date fechaPublicacion;

    public Menu() {
    }

    public Menu(Date fechaCreacion, int idUsuario, Date fechaPublicacion) {
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Menu(int id, Date fechaCreacion, int idUsuario, Date fechaPublicacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.fechaPublicacion = fechaPublicacion;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    
}
