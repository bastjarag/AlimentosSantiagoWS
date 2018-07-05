/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadTemporal;

import Entidades.Menu;
import Entidades.Pedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Basti
 */
public class PedidoTemp {

    public int id;
    public boolean retiroTienda;
    public String fechaHora;
    public String comentario;
    public int idEstado;
    public int idUsuario;
    public int totalCompra;

    public PedidoTemp() {
    }

    public PedidoTemp(int id, boolean retiroTienda, String fechaHora, String comentario, int idEstado, int idUsuario, int totalCompra) {
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

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
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

    public Pedido ToPedido() {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        Pedido pedido = null;
        try {
            pedido = new Pedido(this.id, retiroTienda, df.parse(fechaHora), comentario, idEstado, idUsuario, totalCompra);
        } catch (ParseException exc) {
            System.err.println(exc);
        }
        return pedido;
    }
}
