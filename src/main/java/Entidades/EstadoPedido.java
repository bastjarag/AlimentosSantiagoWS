/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Sebastián
 */
@XmlRootElement
@XmlType(propOrder = {"id", "descripcion"})
public class EstadoPedido {
    private int id;
    private String descripcion;

    public EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoPedido(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
}
