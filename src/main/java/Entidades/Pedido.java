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
public class Pedido {
    public int id;
    public boolean retiroTienda;
    public Date fechaHora;
    public String comentario;
    public int idEstado;
    public int idUsuario;
    public int totalCompra;

    public Pedido(boolean retiroTienda, Date fechaHora, String comentario, int idEstado, int idUsuario, int totalCompra) {
        this.retiroTienda = retiroTienda;
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.idEstado = idEstado;
        this.idUsuario = idUsuario;
        this.totalCompra = totalCompra;
    }

    public Pedido(int id, boolean retiroTienda, Date fechaHora, String comentario, int idEstado, int idUsuario, int totalCompra) {
        this.id = id;
        this.retiroTienda = retiroTienda;
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.idEstado = idEstado;
        this.idUsuario = idUsuario;
        this.totalCompra = totalCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRetiroTienda() {
        return retiroTienda;
    }

    public void setRetiroTienda(boolean retiroTienda) {
        this.retiroTienda = retiroTienda;
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

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }
    
    
}
