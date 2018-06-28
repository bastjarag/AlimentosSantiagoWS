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
public class Factura {
    public int id;
    public Date fechaFactura;
    public int idPedido;
    public int totalFactura;

    public Factura(Date fechaFactura, int idPedido, int totalFactura) {
        this.fechaFactura = fechaFactura;
        this.idPedido = idPedido;
        this.totalFactura = totalFactura;
    }

    public Factura(int id, int idPedido, Date fechaFactura, int totalFactura) {
        this.id = id;
        this.idPedido = idPedido;
        this.fechaFactura = fechaFactura;
        this.totalFactura = totalFactura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }
}
