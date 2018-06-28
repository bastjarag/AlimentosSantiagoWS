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
public class DetallePedido {
    public int id;
    public int idPedido;
    public int idProducto;
    public int cantidadProductos;
    public int totalPedido;

    public DetallePedido(int idPedido, int idProducto, int cantidadProductos, int totalPedido) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidadProductos = cantidadProductos;
        this.totalPedido = totalPedido;
    }

    public DetallePedido(int id, int idPedido, int idProducto, int cantidadProductos, int totalPedido) {
        this.id = id;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidadProductos = cantidadProductos;
        this.totalPedido = totalPedido;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(int totalPedido) {
        this.totalPedido = totalPedido;
    }
}
