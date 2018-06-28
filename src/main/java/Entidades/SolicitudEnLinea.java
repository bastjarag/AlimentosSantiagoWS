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
public class SolicitudEnLinea {
    public int id;
    public Date fechaHora;
    public String comentario;
    public int idUsuario;

    public SolicitudEnLinea(Date fechaHora, String comentario, int idUsuario) {
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
    }

    public SolicitudEnLinea(int id, Date fechaHora, String comentario, int idUsuario) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
